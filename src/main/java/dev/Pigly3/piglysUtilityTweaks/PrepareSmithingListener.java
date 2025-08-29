package dev.Pigly3.piglysUtilityTweaks;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class PrepareSmithingListener implements Listener {
    @EventHandler
    public void onPrepareSmith(PrepareSmithingEvent event){
        List<Material> netheriteArmor = List.of(new Material[]{
                Material.NETHERITE_HELMET,
                Material.NETHERITE_CHESTPLATE,
                Material.NETHERITE_LEGGINGS,
                Material.NETHERITE_BOOTS
        });
        ItemStack result = event.getInventory().getRecipe().getResult();
        for (Material piece : netheriteArmor){
            if (result.getType() == piece){
                event.setResult(null);
                return;
            }
        }
    }
}
