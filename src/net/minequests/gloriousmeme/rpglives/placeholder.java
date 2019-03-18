package net.minequests.gloriousmeme.rpglives;

import be.maximvdw.placeholderapi.PlaceholderAPI;
import be.maximvdw.placeholderapi.PlaceholderReplaceEvent;
import be.maximvdw.placeholderapi.PlaceholderReplacer;
import net.minequests.gloriousmeme.rpglives.utils.Utils;
import org.bukkit.entity.Player;

public class placeholder {

    public static void registerPlaceholder() {
        PlaceholderAPI.registerPlaceholder(RPGLives.plugin2, "rpglives",  new PlaceholderReplacer() {
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent e) {
                if(e.isOnline()) {
                    Player p = e.getPlayer();
                    return ""+String.valueOf(Utils.getLives(p));
                } else {
                    return "0";
                }
            }
        });

        PlaceholderAPI.registerPlaceholder(RPGLives.plugin2, "rpglivesmax",  new PlaceholderReplacer() {
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent e) {
                if(e.isOnline()) {
                    Player p = e.getPlayer();
                    return ""+String.valueOf(Utils.getMaxLives(p));
                } else {
                    return "0";
                }
            }
        });

        PlaceholderAPI.registerPlaceholder(RPGLives.plugin2, "rpglivesregen",  new PlaceholderReplacer() {
            @Override
            public String onPlaceholderReplace(PlaceholderReplaceEvent e) {
                if(e.isOnline()) {
                    Player p = e.getPlayer();
                    return ""+String.valueOf(Utils.getRegenTime(p));
                } else {
                    return "0";
                }
            }
        });
    }

}
