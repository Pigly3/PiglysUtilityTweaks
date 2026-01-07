package dev.Pigly3.piglysUtilityTweaks;

import io.papermc.paper.event.player.PlayerTradeEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class AutoRestockListeners implements Listener {
    @EventHandler
    public void onTradeEvent(PlayerTradeEvent event){
        event.getTrade().setUses(0);
    }
}
