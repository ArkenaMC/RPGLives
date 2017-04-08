package net.minequests.gloriousmeme.rpglives.utils.versions;

import net.minecraft.server.v1_8_R1.ChatComponentText;
import net.minecraft.server.v1_8_R1.PacketPlayOutChat;
import net.minequests.gloriousmeme.rpglives.utils.Utils;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Actionbar_1_8 implements Actionbar {

    @Override
    public void sendActionbar(Player player, String message) {
        PacketPlayOutChat packet = new PacketPlayOutChat(new ChatComponentText(Utils.replaceColors(message)), (byte) 2);

        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }
}
