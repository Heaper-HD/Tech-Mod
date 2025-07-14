package net.heaper.tech_mod.recipe.display;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.display.RecipeDisplay;
import net.minecraft.recipe.display.SlotDisplay;
import net.minecraft.resource.featuretoggle.FeatureSet;

public record PulverizerRecipeDisplay(SlotDisplay ingredient, SlotDisplay result, SlotDisplay craftingStation, int duration, float experience)
        implements RecipeDisplay {
    public static final MapCodec<PulverizerRecipeDisplay> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    SlotDisplay.CODEC.fieldOf("ingredient").forGetter(PulverizerRecipeDisplay::ingredient),
                    SlotDisplay.CODEC.fieldOf("result").forGetter(PulverizerRecipeDisplay::result),
                    SlotDisplay.CODEC.fieldOf("crafting_station").forGetter(PulverizerRecipeDisplay::craftingStation),
                    Codec.INT.fieldOf("duration").forGetter(PulverizerRecipeDisplay::duration),
                    Codec.FLOAT.fieldOf("experience").forGetter(PulverizerRecipeDisplay::experience)
            )
                    .apply(instance, PulverizerRecipeDisplay::new)
    );
    public static final PacketCodec<RegistryByteBuf, PulverizerRecipeDisplay> PACKET_CODEC;
    public static final RecipeDisplay.Serializer<PulverizerRecipeDisplay> SERIALIZER;

    @Override
    public Serializer<PulverizerRecipeDisplay> serializer() {
        return SERIALIZER;
    }

    @Override
    public boolean isEnabled(FeatureSet features) {
        return this.ingredient.isEnabled(features) && RecipeDisplay.super.isEnabled(features);
    }

    static {
        PACKET_CODEC = PacketCodec.tuple(
                SlotDisplay.PACKET_CODEC, PulverizerRecipeDisplay::ingredient,
                SlotDisplay.PACKET_CODEC, PulverizerRecipeDisplay::result,
                SlotDisplay.PACKET_CODEC, PulverizerRecipeDisplay::craftingStation,
                PacketCodecs.VAR_INT, PulverizerRecipeDisplay::duration,
                PacketCodecs.FLOAT, PulverizerRecipeDisplay::experience,
                PulverizerRecipeDisplay::new);

        SERIALIZER = new RecipeDisplay.Serializer(CODEC, PACKET_CODEC);
    }
}
