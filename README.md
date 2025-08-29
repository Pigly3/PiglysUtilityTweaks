# Pigly's Utility Tweaks

A plugin to provide customization to SMP servers, with configurable tweaks.

## Tweaks
### World Border
    enabled: true
    overworld: 10000
    nether: 7500
    end: 20000
This allows admins to set a different world border for each dimension.
### Netherite
    netheriteUpgradeRecipe: true
    netheriteDupeRecipe:
        enabled: true
        useDiamondBlocks: false
This allows admins to control renewability of netherite and obtainability of netherite upgrade templates.

This is useful for servers with short world borders.

###### *Netherite dupe recipe*
![Recipe in crafting grid](https://img-devpigly.replit.app/netheritedupe.png)

###### *Netherite upgrade recipe*
![Recipe in crafting grid](https://img-devpigly.replit.app/netheriteupgrade.png)

### Netherite Loot Boost
    netheriteLootBoost: true
Increases the amount of loot in bastion chests.

### Golden Apples
    lightGoldenAppleCraft:
        enabled: true
        goldUsed: 4
    enableNotchAppleCraft: false
This allows admins to modify the golden apple recipe, and enable crafting of enchanted golden apples.

###### *A possible golden apple recipe*
![Possible recipe in crafting grid](https://img-devpigly.replit.app/possiblegap.png)

###### *Enchanted golden apple recipe*
![Recipe in crafting grid](https://img-devpigly.replit.app/notchapple.png)

### Locator Bar
    locatorBar:
        overworld: false
        nether: false
        end: true
This allows changing locator bar status by dimension, also allowing a fix for a bug in Paper where locator bar works in the nether even when disabled by a game rule.

### Events
    pvp: true
    enableEnd: true
These options are useful for events. PvP can be used for a grace period, and enableEnd can be used for an end fight.

Unlike Vanilla, PvP & end access can be toggled at any time with a command.

### Cobwebs
    craftableCobwebs:
        enabled: true
        resultNumber: 1

This allows a crafting recipe for cobwebs, and allowing the number of cobwebs crafted to be set.

###### *Cobweb recipe with resultNumber: 1*
![Recipe in crafting grid](https://img-devpigly.replit.app/cobweb.png)

### Dimension-Based Difficulty
    difficulty: #PEACEFUL, EASY, NORMAL, HARD
        overworld: HARD
        nether: HARD
        end: HARD
This must be in all caps to be parsed correctly by Paper's difficulty API.

### Sleep Percentage
    sleepPercentage: 100
This just sets the sleepPercentage game rule. It is here to make resetting worlds easier.

### Anvil Tweaks
    anvilTweaks:
        enable: true
        disableTooExpensive: true
        decreaseCost: true
If ```enable: false``` is set, then neither of the other settings in this category will apply.

```decreaseCost: true``` halves the cost of enchantments.

### End Replacements
    endReplacements:
        elytraCraftingRecipe: true
        endStoneRecipe: true
        chorusFlowerRecipe: true
        spireTrimRecipe: true
Creates crafting recipes for items that are cut off without end access.

###### *Elytra crafting recipe*
![Recipe in crafting grid](https://img-devpigly.replit.app/elytra-recipe.png)

###### *End stone crafting recipe, uses any type of cobblestone*
![Recipe in crafting grid](https://img-devpigly.replit.app/end-stone-craft.png)

###### *Chorus flower recipe*
![Recipe in crafting grid](https://img-devpigly.replit.app/chorus-flower-recipe.png)

###### *Spire trim recipe*
![Recipe in crafting grid](https://img-devpigly.replit.app/spire.png)

### Enchantment Tweaks
    enchantmentTweaks:
        enabled: true
        prot:
            enabled: true
            maxLevel: 3
        sharp:
            enabled: true
            maxLevel: 4
        power:
            enabled: true
            maxLevel: 4
Allows setting max levels for enchantments,
