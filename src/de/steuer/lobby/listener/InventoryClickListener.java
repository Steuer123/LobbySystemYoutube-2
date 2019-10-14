package de.steuer.lobby.listener;

import de.steuer.lobby.inventories.NavInv;
import de.steuer.lobby.main.Main;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        FileConfiguration cfg = Main.getPlugin().getConfig();
        Player p = (Player) e.getWhoClicked();
        if(e.getClickedInventory().equals(NavInv.navInv)) {
            if(e.getCurrentItem().getType() == Material.GOLDEN_APPLE) {
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lUHC")) {
                    World world = Bukkit.getWorld(cfg.getString("Location.uhc.world"));
                    double x = cfg.getDouble("Location.uhc.x");
                    double y = cfg.getDouble("Location.uhc.y");
                    double z = cfg.getDouble("Location.uhc.z");
                    float yaw = (float) cfg.getDouble("Location.uhc.yaw");
                    float pitch = (float) cfg.getDouble("Location.uhc.pitch");

                    Location loc = new Location(world, x, y, z, yaw, pitch);
                    p.closeInventory();
                    p.teleport(loc);
                    p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1, 1);
                    p.sendMessage(Main.prefix + "§7Du wurdest zu §e§lUHC §r§7teleportiert.");
                }
            }
        }
    }
}
