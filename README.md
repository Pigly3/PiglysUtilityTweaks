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