package net.minequests.gloriousmeme.rpglives.events;

import net.minequests.gloriousmeme.rpglives.RPGLives;
import net.minequests.gloriousmeme.rpglives.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

/**
 * Created by GloriousMeme on 11/16/2016.
 */
public class GUIClick implements Listener {

    @EventHandler
    public void onInvClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory inventory = event.getClickedInventory();
        int clickedSlot = event.getSlot();

        if (event.getCurrentItem() == null)
            return;

        if (inventory.getName().contains("Life")) {
            if (clickedSlot == 11) {
                if (Utils.getLives(player) >= Utils.getMaxLives(player)) {
                    player.sendMessage(Utils.replaceColors("&4You already have your maximum amount of lives."));
                    event.setCancelled(true);
                    return;
                }
                if (RPGLives.get().getEconomy().getBalance(player) >= RPGLives.get().getGuiUtils().getLifePrice()) {
                    Utils.setLives(player, Utils.getLives(player) + 1);
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "eco take " + player.getName() + " " + RPGLives.get().getGuiUtils().getLifePrice());
                    player.sendMessage(Utils.replaceColors("&aYou bought a life and now have " + Utils.getLives(player) + "/"
                            + Utils.getMaxLives(player) + " lives."));
                    event.setCancelled(true);
                } else
                    player.sendMessage(Utils.replaceColors("&4You do not have enough money."));
            }
            if (clickedSlot == 15) {
                player.closeInventory();
                player.sendMessage(Utils.replaceColors("&cShop closed."));
                event.setCancelled(true);
            }
            event.setCancelled(true);
        }
    }
}
