package net.skrewpz.morelogistics.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.skrewpz.morelogistics.MoreLogistics;
import net.skrewpz.morelogistics.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MoreLogistics.MOD_ID);

    public static final Supplier<CreativeModeTab> PROCESSOR_ITEMS_TAB =
            CREATIVE_MODE_TAB.register("processor_items_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.morelogistics.processor_items_tab"))
                    .icon(() -> new ItemStack(ModItems.BASIC_PROCESSOR.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.BASIC_PROCESSOR.get());
                        output.accept(ModItems.ADVANCED_PROCESSOR.get());
                        output.accept(ModBlocks.BASIC_PROCESSOR_BLOCK);
                        output.accept(ModBlocks.ADVANCED_PROCESSOR_BLOCK);
                        output.accept(ModBlocks.BASIC_PROCESSOR_ORE_BLOCK);
                        output.accept(ModBlocks.ADVANCED_PROCESSOR_ORE_BLOCK);
                        output.accept(ModItems.PROCESSOR_EXTRACTOR);
                    })
                    .build());

    public static void register(IEventBus bus) {
        CREATIVE_MODE_TAB.register(bus);
    }
}
