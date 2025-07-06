package net.heaper.tech_mod.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.heaper.tech_mod.element.Element;
import net.heaper.tech_mod.element.Elements;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class DebugElements {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("lookforelementby")
                .then(CommandManager.literal("name")
                        .then(CommandManager.argument("name", StringArgumentType.string())
                                .executes(context -> {
                                    String name = StringArgumentType.getString(context, "name");
                                    Element ELEMENT = Elements.getByName(name);
                                    if (ELEMENT != null) {
                                        context.getSource().sendFeedback(() ->
                                                Text.literal("Element Found!\nName: " + ELEMENT.getName() + "\nSymbol: " + ELEMENT.getSymbol()), false);
                                        return 1;
                                    } else {
                                        context.getSource().sendFeedback(() ->
                                                Text.literal("Element not found"), false);
                                        return 0;
                                    }
                                })))
                .then(CommandManager.literal("symbol")
                        .then(CommandManager.argument("symbol", StringArgumentType.string())
                                .executes(context -> {
                                    String symbol = StringArgumentType.getString(context, "symbol");
                                    Element ELEMENT = Elements.getBySymbol(symbol);
                                    if (ELEMENT != null) {
                                        context.getSource().sendFeedback(() ->
                                                Text.literal("Element Found!\nName: " + ELEMENT.getName() + "\nSymbol: " + ELEMENT.getSymbol()), false);
                                        return 1;
                                    } else {
                                        context.getSource().sendFeedback(() ->
                                                Text.literal("Element not found"), false);
                                        return 0;
                                    }
                                })))
                );
    }
}
