package me.lewi.devtest;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

public class ArrowRecipes {

    private Devtest main;

    public ArrowRecipes(Devtest main) {
        this.main = main;
    }

    public ShapedRecipe getBundleOfArrowRecipe() {
        ShapedRecipe bundleOfArrowRecipe = new ShapedRecipe(new NamespacedKey(main, "bundleOfArrowRecipe"), main.getArrowItems().getBundleOfArrows());
        bundleOfArrowRecipe.shape(
                "AAA",
                "AAA",
                "AAA");
        bundleOfArrowRecipe.setIngredient('A', Material.ARROW);
        return bundleOfArrowRecipe;
    }

    public ShapedRecipe getDiamondArrowRecipe() {
        ShapedRecipe diamondArrowRecipe = new ShapedRecipe(new NamespacedKey(main, "diamondArrowRecipe"), main.getArrowItems().getDiamondArrow());
        diamondArrowRecipe.shape(
                "DDD",
                "DAD",
                "DDD");
        diamondArrowRecipe.setIngredient('A', new RecipeChoice.ExactChoice(main.getArrowItems().getBundleOfArrows()));
        diamondArrowRecipe.setIngredient('D', Material.DIAMOND);
        return diamondArrowRecipe;
    }

    public ShapedRecipe getFishArrowRecipe() {
        ShapedRecipe fishArrowRecipe = new ShapedRecipe(new NamespacedKey(main, "fishArrowRecipe"), main.getArrowItems().getFishArrow());
        fishArrowRecipe.shape(
                "SCS",
                "CAC",
                "SCS");
        fishArrowRecipe.setIngredient('A', Material.ARROW);
        fishArrowRecipe.setIngredient('S', Material.COOKED_SALMON);
        fishArrowRecipe.setIngredient('C', Material.COOKED_COD);
        return fishArrowRecipe;
    }

    public ShapelessRecipe getEndCrystalArrowRecipe() {
        ShapelessRecipe endCrystalArrowRecipe = new ShapelessRecipe(new NamespacedKey(main, "endCrystalArrowRecipe"), main.getArrowItems().getEndCrystalArrow());
        endCrystalArrowRecipe.addIngredient(new RecipeChoice.ExactChoice(main.getArrowItems().getFishArrow()));
        endCrystalArrowRecipe.addIngredient(Material.END_CRYSTAL);
        return endCrystalArrowRecipe;
    }

    public ShapelessRecipe getInfinityArrowRecipe() {
        ShapelessRecipe infinityArrowRecipe = new ShapelessRecipe(new NamespacedKey(main, "infinityArrowRecipe"), main.getArrowItems().getInfinityArrow());
        infinityArrowRecipe.addIngredient(new RecipeChoice.ExactChoice(main.getArrowItems().getDiamondArrow()));
        infinityArrowRecipe.addIngredient(new RecipeChoice.ExactChoice(main.getArrowItems().getBundleOfArrows()));
        infinityArrowRecipe.addIngredient(new RecipeChoice.ExactChoice(main.getArrowItems().getFishArrow()));
        infinityArrowRecipe.addIngredient(new RecipeChoice.ExactChoice(main.getArrowItems().getEndCrystalArrow()));
        infinityArrowRecipe.addIngredient(Material.DIAMOND_BLOCK);
        return infinityArrowRecipe;
    }
}
