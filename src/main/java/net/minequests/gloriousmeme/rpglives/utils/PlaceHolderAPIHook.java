package net.minequests.gloriousmeme.rpglives.utils;

import me.clip.placeholderapi.external.EZPlaceholderHook;
import net.minequests.gloriousmeme.rpglives.RPGLives;
import org.bukkit.entity.Player;

public class PlaceHolderAPIHook extends EZPlaceholderHook {

    private final RPGLives plugin;

    public PlaceHolderAPIHook(RPGLives plugin) {
        super(plugin, "rpglives");
        this.plugin = plugin;
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        if (player == null)
            return "";
        if (identifier.equals("lives"))
            return String.valueOf(Utils.getLives(player));
        if (identifier.equals("maxlives"))
            return String.valueOf(Utils.getMaxLives(player));
        if (identifier.equals("regentime"))
            return String.valueOf(Utils.getRegenTime(player));
        return null;
    }
}