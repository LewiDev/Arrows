package me.lewi.devtest;

import com.sun.org.apache.xerces.internal.xs.StringList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;


public class ArrowItems {

    public ItemStack getBundleOfArrows() {
        ItemStack bundleOfArrows = new ItemStack(Material.ARROW, 1);

        ItemMeta meta = bundleOfArrows.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "Bundle of Arrows");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_PURPLE + "Fires Multiple Arrows");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setCustomModelData(100);
        bundleOfArrows.setItemMeta(meta);


        return bundleOfArrows;
    }

    public ItemStack getEndCrystalArrow() {
        ItemStack endCrystalArrow = new ItemStack(Material.ARROW, 1);

        ItemMeta meta = endCrystalArrow.getItemMeta();
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "End Crystal Arrow");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_PURPLE + "Fires Lazer like arrow!");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setCustomModelData(400);
        endCrystalArrow.setItemMeta(meta);

        return endCrystalArrow;
    }

    public ItemStack getDiamondArrow() {
        ItemStack diamondArrow = new ItemStack(Material.ARROW, 1);

        ItemMeta meta = diamondArrow.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "Diamond Arrow");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_PURPLE + "Drops Rare loot when mob is killed!");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setCustomModelData(200);
        diamondArrow.setItemMeta(meta);

        return diamondArrow;
    }

    public ItemStack getFishArrow() {
        ItemStack fishArrow = new ItemStack(Material.ARROW, 1);

        ItemMeta meta = fishArrow.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "Fish Arrow");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_PURPLE + "Turns hit entity into fish (ONLY MOBS)");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setCustomModelData(500);
        fishArrow.setItemMeta(meta);

        return fishArrow;
    }

    public ItemStack getInfinityArrow() {
        ItemStack infinityArrow = new ItemStack(Material.ARROW, 1);

        ItemMeta meta = infinityArrow.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "Infinity Arrow");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_PURPLE + "Deals ALOT of damage");
        lore.add("returns to inventory after 2 seconds");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setCustomModelData(600);
        infinityArrow.setItemMeta(meta);

        return infinityArrow;
    }



}
