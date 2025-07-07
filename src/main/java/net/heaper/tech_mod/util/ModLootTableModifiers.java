package net.heaper.tech_mod.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.heaper.tech_mod.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.util.math.random.Random;

import java.util.List;

public class ModLootTableModifiers {
    public static void Initialize() {
        LootTableEvents.MODIFY_DROPS.register((entry,context,stacks) -> {
            if (entry.getKey().equals(Blocks.DIAMOND_ORE.getLootTableKey())) {
                swap(Items.DIAMOND, ModItems.DIAMOND_CRYSTAL, stacks, context);
            }
            if (entry.getKey().equals(Blocks.DEEPSLATE_DIAMOND_ORE.getLootTableKey())) {
                swap(Items.DIAMOND, ModItems.DIAMOND_CRYSTAL, stacks, context);
            }
            if (entry.getKey().equals(Blocks.EMERALD_ORE.getLootTableKey())) {
                swap(Items.EMERALD, ModItems.EMERALD_CRYSTAL, stacks, context);
            }
            if (entry.getKey().equals(Blocks.DEEPSLATE_EMERALD_ORE.getLootTableKey())) {
                swap(Items.EMERALD, ModItems.EMERALD_CRYSTAL, stacks, context);
            }
        });
    }

    private static void swap(Item oldItem, Item newItem, List<ItemStack> list, LootContext context) {
        if (context.get(LootContextParameters.TOOL) == null) return;
        for (int i = 0; i < list.size(); i++) {
            ItemStack originalStack = list.get(i);
            if (originalStack.isOf(oldItem)) {
                ItemStack stack = new ItemStack(newItem, getFortuneDropCount(context));
                list.set(i, stack);
            }
        }
    }

    private static int getFortuneDropCount(LootContext context) {
        ItemStack tool = context.get(LootContextParameters.TOOL);
        int fortuneLevel = EnchantmentHelper.getLevel(tool, Enchantments.FORTUNE);
        Random random = context.getRandom();

        if (fortuneLevel > 0) {
            return 1 + random.nextBetween(0, fortuneLevel);
        }
        return 1;
    }
}
