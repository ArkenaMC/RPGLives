package net.minequests.gloriousmeme.rpglives.utils.versions;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ActionbarTitle implements Actionbar {

    @Override
    public void sendActionbar(Player p, String message) {
        p.sendTitle(ChatColor.GREEN+"RPGLives",message, 10, 75, 10);
    }
}
