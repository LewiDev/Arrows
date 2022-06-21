package me.lewi.devtest;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class Devtest extends JavaPlugin {

    private ArrowItems arrowItems;
    private ArrowRecipes arrowRecipes;

    public HashMap<Arrow, ArrowType> arrowshot = new HashMap<>();
    public HashMap<Arrow, LivingEntity> arrowshooter = new HashMap<>();

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new ArrowListener(this), this);

        arrowRecipes = new ArrowRecipes(this);
        arrowItems = new ArrowItems();

        // RECIPES
        Bukkit.addRecipe(arrowRecipes.getBundleOfArrowRecipe());
        Bukkit.addRecipe(arrowRecipes.getDiamondArrowRecipe());
        Bukkit.addRecipe(arrowRecipes.getFishArrowRecipe());
        Bukkit.addRecipe(arrowRecipes.getEndCrystalArrowRecipe());
        Bukkit.addRecipe(arrowRecipes.getInfinityArrowRecipe());
    }

    public ArrowItems getArrowItems() {
        return arrowItems;
    }

    public ItemStack getDiamondArrowLoot() {
        ItemStack item = new ItemStack(Material.STICK);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.RED + "STICK OF LIFE");
        item.setItemMeta(itemMeta);
        return item;
    }
}
