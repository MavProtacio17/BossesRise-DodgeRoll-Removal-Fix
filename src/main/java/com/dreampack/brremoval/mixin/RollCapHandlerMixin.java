package com.dreampack.brremoval.mixin;

import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * The authoritative cut: the roll never starts. By forcing startRoll(...) to return
 * false at HEAD, no i-frames, no movement, no animation is ever triggered, regardless
 * of how a roll was requested. Targets Bosses'Rise's own class by name (remap = false).
 */
@Mixin(targets = "net.unusual.block_factorys_bosses.capability.entity.RollCap$RollCapHandler", remap = false)
public class RollCapHandlerMixin {

    @Inject(method = "startRoll", at = @At("HEAD"), cancellable = true, remap = false)
    private void brremoval$neverRoll(Player player, float leftImpulse, float forwardImpulse,
                                     CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}
