package net.skrewpz.morelogistics.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.skrewpz.morelogistics.block.ModBlocks;
import org.jetbrains.annotations.NotNull;

public class BasicProcessor extends Item {
    public BasicProcessor(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();

        if (!level.isClientSide())
        {
            if (level.getBlockState(context.getClickedPos()).is(Blocks.DEEPSLATE) || level.getBlockState(context.getClickedPos()).is(Blocks.COBBLED_DEEPSLATE))
            {
                level.setBlock(context.getClickedPos(), ModBlocks.BASIC_PROCESSOR_ORE_BLOCK.get().defaultBlockState(), 2);

                level.playSound(null, context.getClickedPos(), SoundEvents.ITEM_FRAME_REMOVE_ITEM, SoundSource.BLOCKS, 1f, 1f);

                context.getItemInHand().shrink(1);
            }
        }

        return InteractionResult.SUCCESS;
    }
}
