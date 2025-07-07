package net.heaper.tech_mod.component;

import com.mojang.serialization.Codec;
import net.heaper.tech_mod.Tech_mod;
import net.heaper.tech_mod.compound.CompoundVariant;
import net.heaper.tech_mod.compound.Compounds;
import net.heaper.tech_mod.element.ElementVariant;
import net.heaper.tech_mod.element.Elements;
import net.heaper.tech_mod.element.PurityLevel;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModComponents {
    public static final Codec<PurityLevel> PURITY_CODEC = Codec.STRING.xmap(
            str -> PurityLevel.valueOf(str.toUpperCase()),
            PurityLevel::name
    );

    public static final ComponentType<List<ElementVariant>> ELEMENTS_COMPONENT = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Tech_mod.MOD_ID, "elements"),
            ComponentType.<List<ElementVariant>>builder()
                    .codec(Codec.list(Elements.ELEMENT_VARIANT_CODEC))
                    .build()
    );

    public static final ComponentType<List<CompoundVariant>> COMPOUNDS_COMPONENT = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Tech_mod.MOD_ID, "compounds"),
            ComponentType.<List<CompoundVariant>>builder().codec(Codec.list(Compounds.COMPOUND_VARIANT_CODEC)).build()
    );

    public static void Initialize() {

    }
}
