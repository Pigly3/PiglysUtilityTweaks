package dev.Pigly3.piglysUtilityTweaks;

import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public final class PiglysUtilityTweaks extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        final PVPCommand PvPCommandInstance = new PVPCommand(this);
        final EndCommand EndCommandInstance = new EndCommand(this);
        this.getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, commands -> {
            commands.registrar().register("pvp", PvPCommandInstance);
            commands.registrar().register("endAccess", EndCommandInstance);
        });
        getServer().getPluginManager().registerEvents(new PVPListener(this), this);
        if (getConfig().getBoolean("customWorldBorder.enabled")){
            if (Bukkit.getWorld("world_nether") != null) {
                Bukkit.getWorld("world_nether").getWorldBorder().setSize(getConfig().getDouble("customWorldBorder.nether"));
            }
            if (Bukkit.getWorld("world") != null) {
                Bukkit.getWorld("world").getWorldBorder().setSize(getConfig().getDouble("customWorldBorder.overworld"));
            }
            if (Bukkit.getWorld("world_the_end") != null) {
                Bukkit.getWorld("world_the_end").getWorldBorder().setSize(getConfig().getDouble("customWorldBorder.end"));
            }
        }
        if (getConfig().getBoolean("netheriteUpgradeRecipe")){
            NamespacedKey key = new NamespacedKey(this, "NetheriteUpgradeRecipe");
            ItemStack result = ItemStack.of(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE);
            ShapedRecipe netheriteUpgradeRecipe = new ShapedRecipe(key, result);
            netheriteUpgradeRecipe.shape("ABA", "ACA", "AAA");
            netheriteUpgradeRecipe.setIngredient('A', Material.DIAMOND);
            netheriteUpgradeRecipe.setIngredient('B', Material.NETHERITE_INGOT);
            netheriteUpgradeRecipe.setIngredient('C', Material.BLACKSTONE);
            getServer().addRecipe(netheriteUpgradeRecipe);
        }
        if (getConfig().getBoolean("netheriteDupeRecipe.enabled")){
            NamespacedKey key = new NamespacedKey(this, "NetheriteDupeRecipe");
            ItemStack result = ItemStack.of(Material.NETHERITE_INGOT, 2);
            ShapedRecipe netheriteDupeRecipe = new ShapedRecipe(key, result);
            netheriteDupeRecipe.shape("ABA", "ACA", "AAA");
            if (getConfig().getBoolean("netheriteDupeRecipe.useDiamondBlocks")){
                netheriteDupeRecipe.setIngredient('A', Material.DIAMOND_BLOCK);
            } else {
                netheriteDupeRecipe.setIngredient('A', Material.DIAMOND);
            }
            netheriteDupeRecipe.setIngredient('B', Material.NETHERITE_INGOT);
            netheriteDupeRecipe.setIngredient('C', Material.NETHERRACK);
            getServer().addRecipe(netheriteDupeRecipe);
        }
        if (getConfig().getBoolean("lightGoldenAppleCraft.enabled")){
            NamespacedKey appleKey = NamespacedKey.minecraft("golden_apple");
            getServer().removeRecipe(appleKey);
            NamespacedKey key = new NamespacedKey(this, "LightGoldenAppleRecipe");
            ShapelessRecipe lightGoldenAppleRecipe = new ShapelessRecipe(key, ItemStack.of(Material.GOLDEN_APPLE));
            lightGoldenAppleRecipe.addIngredient(getConfig().getInt("lightGoldenAppleCraft.goldUsed"), Material.GOLD_INGOT);
            lightGoldenAppleRecipe.addIngredient(1, Material.APPLE);
            getServer().addRecipe(lightGoldenAppleRecipe);
        }
        if (Bukkit.getWorld("world") != null) {
            Bukkit.getWorld("world").setGameRule(GameRule.LOCATOR_BAR, getConfig().getBoolean("locatorBar.overworld"));
        }
        if (Bukkit.getWorld("world_nether") != null){
            Bukkit.getWorld("world_nether").setGameRule(GameRule.LOCATOR_BAR, getConfig().getBoolean("locatorBar.nether"));
        }
        if (Bukkit.getWorld("world_the_end") != null) {
            Bukkit.getWorld("world_the_end").setGameRule(GameRule.LOCATOR_BAR, getConfig().getBoolean("locatorBar.end"));
        }
        if (getConfig().getBoolean("enableNotchAppleCraft")){
            NamespacedKey key = new NamespacedKey(this, "NotchApple");
            ShapedRecipe recipe = new ShapedRecipe(key, ItemStack.of(Material.ENCHANTED_GOLDEN_APPLE));
            recipe.shape("AAA", "ABA", "AAA");
            recipe.setIngredient('A', Material.GOLD_BLOCK);
            recipe.setIngredient('B', Material.APPLE);
            getServer().addRecipe(recipe);
        }
        if (getConfig().getBoolean("craftableCobwebs.enabled")){
            NamespacedKey key = new NamespacedKey(this, "Cobweb");
            ShapedRecipe recipe = new ShapedRecipe(key, ItemStack.of(Material.COBWEB, getConfig().getInt("craftableCobwebs.resultNumber")));
            recipe.shape("A A", " A ", "A A");
            recipe.setIngredient('A', Material.STRING);
            getServer().addRecipe(recipe);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
