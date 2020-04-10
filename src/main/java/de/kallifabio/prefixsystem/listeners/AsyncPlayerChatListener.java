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
        String message = event.getMessage();
        event.setFormat("§f" + player.getDisplayName() + " 7» §e" + ChatColor.translateAlternateColorCodes('&', message));
    }
}
