package net.heaper.tech_mod.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.heaper.tech_mod.compound.Compound;
import net.heaper.tech_mod.compound.Compounds;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class DebugCompounds {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("lookforcompoundby")
                .then(CommandManager.literal("name")
                        .then(CommandManager.argument("name", StringArgumentType.string())
                                .executes(context -> {
                                    String name = StringArgumentType.getString(context, "name");
                                    Compound COMPOUND = Compounds.getByName(name);
                                    if (COMPOUND != null) {
                                        context.getSource().sendFeedback(() ->
                                                Text.literal("Compound Found!\nName: " + COMPOUND.getName() + "\nSymbol: " + COMPOUND.getNormal()), false);
                                        return 1;
                                    } else {
                                        context.getSource().sendFeedback(() ->
                                                Text.literal("Compound not found"), false);
                                        return 0;
                                    }
                                })))
        );
    }
}
