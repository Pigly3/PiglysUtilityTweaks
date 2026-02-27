package dev.Pigly3.piglysUtilityTweaks;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class TurtleDeathListener implements Listener {
    Plugin plugin;
    public TurtleDeathListener(Plugin plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onTurtleDeath(EntityDeathEvent event){
        if (event.getEntityType() == EntityType.TURTLE){
            double num = Math.random() * 100;
            if (num < plugin.getConfig().getDouble("turtleTweaks.scuteChance")){
                event.getDrops().add(ItemStack.of(Material.TURTLE_SCUTE));
            }
        }
    }
}
