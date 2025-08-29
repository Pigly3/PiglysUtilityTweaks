package dev.Pigly3.piglysUtilityTweaks;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.plugin.Plugin;

public class PrepareAnvilListener implements Listener {
    Plugin plugin;
    public PrepareAnvilListener(Plugin plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onAnvilPrepare(PrepareAnvilEvent event){
        if (plugin.getConfig().getBoolean("anvilTweaks.decreaseCost")) event.getView().setRepairCost(event.getView().getRepairCost() / 2);
        if (plugin.getConfig().getBoolean("anvilTweaks.disableTooExpensive")) event.getView().setMaximumRepairCost(event.getView().getMaximumRepairCost());
    }
}
