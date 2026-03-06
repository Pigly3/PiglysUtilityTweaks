package dev.Pigly3.piglysUtilityTweaks;

import com.destroystokyo.paper.MaterialTags;
import io.papermc.paper.potion.PotionMix;
import org.bukkit.*;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionType;

import java.io.File;
import java.util.Objects;

public final class PiglysUtilityTweaks extends JavaPlugin {
    File file;
    NamespacedKey maceKey = NamespacedKey.minecraft("mace");
    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        saveResource("data.yml", false);
        file = new File(this.getDataFolder(), "data.yml");
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
        if (getConfig().getBoolean("netherite.upgradeRecipe")){
            NamespacedKey key = new NamespacedKey(this, "NetheriteUpgradeRecipe");
            ItemStack result = ItemStack.of(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE);
            ShapedRecipe netheriteUpgradeRecipe = new ShapedRecipe(key, result);
            netheriteUpgradeRecipe.shape("ABA", "ACA", "AAA");
            netheriteUpgradeRecipe.setIngredient('A', Material.DIAMOND);
            netheriteUpgradeRecipe.setIngredient('B', Material.NETHERITE_INGOT);
            netheriteUpgradeRecipe.setIngredient('C', Material.BLACKSTONE);
            getServer().addRecipe(netheriteUpgradeRecipe);
        }
        if (getConfig().getBoolean("netherite.dupeRecipe.enabled")){
            NamespacedKey key = new NamespacedKey(this, "NetheriteDupeRecipe");
            ItemStack result = ItemStack.of(Material.NETHERITE_INGOT, 2);
            ShapedRecipe netheriteDupeRecipe = new ShapedRecipe(key, result);
            netheriteDupeRecipe.shape("ABA", "ACA", "AAA");
            if (getConfig().getBoolean("netherite.dpeRecipe.useDiamondBlocks")){
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
        World overworld = Bukkit.getWorld("world");
        if (overworld != null) {
            overworld.setGameRule(GameRules.LOCATOR_BAR, getConfig().getBoolean("locatorBar.overworld"));
            overworld.setDifficulty(Difficulty.valueOf(getConfig().getString("difficulty.overworld")));
            overworld.setGameRule(GameRules.PLAYERS_SLEEPING_PERCENTAGE, getConfig().getInt("sleepPercentage"));
        }
        World nether = Bukkit.getWorld("world_nether");
        if (nether != null){
            nether.setGameRule(GameRules.LOCATOR_BAR, getConfig().getBoolean("locatorBar.nether"));
            nether.setDifficulty(Difficulty.valueOf(getConfig().getString("difficulty.nether")));
        }
        World end = Bukkit.getWorld("world_the_end");
        if (end != null) {
            end.setGameRule(GameRules.LOCATOR_BAR, getConfig().getBoolean("locatorBar.end"));
            end.setDifficulty(Difficulty.valueOf(getConfig().getString("difficulty.end")));
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
        if (!getConfig().getBoolean("allowEndCrystals")) {
            getServer().removeRecipe(NamespacedKey.minecraft("end_crystal"));
        }
        if (getConfig().getBoolean("anvilTweaks.enable")){
            Bukkit.getPluginManager().registerEvents(new PrepareAnvilListener(this), this);
        }
        if (getConfig().getBoolean("endReplacements.elytraCraftingRecipe")){
            NamespacedKey key = new NamespacedKey(this, "Elytra");
            ShapedRecipe recipe = new ShapedRecipe(key, ItemStack.of(Material.ELYTRA));
            recipe.shape("BBB", "ADA", "C C");
            recipe.setIngredient('A', Material.ENDER_EYE);
            recipe.setIngredient('B', Material.PHANTOM_MEMBRANE);
            recipe.setIngredient('C', Material.NETHERITE_INGOT);
            recipe.setIngredient('D', Material.NETHER_STAR);
            getServer().addRecipe(recipe);
        }
        if (getConfig().getBoolean("endReplacements.endStoneRecipe")){
            NamespacedKey key = new NamespacedKey(this, "EndStone");
            ShapedRecipe recipe = new ShapedRecipe(key, ItemStack.of(Material.END_STONE, 8));
            recipe.shape("AAA", "ABA", "AAA");
            recipe.setIngredient('A', new RecipeChoice.MaterialChoice(MaterialTags.COBBLESTONES));
            recipe.setIngredient('B', Material.ENDER_EYE);
            getServer().addRecipe(recipe);
        }
        if (getConfig().getBoolean("endReplacements.chorusFlowerRecipe")) {
            NamespacedKey key = new NamespacedKey(this, "ChorusFlower");
            ShapedRecipe recipe = new ShapedRecipe(key, ItemStack.of(Material.CHORUS_FLOWER, 4));
            recipe.shape("AAA", "ABA", "ACA");
            recipe.setIngredient('A', Material.END_STONE);
            recipe.setIngredient('B', Material.ENDER_EYE);
            recipe.setIngredient('C', Material.OPEN_EYEBLOSSOM);
            getServer().addRecipe(recipe);
        }
        if (getConfig().getBoolean("netherite.lootBoost")){
            Bukkit.getPluginManager().registerEvents(new LootGenerateListener(), this);
        }
        if (getConfig().getBoolean("endReplacements.spireTrimRecipe")){
            NamespacedKey key = new NamespacedKey(this, "SpireTrim");
            ShapedRecipe recipe = new ShapedRecipe(key, ItemStack.of(Material.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE));
            recipe.shape("ACA", "ABA", "AAA");
            recipe.setIngredient('A', Material.DIAMOND);
            recipe.setIngredient('B', Material.PURPUR_BLOCK);
            recipe.setIngredient('C', Material.ENDER_EYE);
            getServer().addRecipe(recipe);
        }
        if (getConfig().getBoolean("netherite.disableArmor")){
            getServer().getPluginManager().registerEvents(new PrepareSmithingListener(), this);
        }
        if (getConfig().getBoolean("enchantmentMaxLevels.enabled")){
            getServer().getPluginManager().registerEvents(new EnchantmentMaxLevelEvents(this), this);
        }
        if (getConfig().getBoolean("maceLimit.enabled")){
            Bukkit.getPluginManager().registerEvents(new MaceRelatedEvents(this), this);
            YamlConfiguration data = YamlConfiguration.loadConfiguration(file);
            if (data.getInt("usedMaces") >= getConfig().getInt("maceLimit.count")) getServer().removeRecipe(maceKey);
        }
        if (getConfig().getBoolean("autoRestock")){
            getServer().getPluginManager().registerEvents(new AutoRestockListeners(), this);
        }
        if (getConfig().getBoolean("turtleTweaks.cheaperTurtleMaster")){
            Recipe recipe = getServer().getRecipe(NamespacedKey.minecraft(""));

            ItemStack result = new ItemStack(Material.POTION);
            PotionMeta itemMeta = (PotionMeta) result.getItemMeta();
            itemMeta.setBasePotionType(PotionType.TURTLE_MASTER);
            result.setItemMeta(itemMeta);

            ItemStack resultSplash = new ItemStack(Material.SPLASH_POTION);
            PotionMeta itemMetaSplash = (PotionMeta) resultSplash.getItemMeta();
            itemMetaSplash.setBasePotionType(PotionType.TURTLE_MASTER);
            resultSplash.setItemMeta(itemMetaSplash);

            ItemStack resultLingering = new ItemStack(Material.LINGERING_POTION);
            PotionMeta itemMetaLingering = (PotionMeta) resultLingering.getItemMeta();
            itemMetaLingering.setBasePotionType(PotionType.TURTLE_MASTER);
            resultLingering.setItemMeta(itemMetaLingering);

            RecipeChoice awkwardPotion = PotionMix.createPredicateChoice(item -> {
                if (item.getType() != Material.POTION) return false;
                if (item.getItemMeta() != null && item.getItemMeta() instanceof PotionMeta meta){
                    return meta.getBasePotionType() == PotionType.AWKWARD ;
                }
                return false;
            });
            RecipeChoice splashAwkward = PotionMix.createPredicateChoice(item -> {
                if (item.getType() != Material.SPLASH_POTION) return false;
                if (item.getItemMeta() != null && item.getItemMeta() instanceof PotionMeta meta){
                    return meta.getBasePotionType() == PotionType.AWKWARD ;
                }
                return false;
            });
            RecipeChoice lingeringAwkward = PotionMix.createPredicateChoice(item -> {
                if (item.getType() != Material.LINGERING_POTION) return false;
                if (item.getItemMeta() != null && item.getItemMeta() instanceof PotionMeta meta){
                    return meta.getBasePotionType() == PotionType.AWKWARD ;
                }
                return false;
            });

            RecipeChoice scute = PotionMix.createPredicateChoice(item -> {
                return item.getType() == Material.TURTLE_SCUTE;
            });

            PotionMix mix = new PotionMix(new NamespacedKey(this, "turtle_master"), result, awkwardPotion, scute);
            PotionMix splashMix = new PotionMix(new NamespacedKey(this, "turtle_master_splash"), resultSplash, splashAwkward, scute);
            PotionMix lingeringMix = new PotionMix(new NamespacedKey(this, "turtle_master_lingering"), resultLingering, lingeringAwkward, scute);

            getServer().getPotionBrewer().addPotionMix(mix);
            getServer().getPotionBrewer().addPotionMix(splashMix);
            getServer().getPotionBrewer().addPotionMix(lingeringMix);
        }

        if (getConfig().getBoolean("turtleTweaks.dropScutes")){
            getServer().getPluginManager().registerEvents(new TurtleDeathListener(this), this);
        }
        if (getConfig().getBoolean("speed.enabled")) {
            getServer().getPluginManager().registerEvents(new SpeedListeners(this), this);
        }
        if (getConfig().getBoolean("disableElytraMovementCheck")){
            getServer().getWorld("world").setGameRule(GameRules.ELYTRA_MOVEMENT_CHECK, false);
            getServer().getWorld("world_nether").setGameRule(GameRules.ELYTRA_MOVEMENT_CHECK, false);
            getServer().getWorld("world_the_end").setGameRule(GameRules.ELYTRA_MOVEMENT_CHECK, false);
        }
        //PvP enabled/disabled
        Objects.requireNonNull(getServer().getWorld("world")).setGameRule(GameRules.PVP, getConfig().getBoolean("pvp.overworld"));
        Objects.requireNonNull(getServer().getWorld("world_nether")).setGameRule(GameRules.PVP, getConfig().getBoolean("pvp.nether"));
        Objects.requireNonNull(getServer().getWorld("world_the_end")).setGameRule(GameRules.PVP, getConfig().getBoolean("pvp.end"));
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
