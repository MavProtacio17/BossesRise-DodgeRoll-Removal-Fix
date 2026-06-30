package com.dreampack.brremoval.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Cancels the roll-count HUD overlay so no roll GUI is ever drawn. Targets
 * Bosses'Rise's own class by name (remap = false).
 */
@Mixin(targets = "net.unusual.block_factorys_bosses.event.ClientEvents", remap = false)
public class ClientEventsMixin {

    @Inject(method = "renderRollGUI", at = @At("HEAD"), cancellable = true, remap = false)
    private static void brremoval$noRollHud(Minecraft minecraft, GuiGraphics guiGraphics, CallbackInfo ci) {
        ci.cancel();
    }
}
