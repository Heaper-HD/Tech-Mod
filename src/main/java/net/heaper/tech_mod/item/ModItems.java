package net.heaper.tech_mod.item;

import net.heaper.tech_mod.Tech_mod;
import net.heaper.tech_mod.compound.CompoundComponent;
import net.heaper.tech_mod.compound.Compounds;
import net.heaper.tech_mod.element.ElementComponent;
import net.heaper.tech_mod.element.Elements;
import net.heaper.tech_mod.element.PurityLevel;
import net.heaper.tech_mod.util.ItemComponentHelper;
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

    //Uranium related mod items
    public static final Item RAW_URANIUM = register("raw_uranium", settings ->
            new Item(ItemComponentHelper.withElementsComponent(settings, new ElementComponent(Elements.URANIUM, PurityLevel.IMPURE),
                    new ElementComponent(Elements.X_ELEMENT, PurityLevel.NORMAL))), new Item.Settings());
    public static final Item URANIUM_PELLET = register("uranium_pellet", settings ->
            new Item(ItemComponentHelper.withElementsComponent(settings, new ElementComponent(Elements.URANIUM, PurityLevel.PURE))), new Item.Settings());
    public static final Item SMALL_URANIUM_PELLET = register("small_uranium_pellet", settings ->
            new Item(ItemComponentHelper.withElementsComponent(settings, new ElementComponent(Elements.URANIUM, PurityLevel.PURE))), new Item.Settings());
    public static final Item DIRTY_URANIUM_POWDER = register("dirty_uranium_powder", settings ->
            new Item(ItemComponentHelper.withElementsComponent(settings, new ElementComponent(Elements.URANIUM, PurityLevel.IMPURE))), new Item.Settings());
    public static final Item URANIUM_POWDER = register("uranium_powder", settings ->
            new Item(ItemComponentHelper.withElementsComponent(settings, new ElementComponent(Elements.URANIUM, PurityLevel.NORMAL))), new Item.Settings());
    public static final Item PURIFIED_URANIUM_POWDER = register("purified_uranium_powder", settings ->
            new Item(ItemComponentHelper.withElementsComponent(settings, new ElementComponent(Elements.URANIUM, PurityLevel.PURE))), new Item.Settings());

    //Arentinium related mod items
    public static final Item RAW_ARENTINIUM = register("raw_arentinium", settings ->
            new Item(ItemComponentHelper.withElementsComponent(settings, new ElementComponent(Elements.ARENTINIUM, PurityLevel.IMPURE),
                    new ElementComponent(Elements.X_ELEMENT, PurityLevel.NORMAL))), new Item.Settings());
    //Coal related mod items

    //Copper related mod items

    //Iron related mod items

    //Gold related mod items

    //Diamond related mod items
    public static final Item DIAMOND_CRYSTAL = register("diamond_crystal", settings ->
            new Item(ItemComponentHelper.withCompoundsComponent(settings, new CompoundComponent(Compounds.DIAMOND, PurityLevel.IMPURE))), new Item.Settings());
    public static final Item EMERALD_CRYSTAL = register("emerald_crystal", settings ->
        new Item(ItemComponentHelper.withCompoundsComponent(settings, new CompoundComponent(Compounds.EMERALD, PurityLevel.IMPURE))), new Item.Settings());

    //Emerald related mod items

    public static void Initialize() {
    }
}
