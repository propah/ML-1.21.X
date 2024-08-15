package net.skrewpz.morelogistics.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.skrewpz.morelogistics.MoreLogistics;
import net.skrewpz.morelogistics.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MoreLogistics.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BASIC_PROCESSOR_BLOCK.get())
                .add(ModBlocks.BASIC_PROCESSOR_ORE_BLOCK.get())
                .add(ModBlocks.ADVANCED_PROCESSOR_BLOCK.get())
                .add(ModBlocks.ADVANCED_PROCESSOR_ORE_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BASIC_PROCESSOR_BLOCK.get())
                .add(ModBlocks.BASIC_PROCESSOR_ORE_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.ADVANCED_PROCESSOR_BLOCK.get())
                .add(ModBlocks.ADVANCED_PROCESSOR_ORE_BLOCK.get());
    }
}
