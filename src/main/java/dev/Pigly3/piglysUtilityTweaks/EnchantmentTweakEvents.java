package dev.Pigly3.piglysUtilityTweaks;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentOffer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;
import org.bukkit.event.world.LootGenerateEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.plugin.Plugin;

public class EnchantmentTweakEvents implements Listener {
    Plugin plugin;
    public EnchantmentTweakEvents(Plugin plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onLootGenerate(LootGenerateEvent event){
        event.getLoot().forEach((ItemStack item) ->{
            if (item.getEnchantments().containsKey(Enchantment.PROTECTION)) {
                if (item.getEnchantments().get(Enchantment.PROTECTION) > plugin.getConfig().getInt("enchantmentTweaks.prot.maxLevel")) {
                    item.getEnchantments().put(Enchantment.PROTECTION, plugin.getConfig().getInt("enchantmentTweaks.prot.maxLevel"));
                }
            }
            if (item.getEnchantments().containsKey(Enchantment.SHARPNESS)) {
                if (item.getEnchantments().get(Enchantment.SHARPNESS) > plugin.getConfig().getInt("enchantmentTweaks.sharp.maxLevel")) {
                    item.getEnchantments().put(Enchantment.SHARPNESS, plugin.getConfig().getInt("enchantmentTweaks.sharp.maxLevel"));
                }
            }
            if (item.getEnchantments().containsKey(Enchantment.POWER)) {
                if (item.getEnchantments().get(Enchantment.POWER) > plugin.getConfig().getInt("enchantmentTweaks.power.maxLevel")) {
                    item.getEnchantments().put(Enchantment.POWER, plugin.getConfig().getInt("enchantmentTweaks.power.maxLevel"));
                }
            }
        });
    }
    @EventHandler
    public void onPrepareEnchant(PrepareItemEnchantEvent event){
        for (EnchantmentOffer offer : event.getOffers()){
            assert offer != null;
            if (offer.getEnchantment() == Enchantment.PROTECTION && offer.getEnchantmentLevel() > plugin.getConfig().getInt("enchantmentTweaks.prot.maxLevel")){
                offer.setEnchantmentLevel(plugin.getConfig().getInt("enchantmentTweaks.prot.maxLevel"));
            }
            if (offer.getEnchantment() == Enchantment.SHARPNESS && offer.getEnchantmentLevel() > plugin.getConfig().getInt("enchantmentTweaks.sharp.maxLevel")){
                offer.setEnchantmentLevel(plugin.getConfig().getInt("enchantmentTweaks.sharp.maxLevel"));
            }
            if (offer.getEnchantment() == Enchantment.POWER && offer.getEnchantmentLevel() > plugin.getConfig().getInt("enchantmentTweaks.power.maxLevel")){
                offer.setEnchantmentLevel(plugin.getConfig().getInt("enchantmentTweaks.power.maxLevel"));
            }
        }
    }
    @EventHandler
    public void onVillagerAcquireTrade(VillagerAcquireTradeEvent event){
        if (event.getRecipe().getResult().getEnchantments().containsKey(Enchantment.PROTECTION)){
            if (event.getRecipe().getResult().getEnchantments().get(Enchantment.PROTECTION) > plugin.getConfig().getInt("enchantmentTweaks.prot.maxLevel")){
                MerchantRecipe newRecipe = event.getRecipe();
                newRecipe.getResult().getEnchantments().put(Enchantment.PROTECTION, plugin.getConfig().getInt("enchantmentTweaks.prot.maxLevel"));
                event.setRecipe(newRecipe);
            }
            if (event.getRecipe().getResult().getEnchantments().get(Enchantment.SHARPNESS) > plugin.getConfig().getInt("enchantmentTweaks.sharp.maxLevel")){
                MerchantRecipe newRecipe = event.getRecipe();
                newRecipe.getResult().getEnchantments().put(Enchantment.SHARPNESS, plugin.getConfig().getInt("enchantmentTweaks.sharp.maxLevel"));
                event.setRecipe(newRecipe);
            }
            if (event.getRecipe().getResult().getEnchantments().get(Enchantment.POWER) > plugin.getConfig().getInt("enchantmentTweaks.power.maxLevel")){
                MerchantRecipe newRecipe = event.getRecipe();
                newRecipe.getResult().getEnchantments().put(Enchantment.POWER, plugin.getConfig().getInt("enchantmentTweaks.power.maxLevel"));
                event.setRecipe(newRecipe);
            }
        }
    }
}
