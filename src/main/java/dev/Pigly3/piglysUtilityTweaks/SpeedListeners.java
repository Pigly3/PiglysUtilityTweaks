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
        } else if (event.getEntity().getType() == EntityType.HORSE){
            LivingEntity horse = event.getEntity();
            Objects.requireNonNull(horse.getAttribute(Attribute.MOVEMENT_SPEED)).setBaseValue(Objects.requireNonNull(horse.getAttribute(Attribute.MOVEMENT_SPEED)).getBaseValue() * plugin.getConfig().getDouble("speedMultipliers.horse"));
        } else if (event.getEntity().getType() == EntityType.DONKEY){
            LivingEntity donkey = event.getEntity();
            Objects.requireNonNull(donkey.getAttribute(Attribute.MOVEMENT_SPEED)).setBaseValue(Objects.requireNonNull(donkey.getAttribute(Attribute.MOVEMENT_SPEED)).getBaseValue() * plugin.getConfig().getDouble("speedMultipliers.donkey"));
        } else if (event.getEntity().getType() == EntityType.MULE){
            LivingEntity mule = event.getEntity();
            Objects.requireNonNull(mule.getAttribute(Attribute.MOVEMENT_SPEED)).setBaseValue(Objects.requireNonNull(mule.getAttribute(Attribute.MOVEMENT_SPEED)).getBaseValue() * plugin.getConfig().getDouble("speedMultipliers.mule"));
        } else if (event.getEntity().getType() == EntityType.SKELETON_HORSE){
            LivingEntity skeletonHorse = event.getEntity();
            Objects.requireNonNull(skeletonHorse.getAttribute(Attribute.MOVEMENT_SPEED)).setBaseValue(Objects.requireNonNull(skeletonHorse.getAttribute(Attribute.MOVEMENT_SPEED)).getBaseValue() * plugin.getConfig().getDouble("speedMultipliers.skeletonHorse"));
        } else if (event.getEntity().getType() == EntityType.ZOMBIE_HORSE){
            LivingEntity zombieHorse = event.getEntity();
            Objects.requireNonNull(zombieHorse.getAttribute(Attribute.MOVEMENT_SPEED)).setBaseValue(Objects.requireNonNull(zombieHorse.getAttribute(Attribute.MOVEMENT_SPEED)).getBaseValue() * plugin.getConfig().getDouble("speedMultipliers.zombieHorse"));
        } else if (event.getEntity().getType() == EntityType.NAUTILUS){
            LivingEntity nautilus = event.getEntity();
            Objects.requireNonNull(nautilus.getAttribute(Attribute.MOVEMENT_SPEED)).setBaseValue(plugin.getConfig().getDouble("speed.nautilus"));
        } else if (event.getEntity().getType() == EntityType.ZOMBIE_NAUTILUS){
            LivingEntity zombieNautilus = event.getEntity();
            Objects.requireNonNull(zombieNautilus.getAttribute(Attribute.MOVEMENT_SPEED)).setBaseValue(plugin.getConfig().getDouble("speed.zombieNautilus"));
        }
    }
}
