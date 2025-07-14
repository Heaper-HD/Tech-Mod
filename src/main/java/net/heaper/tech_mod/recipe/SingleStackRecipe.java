package net.heaper.tech_mod.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.*;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class SingleStackRecipe implements Recipe<SingleStackRecipeInput> {
    private final Ingredient ingredient;
    private final ItemStack result;
    private final String group;
    @Nullable
    private IngredientPlacement ingredientPlacement;

    public SingleStackRecipe(String group, Ingredient ingredient, ItemStack result) {
        this.group = group;
        this.ingredient = ingredient;
        this.result = result;
    }

    @Override
    public abstract RecipeSerializer<? extends Recipe<SingleStackRecipeInput>> getSerializer();

    @Override
    public abstract RecipeType<? extends Recipe<SingleStackRecipeInput>> getType();

    public boolean matches(SingleStackRecipeInput singleStackRecipeInput, World world) {
        return this.ingredient.test(singleStackRecipeInput.item());
    }

    @Override
    public String getGroup() {
        return this.group;
    }

    public Ingredient ingredient() {
        return this.ingredient;
    }

    protected ItemStack result() {
        return this.result;
    }

    @Override
    public @Nullable IngredientPlacement getIngredientPlacement() {
        if (this.ingredient == null) {
            this.ingredientPlacement = IngredientPlacement.forSingleSlot(this.ingredient);
        }

        return this.ingredientPlacement;
    }

    public ItemStack craft(SingleStackRecipeInput singleStackRecipeInput, RegistryWrapper.WrapperLookup wrapperLookup) {
        return this.result.copy();
    }

    @FunctionalInterface
    public interface RecipeFactory<T extends SingleStackRecipe> {
        T create(String group, Ingredient ingredient, ItemStack result);
    }

    public static class Serializer<T extends SingleStackRecipe> implements RecipeSerializer<T> {
        private final MapCodec<T> codec;
        private final PacketCodec<RegistryByteBuf, T> packetCodec;

        protected Serializer(SingleStackRecipe.RecipeFactory<T> recipeFactory) {
            this.codec = RecordCodecBuilder.mapCodec(
                    instance -> instance.group(
                                    Codec.STRING.optionalFieldOf("group", "").forGetter(SingleStackRecipe::getGroup),
                                    Ingredient.CODEC.fieldOf("ingredient").forGetter(SingleStackRecipe::ingredient),
                                    ItemStack.VALIDATED_CODEC.fieldOf("result").forGetter(SingleStackRecipe::result)
                            )
                            .apply(instance, recipeFactory::create)
            );
            this.packetCodec = PacketCodec.tuple(
                    PacketCodecs.STRING,
                    SingleStackRecipe::getGroup,
                    Ingredient.PACKET_CODEC,
                    SingleStackRecipe::ingredient,
                    ItemStack.PACKET_CODEC,
                    SingleStackRecipe::result,
                    recipeFactory::create
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
