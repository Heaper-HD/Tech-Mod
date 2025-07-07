package net.heaper.tech_mod.command;

import com.mojang.brigadier.CommandDispatcher;
import net.heaper.tech_mod.component.ModComponents;
import net.heaper.tech_mod.compound.CompoundVariant;
import net.heaper.tech_mod.element.ElementVariant;
import net.heaper.tech_mod.element.PurityLevel;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.List;

public class DebugComponent {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("debugcomponent").executes(context -> {
            ServerPlayerEntity player = context.getSource().getPlayer();
            ItemStack stack = player.getMainHandStack();

            if (stack.contains(ModComponents.ELEMENTS_COMPONENT)) {
                context.getSource().sendFeedback(() -> Text.literal("Element(s) found!"), false);

                List<ElementVariant> variants = stack.get(ModComponents.ELEMENTS_COMPONENT);
                for (ElementVariant elementVariant : variants) {
                    PurityLevel purityLevel = elementVariant.getPurity();
                    String purityStr = switch (purityLevel) {
                        case NORMAL -> "Normal";
                        case IMPURE -> "Impure";
                        case PURE -> "Pure";
                    };
                    context.getSource().sendFeedback(() ->
                            Text.literal(
                                            "Name: " + elementVariant.getElement().getName() +
                                            "\nSymbol: " + elementVariant.getElement().getSymbol() + " - " + purityStr
                            ), false);
                }
            } else if (stack.contains(ModComponents.COMPOUNDS_COMPONENT)) {
                context.getSource().sendFeedback(() -> Text.literal("Compound(s) found!"), false);

                List<CompoundVariant> variants = stack.get(ModComponents.COMPOUNDS_COMPONENT);
                for (CompoundVariant compoundVariant : variants) {
                    PurityLevel purityLevel = compoundVariant.getPurity();
                    String purityStr = switch (purityLevel) {
                        case NORMAL -> "Normal";
                        case IMPURE -> "Impure";
                        case PURE -> "Pure";
                    };
                    context.getSource().sendFeedback(() ->
                            Text.literal(
                                    "Name: " + compoundVariant.getCompound().getName() +
                                            "\nSymbol: " + compoundVariant.getCompound().getSymbol() + " - " + purityStr
                            ), false);
                }
            } else {
                context.getSource().sendFeedback(() -> Text.literal("No chemical build components found."), false);

            }
            return 1;
        }));
    }
}
