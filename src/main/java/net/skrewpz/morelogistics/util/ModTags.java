package net.skrewpz.morelogistics.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.skrewpz.morelogistics.MoreLogistics;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> PROCESSOR_ORES = createTag("processor_ores");

        private static TagKey<Block> createTag(String name)
        {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(MoreLogistics.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> TOOLS = createTag("tools");

        private static TagKey<Item> createTag(String name)
        {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(MoreLogistics.MOD_ID, name));
        }
    }

}
