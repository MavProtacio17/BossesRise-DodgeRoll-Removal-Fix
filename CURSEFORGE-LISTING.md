# CurseForge listing — copy/paste pack

Everything you need to fill in the CurseForge "Create Project" form, plus the upload settings per file.

---

## Project settings

| Field | Value |
|---|---|
| **Name** | BossesRise DodgeRoll Removal Fix |
| **Summary** (short, shows in search) | Completely removes the dodge/roll mechanic from Bosses'Rise — keybind, ability, HUD, and item attribute. No jar edits. |
| **Primary Category** | Miscellaneous |
| **Secondary (optional)** | Server Utility |
| **Mod Loader** | Forge |
| **Game Version** | 1.20.1 |
| **License** | MIT |
| **Environment** | Client and Server |

## Relations (Dependencies tab — IMPORTANT)
- Add **Bosses'Rise** → relationship: **Required Dependency**.
  (This is what tells the CurseForge app to install Bosses'Rise alongside it.)

---

## Description (paste into the rich-text body)

**BossesRise DodgeRoll Removal Fix** completely removes the dodge/roll mechanic added by **Bosses'Rise** — for players and modpackers who'd rather not have a roll.

It does **not** edit, decompile, or redistribute any Bosses'Rise files. Everything is done cleanly at runtime with Mixin, while both mods are loaded.

**What it removes:**
- 🎮 **The "Dodge Roll" key binding** — never registered, so it's gone from the Controls menu entirely (and never polled for input).
- 🤸 **The roll ability** — it can never trigger: no i-frames, no movement.
- 🖥️ **The roll-count HUD** — never rendered.
- 🛡️ **The "Roll Count" attribute on gear** — its tooltip line *and* the now-empty "When in Off Hand / on Head:" header both disappear, and the attribute is no longer applied.

The result is a clean, roll-free Bosses'Rise.

**Requirements**
- Minecraft 1.20.1 · Forge 47.x
- **Bosses'Rise is required** — this mod does nothing on its own. Install it on both client and server.

**Honest note:** Forge freezes its registries at load, so the leftover internal `roll_count` attribute *object* can't be deleted by an external mod (doing so would crash Bosses'Rise's own code). This mod removes it from everything you can see or use; the orphaned registry entry is inert and invisible. A registry-level removal would need the Bosses'Rise author to add a config option.

**Not affiliated with Block Factory.** Bosses'Rise and its content belong to their authors — please support the original mod. This is an independent, MIT-licensed patch.

---

## Per-file upload settings (when you upload the .jar)

| Field | Value |
|---|---|
| **File** | `BossesRise-DodgeRoll-Removal-Fix-1.0.0.jar` |
| **Display name** | BossesRise DodgeRoll Removal Fix 1.0.0 |
| **Release type** | Release |
| **Game versions** | 1.20.1 |
| **Mod loader** | Forge |
| **Java version** | Java 17 |
| **Dependencies** | Bosses'Rise — Required |

---

## Pre-publish checklist
- [ ] (Optional) Create a GitHub repo; set `issueTrackerURL` in `mods.toml` and rebuild.
- [ ] Make a 400x400 PNG project icon/logo.
- [ ] Confirm in-game once more: no keybind, no roll on the old key, no HUD, no "Roll Count" / orphaned header on gear, and `logs/latest.log` shows the 4 mixins applied with no errors.
- [ ] (Courtesy) Comment on the Bosses'Rise page or open an issue letting the author know this compatibility patch exists.
- [ ] Upload jar with the settings above + the Required dependency relation.
