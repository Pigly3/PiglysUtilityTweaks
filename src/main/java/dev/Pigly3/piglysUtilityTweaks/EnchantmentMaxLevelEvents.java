package dev.Pigly3.piglysUtilityTweaks;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class EnchantmentMaxLevelEvents implements Listener {
    Plugin plugin;
    public EnchantmentMaxLevelEvents(Plugin plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onInventoryMoveItem(InventoryMoveItemEvent event){
        ItemStack item = event.getItem();
        for (Enchantment enchantment : item.getEnchantments().keySet()){
            int maxLevel = plugin.getConfig().getInt(enchantment.getKey().getKey().replace("minecraft:", ""));
            if (maxLevel > 0){
                if (item.getEnchantmentLevel(enchantment) > maxLevel){
                    item.getEnchantments().put(enchantment, maxLevel);
                }
            }
        }
    }
}
