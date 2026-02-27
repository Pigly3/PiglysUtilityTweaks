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
        event.getView().setRepairCost((int) (event.getView().getRepairCost() * plugin.getConfig().getDouble("anvilTweaks.costFactor")));
        if (plugin.getConfig().getBoolean("anvilTweaks.disableTooExpensive")) event.getView().setMaximumRepairCost(event.getView().getRepairCost()+20);
    }
}
