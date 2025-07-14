package net.heaper.tech_mod.util;

import net.heaper.tech_mod.component.ModDataComponentsType;
import net.heaper.tech_mod.compound.CompoundComponent;
import net.heaper.tech_mod.element.ElementComponent;
import net.minecraft.item.Item;

import java.util.Arrays;

public class ItemComponentHelper {
    public static Item.Settings withElementsComponent(Item.Settings settings, ElementComponent... variants) {
        return  settings.component(ModDataComponentsType.ELEMENTS_COMPONENT, Arrays.asList(variants));
    }

    public static Item.Settings withCompoundsComponent(Item.Settings settings, CompoundComponent... variants) {
        return  settings.component(ModDataComponentsType.COMPOUNDS_COMPONENT, Arrays.asList(variants));
    }
}
