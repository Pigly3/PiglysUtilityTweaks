package dev.Pigly3.piglysUtilityTweaks;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.LootGenerateEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class LootGenerateListener implements Listener {
    @EventHandler
    public void onGenerateLoot(LootGenerateEvent event){
        List<ItemStack> loot = event.getLoot();
        if (event.isPlugin()){
            return;
        }
        if (loot.isEmpty()){
            return;
        }
        for (int i = 0; i < loot.toArray().length; i++){
            if (loot.get(i).getType() == Material.NETHERITE_INGOT){
                ItemStack currStack = loot.get(i);
                currStack.setAmount(currStack.getAmount() + 1);
                loot.set(i, currStack);
            }
            if (loot.get(i).getType() == Material.NETHERITE_SCRAP){
                ItemStack currStack = loot.get(i);
                currStack.setAmount(currStack.getAmount() + 2);
                loot.set(i, currStack);
            }
            if (loot.get(i).getType() == Material.ANCIENT_DEBRIS){
                ItemStack currStack = loot.get(i);
                currStack.setAmount(currStack.getAmount() + 2);
                loot.set(i, currStack);
            }
        }
        event.setLoot(loot);
    }
}
