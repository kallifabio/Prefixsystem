package de.kallifabio.prefixsystem.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChatListener implements Listener {

    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
        final Player player = event.getPlayer();
        String message = event.getMessage().replace("%", "%%");

        if (player.hasPermission("rang.owner") || player.isOp()) {
            event.setFormat("§f" + player.getDisplayName() + " §7» §e" + ChatColor.translateAlternateColorCodes('&', message));
        } else if (player.hasPermission("rang.admin")) {
            event.setFormat("§f" + player.getDisplayName() + " §7» §e" + ChatColor.translateAlternateColorCodes('&', message));
        } else if (player.hasPermission("rang.dev")) {
            event.setFormat("§f" + player.getDisplayName() + " §7» §e" + ChatColor.translateAlternateColorCodes('&', message));
        } else if (player.hasPermission("rang.mod")) {
            event.setFormat("§f" + player.getDisplayName() + " §7» §e" + ChatColor.translateAlternateColorCodes('&', message));
        } else if (player.hasPermission("rang.supp")) {
            event.setFormat("§f" + player.getDisplayName() + " §7» §e" + ChatColor.translateAlternateColorCodes('&', message));
        } else if (player.hasPermission("rang.builder")) {
            event.setFormat("§f" + player.getDisplayName() + " §7» §e" + ChatColor.translateAlternateColorCodes('&', message));
        } else if (player.hasPermission("rang.sponsor")) {
            event.setFormat("§f" + player.getDisplayName() + " §7» §e" + ChatColor.translateAlternateColorCodes('&', message));
        } else if (player.hasPermission("rang.freund")) {
            event.setFormat("§f" + player.getDisplayName() + " §7» §e" + ChatColor.translateAlternateColorCodes('&', message));
        } else if (player.hasPermission("rang.yt")) {
            event.setFormat("§f" + player.getDisplayName() + " §7» §e" + message);
        } else if (player.hasPermission("rang.jryt")) {
            event.setFormat("§f" + player.getDisplayName() + " §7» §e" + message);
        } else if (player.hasPermission("rang.apfel")) {
            event.setFormat("§f" + player.getDisplayName() + " §7» §e" + message);
        } else if (player.hasPermission("rang.eisen")) {
            event.setFormat("§f" + player.getDisplayName() + " §7» §e" + message);
        } else if (player.hasPermission("rang.gold")) {
            event.setFormat("§f" + player.getDisplayName() + " §7» §e" + message);
        } else if (player.hasPermission("rang.premi")) {
            event.setFormat("§f" + player.getDisplayName() + " §7» §e" + message);
        } else {
            event.setFormat("§f" + player.getDisplayName() + " §7» §e" + message);
        }
    }
}
