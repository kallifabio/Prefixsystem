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
        if (Prefixsystem.getInstance().getConfigManager().getBuilder().getBoolean("Update.Enabled") == true) {
            new UpdateChecker(49736).getLatestVersion(version -> {
                if (!Prefixsystem.getInstance().getDescription().getVersion().equalsIgnoreCase(version)) {
                    player.sendMessage(ChatColor.GRAY + "****************************************************************");
                    player.sendMessage(ChatColor.RED + "PluginName is outdated!");
                    player.sendMessage(ChatColor.RED + "Newest version: " + version);
                    player.sendMessage(ChatColor.RED + "Your version: " + ChatColor.BOLD + Settings.VERSION);
                    player.sendMessage(ChatColor.GOLD + "Please Update Here: " + ChatColor.ITALIC + Settings.PLUGIN_URL);
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
        scoreboard.registerNewTeam("008YT");
        scoreboard.registerNewTeam("009JrYT");
        scoreboard.registerNewTeam("010Apfel");
        scoreboard.registerNewTeam("011Eisen");
        scoreboard.registerNewTeam("012Gold");
        scoreboard.registerNewTeam("013Premi");
        scoreboard.registerNewTeam("014Spieler");

        scoreboard.getTeam("001Owner").setPrefix(Prefixsystem.getInstance().getConfigManager().getBuilder().getString("Prefix.Owner"));
        scoreboard.getTeam("002Admin").setPrefix("§cAdmin §7| §c");
        scoreboard.getTeam("003Dev").setPrefix("§3Dev §7| §3");
        scoreboard.getTeam("004Mod").setPrefix("§fMod §7| §f");
        scoreboard.getTeam("005Supp").setPrefix("§1Supp §7| §1");
        scoreboard.getTeam("006Builder").setPrefix("§2Builder §7| §2");
        scoreboard.getTeam("007Sponsor").setPrefix("§9Sponsor §7| §9");
        scoreboard.getTeam("008YT").setPrefix("§5YT §7| §5");
        scoreboard.getTeam("009JrYT").setPrefix("§dJrYT §7| §d");
        scoreboard.getTeam("010Apfel").setPrefix("§aApfel §7| §a");
        scoreboard.getTeam("011Eisen").setPrefix("§7Eisen §7| §7");
        scoreboard.getTeam("012Gold").setPrefix("§eGold §7| §e");
        scoreboard.getTeam("013Premi").setPrefix("§6Premium §7| §6");
        scoreboard.getTeam("014Spieler").setPrefix("§8");

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
        } else if (player.hasPermission("rang.yt")) {
            team = "008YT";
        } else if (player.hasPermission("rang.jryt")) {
            team = "009JrYT";
        } else if (player.hasPermission("rang.apfel")) {
            team = "010Apfel";
        } else if (player.hasPermission("rang.eisen")) {
            team = "011Eisen";
        } else if (player.hasPermission("rang.gold")) {
            team = "012Gold";
        } else if (player.hasPermission("rang.premi")) {
            team = "013Premi";
        } else {
            team = "014Spieler";
        }

        scoreboard.getTeam(team).addPlayer(player);
        player.setDisplayName(scoreboard.getTeam(team).getPrefix() + player.getName() + "§r");

        for (Player all : Bukkit.getOnlinePlayers())
            all.setScoreboard(scoreboard);
    }
}
