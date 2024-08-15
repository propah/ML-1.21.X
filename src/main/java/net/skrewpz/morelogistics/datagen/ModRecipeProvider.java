package net.skrewpz.morelogistics.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.skrewpz.morelogistics.MoreLogistics;
import net.skrewpz.morelogistics.block.ModBlocks;
import net.skrewpz.morelogistics.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> BASIC_PROCESSOR_SMELTABLES = List.of(ModBlocks.BASIC_PROCESSOR_ORE_BLOCK);
        List<ItemLike> ADVANCED_PROCESSOR_SMELTABLES = List.of(ModBlocks.ADVANCED_PROCESSOR_ORE_BLOCK);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BASIC_PROCESSOR_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.BASIC_PROCESSOR)
                .unlockedBy("has_basic_processor", has(ModItems.BASIC_PROCESSOR.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ADVANCED_PROCESSOR_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.ADVANCED_PROCESSOR)
                .unlockedBy("has_basic_processor", has(ModItems.ADVANCED_PROCESSOR.get()))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BASIC_PROCESSOR.get(), 9)
                .requires(ModBlocks.BASIC_PROCESSOR_BLOCK)
                .unlockedBy("has_basic_processor_block", has(ModBlocks.BASIC_PROCESSOR_BLOCK))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ADVANCED_PROCESSOR.get(), 9)
                .requires(ModBlocks.ADVANCED_PROCESSOR_BLOCK)
                .unlockedBy("has_basic_processor_block", has(ModBlocks.ADVANCED_PROCESSOR_BLOCK))
                .save(recipeOutput);

        oreSmelting(recipeOutput, BASIC_PROCESSOR_SMELTABLES, RecipeCategory.MISC, new ItemStack(ModItems.BASIC_PROCESSOR.get(), 2), 0.25f, 200, "basic_processor");
        oreBlasting(recipeOutput, BASIC_PROCESSOR_SMELTABLES, RecipeCategory.MISC, new ItemStack(ModItems.BASIC_PROCESSOR.get(), 2), 0.25f, 100, "basic_processor");

        oreSmelting(recipeOutput, ADVANCED_PROCESSOR_SMELTABLES, RecipeCategory.MISC, new ItemStack(ModItems.ADVANCED_PROCESSOR.get(), 2), 0.25f, 200, "advanced_processor");
        oreBlasting(recipeOutput, ADVANCED_PROCESSOR_SMELTABLES, RecipeCategory.MISC, new ItemStack(ModItems.ADVANCED_PROCESSOR.get(), 2), 0.25f, 100, "advanced_processor");
    }


    protected static void oreSmelting(
            RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemStack result, float experience, int cookingTime, String group
    ) {
        oreCooking(
                recipeOutput,
                RecipeSerializer.SMELTING_RECIPE,
                SmeltingRecipe::new,
                ingredients,
                category,
                result,
                experience,
                cookingTime,
                group,
                "_from_smelting"
        );
    }

    protected static void oreBlasting(
            RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemStack result, float experience, int cookingTime, String group
    ) {
        oreCooking(
                recipeOutput,
                RecipeSerializer.BLASTING_RECIPE,
                BlastingRecipe::new,
                ingredients,
                category,
                result,
                experience,
                cookingTime,
                group,
                "_from_blasting"
        );
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(
            RecipeOutput recipeOutput,
            RecipeSerializer<T> serializer,
            AbstractCookingRecipe.Factory<T> recipeFactory,
            List<ItemLike> ingredients,
            RecipeCategory category,
            ItemStack result,
            float experience,
            int cookingTime,
            String group,
            String suffix
    ) {
        for (ItemLike itemlike : ingredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), category, result, experience, cookingTime, serializer, recipeFactory)
                    .group(group)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, MoreLogistics.MOD_ID + ":" + getItemName(result.getItem()) + suffix + "_" + getItemName(itemlike));
        }
    }
}

