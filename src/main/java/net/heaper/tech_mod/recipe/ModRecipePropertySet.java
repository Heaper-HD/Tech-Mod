package net.heaper.tech_mod.recipe;

import net.heaper.tech_mod.Tech_mod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipePropertySet;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ModRecipePropertySet {
    public static final RegistryKey<? extends Registry<RecipePropertySet>> REGISTRY = RegistryKey.ofRegistry(Identifier.of(Tech_mod.MOD_ID, "recipe_property_set"));
    public static final RegistryKey<RecipePropertySet> PULVERIZER_INPUT = register("pulverizer_input");
    public static final PacketCodec<RegistryByteBuf, ModRecipePropertySet> PACKET_CODEC = Item.ENTRY_PACKET_CODEC
            .collect(PacketCodecs.toList())
            .xmap(items -> new ModRecipePropertySet(Set.copyOf(items)), set -> List.copyOf(set.usableItems));
    private final Set<RegistryEntry<Item>> usableItems;

    private ModRecipePropertySet(Set<RegistryEntry<Item>> usableItem) {
        this.usableItems = usableItem;
    }

    private static RegistryKey<RecipePropertySet> register(String id) {
        return RegistryKey.of(REGISTRY, Identifier.of(Tech_mod.MOD_ID, "id"));
    }

    public boolean canUse(ItemStack stack) {
        return this.usableItems.contains(stack.getRegistryEntry());
    }

    static ModRecipePropertySet of(Collection<Ingredient> ingredients) {
        Set<RegistryEntry<Item>> set = (Set<RegistryEntry<Item>>)ingredients.stream().flatMap(Ingredient::getMatchingItems).collect(Collectors.toUnmodifiableSet());
        return new ModRecipePropertySet(set);
    }

}
