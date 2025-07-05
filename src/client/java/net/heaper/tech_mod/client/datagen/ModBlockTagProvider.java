package net.heaper.tech_mod.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.heaper.tech_mod.Tech_mod;
import net.heaper.tech_mod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static TagKey<Block> URANIUM_ORES = TagKey.of(RegistryKeys.BLOCK, Identifier.of(Tech_mod.MOD_ID, "uranium_ores"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(id(ModBlocks.URANIUM_ORE))
                .add(id(ModBlocks.DEEPSLATE_URANIUM_ORE))
                .add(id(ModBlocks.URANIUM_BLOCK))
                .add(id(ModBlocks.RAW_URANIUM_BLOCK));

        getTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(id(ModBlocks.URANIUM_ORE))
                .add(id(ModBlocks.DEEPSLATE_URANIUM_ORE))
                .add(id(ModBlocks.URANIUM_BLOCK))
                .add(id(ModBlocks.RAW_URANIUM_BLOCK));

        getTagBuilder(URANIUM_ORES)
                .add(id(ModBlocks.URANIUM_ORE))
                .add(id(ModBlocks.DEEPSLATE_URANIUM_ORE));
    }

    private Identifier id(Block block) {
        return Registries.BLOCK.getId(block);
    }
}
