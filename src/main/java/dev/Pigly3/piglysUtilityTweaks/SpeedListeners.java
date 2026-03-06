package dev.Pigly3.piglysUtilityTweaks;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

public class SpeedListeners implements Listener {
    Plugin plugin;
    public SpeedListeners(Plugin plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event){
        if (event.getEntity().getType() == EntityType.HAPPY_GHAST){
            LivingEntity ghast = event.getEntity();
            Objects.requireNonNull(ghast.getAttribute(Attribute.FLYING_SPEED)).setBaseValue(plugin.getConfig().getDouble("speed.happyGhast"));
        }
    }
}
