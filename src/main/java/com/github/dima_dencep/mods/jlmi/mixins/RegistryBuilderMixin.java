package com.github.dima_dencep.mods.jlmi.mixins;

import com.github.dima_dencep.mods.jlmi.config.JustLetMeInConfig;
import net.minecraftforge.registries.RegistryBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = RegistryBuilder.class, remap = false)
public class RegistryBuilderMixin {
    @Shadow
    private boolean saveToDisc;
    @Shadow
    private boolean sync;

    @Inject(
            method = "<init>",
            at = @At(
                    value = "TAIL"
            )
    )
    public void dontSyncForge$init(CallbackInfo ci) {
        if (JustLetMeInConfig.DISABLE_SAVE.get()) {
            this.saveToDisc = false;
        }

        if (JustLetMeInConfig.DISABLE_SYNC.get()) {
            this.sync = false;
        }
    }
}
