package de.steuer.lobby.listener;

import de.steuer.lobby.inventories.JoinInv;
import de.steuer.lobby.inventories.NavInv;
import de.steuer.lobby.main.Main;
import de.steuer.lobby.utils.ItemAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if(e.getItem().getType() == Material.COMPASS) {
            if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lNavigator")) {
                NavInv.NavInvBefüllen();
                p.openInventory(NavInv.navInv);
                p.playSound(p.getLocation(), Sound.CHEST_OPEN, 1, 1);
            }
        } else if(e.getItem().getType() == Material.FEATHER) {
            if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lFlugfeder")) {
                if(Main.fly.contains(p)) {
                    Main.fly.remove(p);
                    p.setAllowFlight(false);
                    p.sendMessage(Main.prefix + "§7Der §a§lFlugmodus §r§7wurde §cdeaktiviert§7.");
                } else {
                    Main.fly.add(p);
                    p.setAllowFlight(true);
                    p.sendMessage(Main.prefix + "§7Der §a§lFlugmodus §r§7wurde §aaktiviert§7.");
                }
            }
        } else if(e.getItem().getType() == Material.STICK) {
            if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lSpieler verstecken")) {
                p.getInventory().setItem(1, new ItemAPI(Material.BLAZE_ROD).setName("§a§lSpieler anzeigen").build());
                p.sendMessage(Main.prefix + "§7Dir werden nun keine Spieler mehr §cangezeigt§7.");
                p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1, 1);
                for(Player all : Bukkit.getOnlinePlayers()) {
                    p.hidePlayer(all);
                }
            }
        } else if(e.getItem().getType() == Material.BLAZE_ROD) {
            if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lSpieler anzeigen")) {
                p.getInventory().setItem(1, new ItemAPI(Material.STICK).setName("§c§lSpieler verstecken").build());
                p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1, 1);
                for(Player all : Bukkit.getOnlinePlayers()) {
                    p.showPlayer(all);
                }
                p.sendMessage(Main.prefix + "§7Dir werden nun alle Spieler wieder §aangezeigt§7.");
            }
        }
    }
}
