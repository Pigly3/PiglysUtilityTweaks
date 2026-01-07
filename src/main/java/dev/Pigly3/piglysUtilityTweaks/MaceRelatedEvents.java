package dev.Pigly3.piglysUtilityTweaks;

import io.papermc.paper.event.entity.EntityDamageItemEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.event.inventory.CraftItemEvent;

import java.io.IOException;

public class MaceRelatedEvents implements Listener {
    public PiglysUtilityTweaks plugin;
    public MaceRelatedEvents(PiglysUtilityTweaks plugin){
        this.plugin = plugin;
    }
    @EventHandler(priority= EventPriority.MONITOR)
    public void craftItemListener(CraftItemEvent event) {
        YamlConfiguration data = YamlConfiguration.loadConfiguration(plugin.file);
        if (event.getInventory().getResult() != null && event.getCurrentItem().getType() == Material.MACE){
            if (data.getInt("usedMaces") + 1 >= plugin.getConfig().getInt("maceLimit.count")) Bukkit.getServer().removeRecipe(plugin.maceKey);
            data.set("usedMaces", data.getInt("usedMaces") + 1);
            Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
                try {
                    data.save(plugin.file);
                } catch (IOException e) {
                    plugin.getLogger().severe(e.getMessage());
                }
            });
        }
    }
    public void removeMace(){
        YamlConfiguration data = YamlConfiguration.loadConfiguration(plugin.file);
        if (data.getInt("usedMaces") - 1 < plugin.getConfig().getInt("maceLimit.count")) Bukkit.getServer().addRecipe(Bukkit.getRecipe(plugin.maceKey));
        data.set("usedMaces", data.getInt("usedMaces") - 1);
        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            try {
                data.save(plugin.file);
            } catch (IOException e) {
                plugin.getLogger().severe(e.getMessage());
            }
        });
    }
    @EventHandler(priority= EventPriority.MONITOR)
    public void itemDespawnListener(ItemDespawnEvent event){
        if (event.getEntity().getItemStack().getType() == Material.MACE) removeMace();
    }
    @EventHandler(priority= EventPriority.MONITOR)
    public void itemDamagedListener(EntityDamageEvent event){
        if (event.getEntityType() == EntityType.ITEM){
            Item item = (Item) event.getEntity();
            if (item.getItemStack().getType() == Material.MACE) removeMace();
        }
    }
}
