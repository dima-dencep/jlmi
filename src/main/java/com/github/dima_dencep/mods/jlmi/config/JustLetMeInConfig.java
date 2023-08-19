package com.github.dima_dencep.mods.jlmi.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.github.dima_dencep.mods.jlmi.JustLetMeInMod;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.loading.FMLPaths;

// @Mod.EventBusSubscriber(modid = JustLetMeInMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class JustLetMeInConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.BooleanValue DISABLE_SYNC = BUILDER
            .define("disableSync", true);

    public static final ForgeConfigSpec.BooleanValue DISABLE_SAVE = BUILDER
            .define("disableSave", true);

    public static final ForgeConfigSpec.BooleanValue DISABLE_CHANNELS_SYNC = BUILDER
            .define("disableChannelSync", true);

    public static final ForgeConfigSpec SPEC = BUILDER.build();

    static {
        if (!SPEC.isLoaded()) { // Early load for mixins
            try (CommentedFileConfig config = CommentedFileConfig.builder(FMLPaths.CONFIGDIR.get().resolve(JustLetMeInMod.MOD_ID + ".toml")).build()) {
                config.load();

                SPEC.setConfig(config);
            } catch (Throwable th) {
                JustLetMeInMod.LOGGER.error("Failed to read the config:", th);
            }
        }
    }
}
