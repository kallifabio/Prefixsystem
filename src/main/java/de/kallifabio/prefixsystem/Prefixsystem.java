package de.kallifabio.prefixsystem;

import de.kallifabio.prefixsystem.commands.helpCommand;
import de.kallifabio.prefixsystem.listeners.AsyncPlayerChatListener;
import de.kallifabio.prefixsystem.listeners.PlayerJoinListener;
import de.kallifabio.prefixsystem.manager.ConfigManager;
import de.kallifabio.prefixsystem.utils.FileBuilder;
import de.kallifabio.prefixsystem.utils.Settings;
import de.kallifabio.prefixsystem.utils.UpdateChecker;
import org.bukkit.Bukkit;
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

    private void registerCommand() {
        getCommand("prefixsystem").setExecutor(new helpCommand());
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
