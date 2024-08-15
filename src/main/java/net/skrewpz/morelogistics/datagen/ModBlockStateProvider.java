package net.skrewpz.morelogistics.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.skrewpz.morelogistics.MoreLogistics;
import net.skrewpz.morelogistics.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MoreLogistics.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BASIC_PROCESSOR_BLOCK);
        blockWithItem(ModBlocks.BASIC_PROCESSOR_ORE_BLOCK);
        blockWithItem(ModBlocks.ADVANCED_PROCESSOR_BLOCK);
        blockWithItem(ModBlocks.ADVANCED_PROCESSOR_ORE_BLOCK);
    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock)
    {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
