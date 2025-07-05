package net.heaper.tech_mod.item;

import net.heaper.tech_mod.Tech_mod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static Item register (String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        //Creates the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Tech_mod.MOD_ID, name));

        //Creates the item instance
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        //Register the item
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static final Item RAW_URANIUM = register("raw_uranium", Item::new, new Item.Settings());
    public static final Item URANIUM_PELLET = register("uranium_pellet", Item::new, new Item.Settings());
    public static final Item SMALL_URANIUM_PELLET = register("small_uranium_pellet", Item::new, new Item.Settings());
    public static final Item DIRTY_URANIUM_POWDER = register("dirty_uranium_powder", Item::new, new Item.Settings());
    public static final Item URANIUM_POWDER = register("uranium_powder", Item::new, new Item.Settings());
    public static final Item PURIFIED_URANIUM_POWDER = register("purified_uranium_powder", Item::new, new Item.Settings());

    public static void Initialize() {
    }
}
