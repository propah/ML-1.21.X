package net.skrewpz.morelogistics.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.skrewpz.morelogistics.block.ModBlocks;
import net.skrewpz.morelogistics.item.ModItems;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class ProcessorExtractorItem extends Item {
    public ProcessorExtractorItem(Properties props)
    {
        super(props);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.morelogistics.processor_extractor.tooltip.1"));
            tooltipComponents.add(Component.translatable("tooltip.morelogistics.processor_extractor.tooltip.2"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.morelogistics.processor_extractor.tooltip.shift"));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context)
    {
        Level level = context.getLevel();

        if (!level.isClientSide())
        {
            if (level.getBlockState(context.getClickedPos()).is(ModBlocks.BASIC_PROCESSOR_ORE_BLOCK))
            {
                level.setBlock(context.getClickedPos(), Blocks.DEEPSLATE.defaultBlockState(), 2);

                Block.popResource(level, context.getClickedPos(), new ItemStack(ModItems.BASIC_PROCESSOR.get(), 8));

                level.playSound(null, context.getClickedPos(), SoundEvents.IRON_GOLEM_STEP, SoundSource.BLOCKS, 1f, 2f);

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) context.getPlayer()),
                        item -> Objects.requireNonNull(context.getPlayer()).onEquippedItemBroken(item, EquipmentSlot.MAINHAND));


            }
        }

        return InteractionResult.CONSUME;
    }
}
