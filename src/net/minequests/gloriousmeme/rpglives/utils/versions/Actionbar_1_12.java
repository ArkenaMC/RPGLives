package net.minequests.gloriousmeme.rpglives.utils.versions;

import net.minecraft.server.v1_12_R1.ChatComponentText;
import net.minecraft.server.v1_12_R1.ChatMessageType;
import net.minecraft.server.v1_12_R1.PacketPlayOutChat;
import net.minequests.gloriousmeme.rpglives.utils.Utils;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

/**
 * Created by GloriousMeme on 11/16/2016.
 */
public class Actionbar_1_12 implements Actionbar {

    @Override
    public void sendActionbar(Player player, String message) {
        PacketPlayOutChat packet = new PacketPlayOutChat(new ChatComponentText(Utils.replaceColors(message)), ChatMessageType.CHAT);

        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }
}
