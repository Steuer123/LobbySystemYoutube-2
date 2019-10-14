package de.steuer.lobby.commands;

import de.steuer.lobby.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class setupCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("lobby.setup")) {
                if(args.length == 1) {
                    FileConfiguration cfg = Main.getPlugin().getConfig();
                    if(args[0].equalsIgnoreCase("setuhc")) {
                        cfg.set("Location.uhc.world", p.getWorld().getName());
                        cfg.set("Location.uhc.x", p.getLocation().getX());
                        cfg.set("Location.uhc.y", p.getLocation().getY());
                        cfg.set("Location.uhc.z", p.getLocation().getZ());
                        cfg.set("Location.uhc.yaw", p.getLocation().getYaw());
                        cfg.set("Location.uhc.pitch", p.getLocation().getPitch());
                        Main.getPlugin().saveConfig();
                        p.sendMessage(Main.prefix + "§7Du hast den §e§lUHC §r§7Spawn erfolgreich gesetzt.");
                    } else if(args[0].equalsIgnoreCase("set1v1")) {
                        cfg.set("Location.1v1.world", p.getWorld().getName());
                        cfg.set("Location.1v1.x", p.getLocation().getX());
                        cfg.set("Location.1v1.y", p.getLocation().getY());
                        cfg.set("Location.1v1.z", p.getLocation().getZ());
                        cfg.set("Location.1v1.yaw", p.getLocation().getYaw());
                        cfg.set("Location.1v1.pitch", p.getLocation().getPitch());
                        Main.getPlugin().saveConfig();
                        p.sendMessage(Main.prefix + "§7Du hast den §c§l1v1 §r§7Spawn erfolgreich gesetzt.");
                    } else if(args[0].equalsIgnoreCase("setspawn")) {
                        cfg.set("Location.spawn.world", p.getWorld().getName());
                        cfg.set("Location.spawn.x", p.getLocation().getX());
                        cfg.set("Location.spawn.y", p.getLocation().getY());
                        cfg.set("Location.spawn.z", p.getLocation().getZ());
                        cfg.set("Location.spawn.yaw", p.getLocation().getYaw());
                        cfg.set("Location.spawn.pitch", p.getLocation().getPitch());
                        Main.getPlugin().saveConfig();
                        p.sendMessage(Main.prefix + "§7Du hast den §a§lSpawn §r§7Spawn erfolgreich gesetzt.");
                    }
                }
            } else
                p.sendMessage(Main.noperms);
        } else
            sender.sendMessage(Main.prefix + "§7Du musst ein Spieler sein.");



        return false;
    }
}
