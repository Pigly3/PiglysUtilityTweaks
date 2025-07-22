package dev.Pigly3.piglysUtilityTweaks;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

public class PVPCommand implements BasicCommand {
    Plugin plugin;
    public PVPCommand(Plugin plugin){
        this.plugin = plugin;
    }
    @Override
    public void execute(CommandSourceStack commandSourceStack, String[] args) {
        if (args.length != 1){
            commandSourceStack.getSender().sendMessage("§4This command expects one argument");
            return;
        }
        if (!Objects.equals(args[0], "true") && !Objects.equals(args[0], "false")){
            commandSourceStack.getSender().sendMessage("§4Argument must be a boolean");
            return;
        }
        commandSourceStack.getSender().sendMessage(String.format("§2%s PvP", Objects.equals(args[0], "true") ? "Enabled" : "Disabled"));
        plugin.getConfig().set("pvp", args[0]);
    }
}
