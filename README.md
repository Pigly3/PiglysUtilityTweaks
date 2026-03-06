# Pigly's Utility Tweaks
<a href="https://modrinth.com/plugin/piglys-utility-tweaks"><img src="https://img.shields.io/badge/dynamic/json?color=158000&label=downloads&prefix=+%20&query=downloads&url=https://api.modrinth.com/v2/project/MbJbgd17&logo=modrinth" alt="Modrinth Downloads"></a>

A plugin to provide customization to SMP servers, with configurable tweaks.

## Tweaks
Configuration listed in this documentation is **not guaranteed** to be the default configuration.
### World Border
    enabled: true
    overworld: 10000
    nether: 7500
    end: 20000
This allows admins to set a different world border for each dimension.
### Netherite
    lootBoost: true
    netheriteUpgradeRecipe: true
    netheriteDupeRecipe:
        enabled: true
        useDiamondBlocks: false
This allows admins to control renewability of netherite and obtainability of netherite upgrade templates.

This is useful for servers with short world borders.

###### *Netherite dupe recipe*
![Recipe in crafting grid](https://cdn.modrinth.com/data/MbJbgd17/images/dbac65732c7312f25c0b1c84b893ea6f8459b1f7.png)

###### *Netherite upgrade recipe*
![Recipe in crafting grid](https://cdn.modrinth.com/data/MbJbgd17/images/9766469aa1120b587b8baaf9139ffb3a3569abee.png)

### Golden Apples
    lightGoldenAppleCraft:
        enabled: true
        goldUsed: 4
    enableNotchAppleCraft: false
This allows admins to modify the golden apple recipe, and enable crafting of enchanted golden apples.

###### *A possible golden apple recipe*
![Possible recipe in crafting grid](https://cdn.modrinth.com/data/MbJbgd17/images/6fa5ef4b5d605f2ba23f018ecde5b0d00c57a070.png)

###### *Enchanted golden apple recipe*
![Recipe in crafting grid](https://cdn.modrinth.com/data/MbJbgd17/images/fd48603cfc9e6ab2d8c2d3823b06014e88f4e323.png)

### Locator Bar
    locatorBar:
        overworld: false
        nether: false
        end: true
This allows changing locator bar status by dimension, also allowing a fix for a bug in Paper where locator bar works in the Nether even when disabled by a game rule.

### Events
    enableEnd: true
    pvp: true #Removed in 1.4.0
These options are useful for events. PvP can be used for a grace period, and enableEnd can be used for an end fight.

Unlike Vanilla, PvP & end access can be toggled at any time with a command.

### Cobwebs
    craftableCobwebs:
        enabled: true
        resultNumber: 1

This allows a crafting recipe for cobwebs, and allowing the number of cobwebs crafted to be set.

###### *Cobweb recipe with resultNumber: 1*
![Recipe in crafting grid](https://cdn.modrinth.com/data/MbJbgd17/images/372360495b7a5344d72bf7317c57610a72e635c9.png)

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
        costFactor: 1
If ```enable: false``` is set, then neither of the other settings in this category will apply.

If ```disableTooExpensive: true``` is set, anvil cost will not be capped, so no repairs will be too expensive.

```costFactor: 1``` scales the cost of enchantments according to the factor. The factor will accept any `double` value.

### End Replacements
    endReplacements:
        elytraCraftingRecipe: true
        endStoneRecipe: true
        chorusFlowerRecipe: true
        spireTrimRecipe: true
Creates crafting recipes for items that are cut off without end access.

###### *Elytra crafting recipe*
![Recipe in crafting grid](https://cdn.modrinth.com/data/MbJbgd17/images/33db16da54fab0424cffad6e6b42fcfd9f367047.png)

###### *End stone crafting recipe, uses any type of cobblestone*
![Recipe in crafting grid](https://cdn.modrinth.com/data/MbJbgd17/images/49a6f74372e939c7afbddd360b0f342a21ff01fb.png)

###### *Chorus flower recipe*
![Recipe in crafting grid](https://cdn.modrinth.com/data/MbJbgd17/images/130c8cf776d37dcc619df2d6f16ed7d761a3553f.png)

###### *Spire trim recipe*
![Recipe in crafting grid](https://cdn.modrinth.com/data/MbJbgd17/images/2f5a0d4cb83f1b99d88d1bca7fe69969f8381887.png)

### Enchantment Max Levels
    enchantmentMaxLevels:
        enabled: false
        protection: 3
        sharpness: 4
        power: 4
Allows setting max levels for enchantments. You can set a max level for any enchantment, by simply making an entry with the enchantment name. You can also just remove the entry for an enchantment.
### PvP Settings by Dimension
    pvp:
        overworld: true
        nether: true
        end: true
These settings set the game rule for PvP by dimension, so you could do things like disabling PvP in the end.
### Auto Restock
    autoRestock: false
Auto Restock makes villagers never run out of stock. By default, it is set to false for a more vanilla-like experience. 

### Turtle Tweaks
    turtleTweaks:
        cheaperTurtleMaster: true
        dropScutes: false
        scuteChance: 35
These tweaks were made to make it easier to obtain turtle master potions.

### Speed Overrides
    speed:
        enabled: false #determines if speed overrides will be applied
        happyGhast: 0.1025
Many SMP players find happy ghasts to be too slow to be effective. This allows overriding happy ghast speed, and may allow changing other speeds in the future.

### Elytra Movement Check
    disableElytraMovementCheck: true
This is helpful for servers that reset, because game rules get reset with the world. This setting helps prevent laggy elytra movement, although it disables an anti-cheat feature. This is only recommended for small SMPs. 