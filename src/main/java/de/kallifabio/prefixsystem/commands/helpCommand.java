package de.kallifabio.prefixsystem.commands;

import de.kallifabio.prefixsystem.Prefixsystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class helpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Prefixsystem.getPrefix() + "§cDu musst ein Spieler sein");
            return true;
        }

        final Player player = (Player) sender;

        if (player.hasPermission("command.use")) {
            if (cmd.getName().equalsIgnoreCase("prefixsystem")) {
                player.sendMessage("§8§m----------§6Help Prefixsystem§8§m----------");
                player.sendMessage("§bProgrammiert von §8" + Prefixsystem.getInstance().getDescription().getAuthors());
                player.sendMessage("§bDerzeitige Version §8" + Prefixsystem.getInstance().getDescription().getVersion());
                player.sendMessage(" ");
                player.sendMessage("Owner | rang.owner | §4Owner");
                player.sendMessage("Admin | rang.admin | §cAdmin");
                player.sendMessage("Dev | rang.dev | §3Dev");
                player.sendMessage("Mod | rang.mod | §fMod");
                player.sendMessage("Supp | rang.supp | §1Supp");
                player.sendMessage("Builder | rang.builder | §2Builder");
                player.sendMessage("Sponsor | rang.sponsor | §9Sponsor");
                player.sendMessage("Freund | rang.freund | §6Freund");
                player.sendMessage("YT | rang.yt | §5YT");
                player.sendMessage("JrYT | rang.jryt | §dJrYT");
                player.sendMessage("Apfel | rang.apfel | §aApfel");
                player.sendMessage("Eisen | rang.eisen | §7Eisen");
                player.sendMessage("Gold | rang.gold | §eGold");
                player.sendMessage("Premium | rang.premi");
                player.sendMessage("Spieler | Keine Rechte");
                player.sendMessage(" ");
                player.sendMessage("§bInfos auf §8https://www.spigotmc.org/resources/rang-prefix-system.49736/");
                player.sendMessage("§8§m----------§6Help Prefixsystem§8§m----------");
            } else {
                player.sendMessage(Prefixsystem.getPrefix() + "§cBitte benutze §7/prefixsystem");
            }
        } else {
            player.sendMessage(Prefixsystem.getPrefix() + "§4Du hast keine Rechte dazu");
        }
        return false;
    }
}
