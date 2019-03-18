package net.minequests.gloriousmeme.rpglives.utils;

import net.minequests.gloriousmeme.rpglives.RPGLives;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

/**
 * Created by GloriousMeme on 11/16/2016.
 */
public class GUIUtils {

    private Inventory livesShop = Bukkit.getServer().createInventory(null, 27, Utils.replaceColors("&aLife Shop"));

    {
        ItemStack buyLife = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1);
        ItemMeta buyLifeMeta = buyLife.getItemMeta();
        buyLifeMeta.setDisplayName(Utils.replaceColors(RPGLives.get().getConfig().getString("BuyItemName")));
        ArrayList<String> buyLifeLore = new ArrayList<>();
        buyLifeLore.add(String.valueOf(RPGLives.get().getConfig().getDouble("LifePrice")));
        buyLifeMeta.setLore(buyLifeLore);
        buyLife.setItemMeta(buyLifeMeta);

        ItemStack closeGUI = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
        ItemMeta closeGUIMeta = closeGUI.getItemMeta();
        closeGUIMeta.setDisplayName(Utils.replaceColors(RPGLives.get().getConfig().getString("CloseItemName")));
        closeGUI.setItemMeta(closeGUIMeta);

        ItemStack borders = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);
        ItemMeta borderMeta = borders.getItemMeta();
        borderMeta.setDisplayName(Utils.replaceColors(RPGLives.get().getConfig().getString("BorderName")));
        borders.setItemMeta(borderMeta);

        livesShop.setItem(11, buyLife);
        livesShop.setItem(15, closeGUI);

        for(int i = 0; i < 27; i++) {
            if(livesShop.getItem(i) == null)
                livesShop.setItem(i, borders);
        }
    }

    public double getLifePrice() {
        return RPGLives.get().getConfig().getDouble("LifePrice");
    }

    public Inventory getLivesShop() {
        return livesShop;
    }
}
