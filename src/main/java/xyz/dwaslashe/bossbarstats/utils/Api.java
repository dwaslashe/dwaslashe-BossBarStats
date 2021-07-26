package xyz.dwaslashe.bossbarstats.utils;

import net.minecraft.server.dedicated.DedicatedServer;
import org.bukkit.ChatColor;

public class Api {

    public static String fixColor(String message){
        return message == null ? "" : ChatColor.translateAlternateColorCodes('&', message)
                .replace(">>", "»")
                .replace("<<", "«");

    }
    public static double getTps(){
        final double[] tpsA = DedicatedServer.getServer().recentTps;
        return Math.min(Math.round(tpsA[0] * 100.0) / 100.0, 20);
    }
}
