package net.heaper.tech_mod.item;

import net.heaper.tech_mod.component.ModComponents;
import net.heaper.tech_mod.compound.CompoundVariant;
import net.heaper.tech_mod.element.ElementVariant;
import net.minecraft.item.Item;

import java.util.Arrays;

public class ItemComponentHelper {
    @SafeVarargs
    public static Item.Settings withElementsComponent(Item.Settings settings, ElementVariant... variants) {
        return  settings.component(ModComponents.ELEMENTS_COMPONENT, Arrays.asList(variants));
    }

    @SafeVarargs
    public static Item.Settings withCompoundsComponent(Item.Settings settings, CompoundVariant... variants) {
        return  settings.component(ModComponents.COMPOUNDS_COMPONENT, Arrays.asList(variants));
    }
}
