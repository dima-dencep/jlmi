package com.github.dima_dencep.mods.jlmi.mixins;

import com.github.dima_dencep.mods.jlmi.config.JustLetMeInConfig;
import net.minecraftforge.network.NetworkInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = NetworkInstance.class, remap = false)
public class NetworkInstanceMixin {
    @Inject(
            method = {
                    "tryClientVersionOnServer",
                    "tryServerVersionOnClient"
            },
            at = @At(
                    value = "HEAD"
            ),
            cancellable = true
    )
    public void dontSyncForge$tryVersion(String version, CallbackInfoReturnable<Boolean> cir) {
        if (JustLetMeInConfig.DISABLE_CHANNELS_SYNC.get()) {
            cir.setReturnValue(true);
        }
    }
}
