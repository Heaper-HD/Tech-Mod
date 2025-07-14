package net.heaper.tech_mod.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.heaper.tech_mod.recipe.book.PulverizingRecipeCategory;
import net.heaper.tech_mod.recipe.display.PulverizerRecipeDisplay;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.display.RecipeDisplay;
import net.minecraft.recipe.display.SlotDisplay;

import java.util.List;

public abstract class AbstractPulverizingRecipe extends SingleStackRecipe {
    private final PulverizingRecipeCategory category;
    private final float experience;
    private final int pulverizationTime;

    public AbstractPulverizingRecipe(String group, PulverizingRecipeCategory category, Ingredient ingredient, ItemStack result, float experience, int pulverizationTime) {
        super(group, ingredient, result);
        this.category = category;
        this.experience = experience;
        this.pulverizationTime = pulverizationTime;
    }

    @Override
    public abstract RecipeSerializer<? extends AbstractPulverizingRecipe> getSerializer();

    @Override
    public abstract RecipeType<? extends AbstractPulverizingRecipe> getType();

    public float getExperience() {
        return this.experience;
    }

    public int getPulverizationTime() {
        return this.pulverizationTime;
    }

    public PulverizingRecipeCategory getCategory() {
        return this.category;
    }

    public abstract Item getPulverizatorItem();

    @Override
    public List<RecipeDisplay> getDisplays() {
        return List.of(
            new PulverizerRecipeDisplay(
                    this.ingredient().toDisplay(),
                    new SlotDisplay.StackSlotDisplay(this.result()),
                    new SlotDisplay.ItemSlotDisplay(this.getPulverizatorItem()),
                    this.pulverizationTime,
                    this.experience
            )
        );
    }

    @FunctionalInterface
    public interface RecipeFactory<T extends AbstractPulverizingRecipe> {
        T create(String group, PulverizingRecipeCategory category, Ingredient ingredient, ItemStack result, float experience, int pulverizationTime);
    }

    public static class Serializer<T extends AbstractPulverizingRecipe> implements RecipeSerializer<T> {
        private final MapCodec<T> codec;
        private final PacketCodec<RegistryByteBuf, T> packetCodec;

        public Serializer(AbstractPulverizingRecipe.RecipeFactory<T> factory, int defaultPulverizationTime) {
            this.codec = RecordCodecBuilder.mapCodec(
                    instance -> instance.group(
                                    Codec.STRING.optionalFieldOf("group", "").forGetter(SingleStackRecipe::getGroup),
                                    PulverizingRecipeCategory.CODEC.fieldOf("category").orElse(PulverizingRecipeCategory.MISC).forGetter(AbstractPulverizingRecipe::getCategory),
                                    Ingredient.CODEC.fieldOf("ingredient").forGetter(SingleStackRecipe::ingredient),
                                    ItemStack.VALIDATED_UNCOUNTED_CODEC.fieldOf("result").forGetter(AbstractPulverizingRecipe::result),
                                    Codec.FLOAT.fieldOf("experience").orElse(0.0F).forGetter(AbstractPulverizingRecipe::getExperience),
                                    Codec.INT.fieldOf("pulverization_time").orElse(defaultPulverizationTime).forGetter(AbstractPulverizingRecipe::getPulverizationTime)
                            )
                            .apply(instance, factory::create)
            );
            this.packetCodec = PacketCodec.tuple(
                    PacketCodecs.STRING,
                    SingleStackRecipe::getGroup,
                    PulverizingRecipeCategory.PACKET_CODEC,
                    AbstractPulverizingRecipe::getCategory,
                    Ingredient.PACKET_CODEC,
                    SingleStackRecipe::ingredient,
                    ItemStack.PACKET_CODEC,
                    SingleStackRecipe::result,
                    PacketCodecs.FLOAT,
                    AbstractPulverizingRecipe::getExperience,
                    PacketCodecs.INTEGER,
                    AbstractPulverizingRecipe::getPulverizationTime,
                    factory::create
            );


        }

        @Override
        public MapCodec<T> codec() {
            return this.codec;
        }

        @Override
        public PacketCodec<RegistryByteBuf, T> packetCodec() {
            return this.packetCodec;
        }
    }
}
