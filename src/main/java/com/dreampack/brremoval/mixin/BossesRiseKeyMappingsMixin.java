package com.dreampack.brremoval.mixin;

import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Skips registration of the "Dodge Roll" key binding entirely, so it never appears
 * in the Controls menu and is never polled for input. Targets Bosses'Rise's own
 * class by name (remap = false).
 */
@Mixin(targets = "net.unusual.block_factorys_bosses.init.BossesRiseKeyMappings", remap = false)
public class BossesRiseKeyMappingsMixin {

    @Inject(method = "registerKeyMappings", at = @At("HEAD"), cancellable = true, remap = false)
    private static void brremoval$skipDodgeRollKey(RegisterKeyMappingsEvent event, CallbackInfo ci) {
        ci.cancel();
    }
}
