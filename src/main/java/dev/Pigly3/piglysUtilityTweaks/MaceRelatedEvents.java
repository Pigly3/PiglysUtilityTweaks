package dev.Pigly3.piglysUtilityTweaks;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.util.Objects;

public class MaceRelatedEvents implements Listener {
    public PiglysUtilityTweaks plugin;
    public MaceRelatedEvents(PiglysUtilityTweaks plugin){
        this.plugin = plugin;
    }
    @EventHandler(priority= EventPriority.MONITOR)
    public void craftItemListener(CraftItemEvent event) {
        YamlConfiguration data = YamlConfiguration.loadConfiguration(plugin.file);
        if (event.getInventory().getResult() != null && Objects.requireNonNull(event.getCurrentItem()).getType() == Material.MACE){
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
    @EventHandler(priority=EventPriority.MONITOR)
    public void onPlayerDeath(PlayerDeathEvent event){
        if (event.isCancelled()) return;
        for (ItemStack item : event.getPlayer().getInventory().getContents()) {
            if (item != null) {
                if (item.getType() == Material.MACE && item.getEnchantments().get(Enchantment.VANISHING_CURSE) == 1) {
                    removeMace();
                }
            }
        }
    }
}
