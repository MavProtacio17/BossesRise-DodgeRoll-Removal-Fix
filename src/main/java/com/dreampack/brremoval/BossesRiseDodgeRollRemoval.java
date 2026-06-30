package com.dreampack.brremoval;

import net.minecraftforge.fml.common.Mod;

/**
 * BossesRise DodgeRoll Removal Fix.
 *
 * A standalone companion mod that fully removes the dodge/roll mechanic added by
 * Bosses'Rise (block_factorys_bosses) for players who prefer no roll. It does NOT
 * edit or redistribute any Bosses'Rise files — all behavior lives in client/server
 * mixins that target Bosses'Rise's own classes:
 *   - skips the "Dodge Roll" key binding registration (gone from Controls)
 *   - forces the roll action to never start (no i-frames / movement)
 *   - cancels the roll-count HUD overlay
 *   - strips the "+N Roll Count" line from item tooltips
 *
 * Requires Bosses'Rise to be installed.
 */
@Mod(BossesRiseDodgeRollRemoval.MODID)
public class BossesRiseDodgeRollRemoval {
    public static final String MODID = "bossesrise_dodgeroll_removal";

    public BossesRiseDodgeRollRemoval() {
        // No registration needed; all behavior lives in the mixins.
    }
}
