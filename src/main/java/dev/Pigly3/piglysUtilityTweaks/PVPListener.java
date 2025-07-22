package dev.Pigly3.piglysUtilityTweaks;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;

public class PVPListener implements Listener {
    Plugin plugin;
    public PVPListener(Plugin plugin){
        this.plugin = plugin;
    }
    @EventHandler(priority=EventPriority.HIGHEST)
    public void onEntityDamagedByEntity(EntityDamageByEntityEvent event){
        if (event.getEntity() instanceof Player && event.getDamager() instanceof Player){
            if (!plugin.getConfig().getBoolean("pvp")){
                event.setCancelled(true);
            }
        }
    }
}
