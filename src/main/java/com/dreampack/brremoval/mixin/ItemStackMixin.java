package com.dreampack.brremoval.mixin;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Removes the meaningless Bosses'Rise "roll_count" attribute modifier from items at
 * the source. Because vanilla only renders the "When in <slot>:" attribute header
 * when that slot actually has modifiers, stripping roll_count also makes the now-empty
 * header (and its blank spacer line) disappear — not just the "+N Roll Count" line.
 * Order-preserving (LinkedHashMultimap) so remaining bonuses keep their order.
 */
@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    private static final ResourceLocation ROLL_COUNT_ID =
        new ResourceLocation("block_factorys_bosses", "roll_count");

    // Resolved lazily once the attribute registry is populated, then cached.
    private static Attribute brremoval$rollCount;

    @Inject(method = "getAttributeModifiers", at = @At("RETURN"), cancellable = true)
    private void brremoval$stripRollCount(EquipmentSlot slot,
                                          CallbackInfoReturnable<Multimap<Attribute, AttributeModifier>> cir) {
        Attribute rollCount = brremoval$rollCount();
        if (rollCount == null) {
            return;
        }
        Multimap<Attribute, AttributeModifier> original = cir.getReturnValue();
        if (original == null || !original.containsKey(rollCount)) {
            return;
        }
        LinkedHashMultimap<Attribute, AttributeModifier> filtered = LinkedHashMultimap.create(original);
        filtered.removeAll(rollCount);
        cir.setReturnValue(filtered);
    }

    private static Attribute brremoval$rollCount() {
        if (brremoval$rollCount == null) {
            brremoval$rollCount = ForgeRegistries.ATTRIBUTES.getValue(ROLL_COUNT_ID);
        }
        return brremoval$rollCount;
    }
}
