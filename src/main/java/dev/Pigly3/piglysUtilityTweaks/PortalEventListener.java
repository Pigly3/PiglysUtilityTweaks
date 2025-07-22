package dev.Pigly3.piglysUtilityTweaks;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

public class PortalEventListener implements Listener {
    Plugin plugin;
    public PortalEventListener(Plugin plugin){
        this.plugin = plugin;
    }
    @EventHandler(priority= EventPriority.HIGHEST)
    public void onEvent(PlayerPortalEvent event){
        if (plugin.getConfig().getBoolean("end")){
            return;
        }
        if (event.getCause() == PlayerTeleportEvent.TeleportCause.END_PORTAL){
            event.setCancelled(true);
            event.getPlayer().teleport(event.getPlayer().getRespawnLocation() != null ? event.getPlayer().getRespawnLocation() : Objects.requireNonNull(Bukkit.getServer().getWorld("world")).getSpawnLocation());
        }
    }
}
