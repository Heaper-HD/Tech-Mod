package net.heaper.tech_mod.command;

import com.mojang.brigadier.CommandDispatcher;
import net.heaper.tech_mod.component.ModDataComponentsType;
import net.heaper.tech_mod.compound.CompoundComponent;
import net.heaper.tech_mod.element.ElementComponent;
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

            boolean hasElements = stack.contains(ModDataComponentsType.ELEMENTS_COMPONENT);
            boolean hasCompounds = stack.contains(ModDataComponentsType.COMPOUNDS_COMPONENT);

            if (!hasElements && !hasCompounds) context.getSource().sendFeedback(() -> Text.literal("No chemical build components found."), false);;

            if (hasElements) {
                if (stack.get(ModDataComponentsType.ELEMENTS_COMPONENT).size() > 1)
                    context.getSource().sendFeedback(() -> Text.literal("Elements found!"), false);
                else context.getSource().sendFeedback(() -> Text.literal("Element found!"), false);

                List<ElementComponent> elements = stack.get(ModDataComponentsType.ELEMENTS_COMPONENT);
                for (int i = 0; i < elements.size(); i++) {
                    ElementComponent element = elements.get(i);
                    PurityLevel purityLevel = element.getPurity();
                    String purityStr = switch (purityLevel) {
                        case NORMAL -> "Normal";
                        case IMPURE -> "Impure";
                        case PURE -> "Pure";
                    };
                    context.getSource().sendFeedback(() ->
                            Text.literal(
                                            "Name: " + element.getElement().getName() +
                                            "\nSymbol: " + element.getElement().getSymbol() + " - " + purityStr
                            ), false);
                }
            }
            if (hasCompounds) {
                if (stack.get(ModDataComponentsType.COMPOUNDS_COMPONENT).size() > 1)
                    context.getSource().sendFeedback(() -> Text.literal("Compounds found!"), false);
                else context.getSource().sendFeedback(() -> Text.literal("Compound found!"), false);

                List<CompoundComponent> compounds = stack.get(ModDataComponentsType.COMPOUNDS_COMPONENT);
                for (int i = 0; i < compounds.size(); i++) {
                    CompoundComponent compound = compounds.get(i);
                    PurityLevel purityLevel = compound.getPurity();
                    String purityStr = switch (purityLevel) {
                        case NORMAL -> "Normal";
                        case IMPURE -> "Impure";
                        case PURE -> "Pure";
                    };
                    context.getSource().sendFeedback(() ->
                            Text.literal(
                                    "Name: " + compound.getCompound().getName() +
                                            "\nSymbol: " + compound.getCompound().getSymbol() + " - " + purityStr
                            ), false);
                }
            }
            return 1;
        }));
    }
}
