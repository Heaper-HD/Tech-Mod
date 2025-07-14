package net.heaper.tech_mod.recipe.book;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;

import java.util.function.IntFunction;
import java.util.function.ToIntFunction;


public enum PulverizingRecipeCategory implements StringIdentifiable {
    ORES(0 , "ores"),
    POWDER(1, "powder"),
    MISC(2, "misc");

    private static final IntFunction<PulverizingRecipeCategory> BY_ID = ValueLists.createIndexToValueFunction(
            (ToIntFunction<PulverizingRecipeCategory>) category -> category.id, values(), ValueLists.OutOfBoundsHandling.ZERO
    );
    public static final Codec<PulverizingRecipeCategory> CODEC = StringIdentifiable.createCodec(PulverizingRecipeCategory::values);
    public static final PacketCodec<ByteBuf, PulverizingRecipeCategory> PACKET_CODEC = PacketCodecs.indexed(BY_ID, category -> category.id);
    private int id;
    private String name;

    PulverizingRecipeCategory(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String asString() {
        return this.name;
    }
}
