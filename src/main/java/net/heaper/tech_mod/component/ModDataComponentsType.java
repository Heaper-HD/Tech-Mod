package net.heaper.tech_mod.component;

import com.mojang.serialization.Codec;
import net.heaper.tech_mod.Tech_mod;
import net.heaper.tech_mod.compound.CompoundComponent;
import net.heaper.tech_mod.compound.Compounds;
import net.heaper.tech_mod.element.ElementComponent;
import net.heaper.tech_mod.element.Elements;
import net.heaper.tech_mod.element.PurityLevel;
import net.minecraft.component.ComponentType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.UnaryOperator;

public class ModDataComponentsType {
    public static final Codec<PurityLevel> PURITY_CODEC = Codec.STRING.xmap(
            str -> PurityLevel.valueOf(str.toUpperCase()),
            PurityLevel::name
    );

    public static final ComponentType<List<ElementComponent>> ELEMENTS_COMPONENT = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Tech_mod.MOD_ID, "elements"),
            ComponentType.<List<ElementComponent>>builder()
                    .codec(Codec.list(Elements.ELEMENT_VARIANT_CODEC))
                    .build()
    );

    public static final ComponentType<List<CompoundComponent>> COMPOUNDS_COMPONENT = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Tech_mod.MOD_ID, "compounds"),
            ComponentType.<List<CompoundComponent>>builder().codec(Codec.list(Compounds.COMPOUND_VARIANT_CODEC)).build()
    );

    public static final ComponentType<NbtComponent> POWDER = ModDataComponentsType.register("powder", builder -> builder.codec(NbtComponent.CODEC));

    public static void Initialize() {

    }

    private static <T> ComponentType<T> register(String id, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        Identifier identifier = Identifier.of(Tech_mod.MOD_ID, id);
        ComponentType<T> type = builderOperator.apply(ComponentType.<T>builder()).build();
        return Registry.register(Registries.DATA_COMPONENT_TYPE, identifier, type);
    }
}
