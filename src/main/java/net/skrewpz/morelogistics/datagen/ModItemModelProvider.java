package net.skrewpz.morelogistics.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.skrewpz.morelogistics.MoreLogistics;
import net.skrewpz.morelogistics.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MoreLogistics.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.BASIC_PROCESSOR.get());
        basicItem(ModItems.ADVANCED_PROCESSOR.get());
        basicItem(ModItems.PROCESSOR_EXTRACTOR.get());
    }
}
