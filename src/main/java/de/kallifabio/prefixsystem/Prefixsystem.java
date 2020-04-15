package de.kallifabio.prefixsystem;

import de.kallifabio.prefixsystem.listeners.AsyncPlayerChatListener;
import de.kallifabio.prefixsystem.listeners.PlayerJoinListener;
import de.kallifabio.prefixsystem.manager.ConfigManager;
import de.kallifabio.prefixsystem.utils.FileBuilder;
import de.kallifabio.prefixsystem.utils.Settings;
import de.kallifabio.prefixsystem.utils.UpdateChecker;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Prefixsystem extends JavaPlugin {

    private static Prefixsystem instance;

    private static final String prefix = "§8[§cPrefixsystem§8] §r";

    private final ConfigManager configManager = new ConfigManager();

    @Override
    public void onEnable() {
        instance = this;
        loadConfig();
        registerCommand();
        registerEvents();
        new UpdateChecker(49736).getLatestVersion(version -> {
            if (getDescription().getVersion().equalsIgnoreCase(version)) {
                System.out.println("Pluginversion ist aktuell!");
            } else {
                System.out.println("*********************************************************************");
                System.out.println("Pluginversion ist nicht aktuell!");
                System.out.println("Neuste Version: " + version);
                System.out.println("Deine Version: " + Settings.VERSION);
                System.out.println("Update herunterladen: " + Settings.PLUGIN_URL);
                System.out.println("*********************************************************************");
            }
        });
        Bukkit.getConsoleSender().sendMessage(prefix + "§aDas Plugin wurde mit der Version§8: §e" + getInstance().getDescription().getVersion() + "§a geladen");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(prefix + "§cDas Plugin wurde gestoppt");
    }

    private void loadConfig() {
        if (!new FileBuilder("plugins/Prefixsystem", "config.yml").exist()) {
            configManager.save();
        }
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(prefix + "§cDu musst ein Spieler sein");
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("prefixsystem")) {
            sender.sendMessage("§8§m----------§6Help Prefixsystem§8§m----------");
            sender.sendMessage("§bProgrammiert von §8" + getInstance().getDescription().getAuthors());
            sender.sendMessage("§bDerzeitige Version §8" + getInstance().getDescription().getVersion());
            sender.sendMessage(" ");
            sender.sendMessage("Owner | rang.owner | §4Owner");
            sender.sendMessage("Admin | rang.admin | §cAdmin");
            sender.sendMessage("Dev | rang.dev | §3Dev");
            sender.sendMessage("Mod | rang.mod | §fMod");
            sender.sendMessage("Supp | rang.supp | §1Supp");
            sender.sendMessage("Builder | rang.builder | §2Builder");
            sender.sendMessage("Sponsor | rang.sponsor | §9Sponsor");
            sender.sendMessage("Freund | rang.freund | §6Freund");
            sender.sendMessage("YT | rang.yt | §5YT");
            sender.sendMessage("JrYT | rang.jryt | §dJrYT");
            sender.sendMessage("Apfel | rang.apfel | §aApfel");
            sender.sendMessage("Eisen | rang.eisen | §7Eisen");
            sender.sendMessage("Gold | rang.gold | §eGold");
            sender.sendMessage("Premium | rang.premi");
            sender.sendMessage("Spieler | Keine Rechte");
            sender.sendMessage(" ");
            sender.sendMessage("§bInfos auf §8https://www.spigotmc.org/resources/rang-prefix-system.49736/");
            sender.sendMessage("§8§m----------§6Help Prefixsystem§8§m----------");
        }
        return false;
    }

    private void registerCommand() {
        getCommand("prefixsystem").setExecutor(this);
    }

    private void registerEvents() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new PlayerJoinListener(), this);
        pluginManager.registerEvents(new AsyncPlayerChatListener(), this);
    }

    public static String getPrefix() {
        return prefix;
    }

    public static Prefixsystem getInstance() {
        return instance;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }
}
