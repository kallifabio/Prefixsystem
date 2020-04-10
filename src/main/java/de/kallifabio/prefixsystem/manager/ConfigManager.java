package de.kallifabio.prefixsystem.manager;

import de.kallifabio.prefixsystem.utils.FileBuilder;
import org.bukkit.ChatColor;

public class ConfigManager {

    private FileBuilder builder = new FileBuilder("plugins/Rangsystem", "config.yml");

    public void save() {
        builder.setValue("Update.Enabled", true);
        builder.setValue("Prefix.Owner", ChatColor.translateAlternateColorCodes('&', "§4Owner §7| §4"));
        builder.setValue("Prefix.Admin", ChatColor.translateAlternateColorCodes('&', "§cAdmin §7| §c"));
        builder.setValue("Prefix.Developer", ChatColor.translateAlternateColorCodes('&', "§3Dev §7| §3"));
        builder.setValue("Prefix.Moderator", ChatColor.translateAlternateColorCodes('&', "§fMod §7| §f"));
        builder.setValue("Prefix.Supporter", ChatColor.translateAlternateColorCodes('&', "§1Supp §7| §1"));
        builder.setValue("Prefix.Builder", ChatColor.translateAlternateColorCodes('&', "§2Builder §7| §2"));
        builder.setValue("Prefix.Sponsor", ChatColor.translateAlternateColorCodes('&', "§9Sponsor §7| §9"));
        builder.setValue("Prefix.YouTuber", ChatColor.translateAlternateColorCodes('&', "§5YT §7| §5"));
        builder.setValue("Prefix.JrYouTuber", ChatColor.translateAlternateColorCodes('&', "§dJrYT §7| §d"));
        builder.setValue("Prefix.Apfel", ChatColor.translateAlternateColorCodes('&', "§aApfel §7| §a"));
        builder.setValue("Prefix.Eisen", ChatColor.translateAlternateColorCodes('&', "§7Eisen §7| §7"));
        builder.setValue("Prefix.Gold", ChatColor.translateAlternateColorCodes('&', "§eGold §7| §e"));
        builder.setValue("Prefix.Premium", ChatColor.translateAlternateColorCodes('&', "§6Premium §7| §6"));
        builder.setValue("Prefix.Spieler", ChatColor.translateAlternateColorCodes('&', "§8"));
        builder.save();
    }

    public FileBuilder getBuilder() {
        return builder;
    }
}
