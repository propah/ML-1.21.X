package net.skrewpz.morelogistics.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.skrewpz.morelogistics.MoreLogistics;
import net.skrewpz.morelogistics.item.custom.BasicProcessor;
import net.skrewpz.morelogistics.item.custom.ProcessorExtractorItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MoreLogistics.MOD_ID);

    public static final DeferredItem<Item> BASIC_PROCESSOR = ITEMS.registerItem("basic_processor", BasicProcessor::new);

    public static final DeferredItem<Item> ADVANCED_PROCESSOR = ITEMS.registerSimpleItem("advanced_processor");

    public static final DeferredItem<Item> PROCESSOR_EXTRACTOR =
            ITEMS.registerItem("processor_extractor",
            ProcessorExtractorItem::new, new Item.Properties().durability(64));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
