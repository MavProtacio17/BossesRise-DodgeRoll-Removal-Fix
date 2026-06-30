# BossesRise DodgeRoll Removal Fix

A tiny, standalone **Forge 1.20.1** companion mod that **completely removes the dodge/roll mechanic** added by [Bosses'Rise](https://www.curseforge.com/minecraft/mc-mods/bossesrise) (`block_factorys_bosses`) — for players and modpackers who prefer a roll-free experience.

It does **not** edit, decompile, or redistribute any Bosses'Rise files. All changes are applied at runtime with [Mixin](https://github.com/SpongePowered/Mixin), targeting Bosses'Rise's own classes while both mods are loaded.

## What it removes

| Element | How |
|---|---|
| The **"Dodge Roll" key binding** | Its registration is skipped, so it never appears in the Controls menu and is never polled. |
| The **roll ability** (i-frames + movement) | `RollCap$RollCapHandler#startRoll` is forced to return `false`, the single point every roll must pass through. |
| The **roll-count HUD overlay** | `ClientEvents#renderRollGUI` is cancelled, so it is never drawn. |
| The **`roll_count` attribute on gear** | Stripped from `ItemStack#getAttributeModifiers`, so its tooltip line *and* the now-empty `When in <slot>:` header both disappear, and the attribute is no longer applied. |

### Honest note
Forge freezes its registries at load, so the `roll_count` **attribute object** itself cannot be deleted from the registry by an external mod without crashing Bosses'Rise's own code (which references it). This mod removes it from everything player-facing; the leftover registry entry is inert and invisible. For a *registry-level* removal, the Bosses'Rise author would need to add a config toggle.

## Requirements
- Minecraft **1.20.1**
- **Forge** 47.x
- **Bosses'Rise** (`block_factorys_bosses`) — **required**; this mod does nothing without it.

Install on both client and server (it has client- and server-side mixins).

## Building
Requires JDK 17.

```bash
# Bosses'Rise jar is needed only at compile time so the Mixin processor can
# resolve its classes. Drop it here (it is NOT bundled into the output):
#   libs/block_factorys_bosses-2.1.2-forge-1.20.1.jar
./gradlew build
# output: build/libs/BossesRise-DodgeRoll-Removal-Fix-<version>.jar
```

## Compatibility
Pinned to Bosses'Rise `[2.0,3.0)`. If a future Bosses'Rise renames `startRoll`,
`renderRollGUI`, or `registerKeyMappings`, the affected mixin needs revalidating
and a rebuild.

## Credits
- **Bosses'Rise** by Block Factory — the mod this patch targets. Go support them.
- Mixin by SpongePowered.

## License
MIT — see [LICENSE](LICENSE). Independent, unofficial patch; not affiliated with Block Factory.
