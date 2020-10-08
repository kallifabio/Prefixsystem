package de.kallifabio.prefixsystem.listeners;

import de.kallifabio.prefixsystem.Prefixsystem;
import de.kallifabio.prefixsystem.utils.Settings;
import de.kallifabio.prefixsystem.utils.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        if (Prefixsystem.getInstance().getConfigManager().getBuilder().getBoolean("Update.Enabled")) {
            new UpdateChecker(49736).getLatestVersion(version -> {
                if (!Prefixsystem.getInstance().getDescription().getVersion().equalsIgnoreCase(version)) {
                    player.sendMessage(ChatColor.GRAY + "****************************************************************");
                    player.sendMessage(ChatColor.RED + "Pluginversion ist nicht aktuell!");
                    player.sendMessage(ChatColor.RED + "Neuste Version: " + version);
                    player.sendMessage(ChatColor.RED + "Deine Version: " + ChatColor.BOLD + Settings.VERSION);
                    player.sendMessage(ChatColor.GOLD + "Update herunterladen: " + ChatColor.ITALIC + Settings.PLUGIN_URL);
                    player.sendMessage(ChatColor.GRAY + "****************************************************************");
                }
            });
        }
        addScoreboard(player);
    }

    private void addScoreboard(Player player) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();

        scoreboard.registerNewTeam("001Owner");
        scoreboard.registerNewTeam("002Admin");
        scoreboard.registerNewTeam("003Dev");
        scoreboard.registerNewTeam("004Mod");
        scoreboard.registerNewTeam("005Supp");
        scoreboard.registerNewTeam("006Builder");
        scoreboard.registerNewTeam("007Sponsor");
        scoreboard.registerNewTeam("008Freund");
        scoreboard.registerNewTeam("009YT");
        scoreboard.registerNewTeam("010JrYT");
        scoreboard.registerNewTeam("011Apfel");
        scoreboard.registerNewTeam("012Eisen");
        scoreboard.registerNewTeam("013Gold");
        scoreboard.registerNewTeam("014Premi");
        scoreboard.registerNewTeam("015Spieler");

        scoreboard.getTeam("001Owner").setPrefix(Prefixsystem.getInstance().getConfigManager().getBuilder().getString("Prefix.Owner"));
        scoreboard.getTeam("002Admin").setPrefix(Prefixsystem.getInstance().getConfigManager().getBuilder().getString("Prefix.Admin"));
        scoreboard.getTeam("003Dev").setPrefix(Prefixsystem.getInstance().getConfigManager().getBuilder().getString("Prefix.Developer"));
        scoreboard.getTeam("004Mod").setPrefix(Prefixsystem.getInstance().getConfigManager().getBuilder().getString("Prefix.Moderator"));
        scoreboard.getTeam("005Supp").setPrefix(Prefixsystem.getInstance().getConfigManager().getBuilder().getString("Prefix.Supporter"));
        scoreboard.getTeam("006Builder").setPrefix(Prefixsystem.getInstance().getConfigManager().getBuilder().getString("Prefix.Builder"));
        scoreboard.getTeam("007Sponsor").setPrefix(Prefixsystem.getInstance().getConfigManager().getBuilder().getString("Prefix.Sponsor"));
        scoreboard.getTeam("008Freund").setPrefix(Prefixsystem.getInstance().getConfigManager().getBuilder().getString("Prefix.Freund"));
        scoreboard.getTeam("009YT").setPrefix(Prefixsystem.getInstance().getConfigManager().getBuilder().getString("Prefix.YouTuber"));
        scoreboard.getTeam("010JrYT").setPrefix(Prefixsystem.getInstance().getConfigManager().getBuilder().getString("Prefix.JrYouTuber"));
        scoreboard.getTeam("011Apfel").setPrefix(Prefixsystem.getInstance().getConfigManager().getBuilder().getString("Prefix.Apfel"));
        scoreboard.getTeam("012Eisen").setPrefix(Prefixsystem.getInstance().getConfigManager().getBuilder().getString("Prefix.Eisen"));
        scoreboard.getTeam("013Gold").setPrefix(Prefixsystem.getInstance().getConfigManager().getBuilder().getString("Prefix.Gold"));
        scoreboard.getTeam("014Premi").setPrefix(Prefixsystem.getInstance().getConfigManager().getBuilder().getString("Prefix.Premium"));
        scoreboard.getTeam("015Spieler").setPrefix(Prefixsystem.getInstance().getConfigManager().getBuilder().getString("Prefix.Spieler"));

        String team = "";
        if (player.hasPermission("rang.owner")) {
            team = "001Owner";
        } else if (player.hasPermission("rang.admin")) {
            team = "002Admin";
        } else if (player.hasPermission("rang.dev")) {
            team = "003Dev";
        } else if (player.hasPermission("rang.mod")) {
            team = "004Mod";
        } else if (player.hasPermission("rang.supp")) {
            team = "005Supp";
        } else if (player.hasPermission("rang.builder")) {
            team = "006Builder";
        } else if (player.hasPermission("rang.sponsor")) {
            team = "007Sponsor";
        } else if (player.hasPermission("rang.freund")) {
            team = "008Freund";
        } else if (player.hasPermission("rang.yt")) {
            team = "009YT";
        } else if (player.hasPermission("rang.jryt")) {
            team = "010JrYT";
        } else if (player.hasPermission("rang.apfel")) {
            team = "011Apfel";
        } else if (player.hasPermission("rang.eisen")) {
            team = "012Eisen";
        } else if (player.hasPermission("rang.gold")) {
            team = "013Gold";
        } else if (player.hasPermission("rang.premi")) {
            team = "014Premi";
        } else {
            team = "015Spieler";
        }

        scoreboard.getTeam(team).addPlayer(player);
        player.setDisplayName(scoreboard.getTeam(team).getPrefix() + player.getName() + "§r");

        for (Player all : Bukkit.getOnlinePlayers())
            all.setScoreboard(scoreboard);
    }
}
