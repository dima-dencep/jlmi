package com.github.dima_dencep.mods.jlmi;

import com.github.dima_dencep.mods.jlmi.config.JustLetMeInConfig;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(JustLetMeInMod.MOD_ID)
public class JustLetMeInMod {
    public static final String MOD_ID = "jlmi";
    public static final Logger LOGGER = LogManager.getLogger("Just Let Me In");

    public JustLetMeInMod() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, JustLetMeInConfig.SPEC, JustLetMeInMod.MOD_ID + ".toml");
    }
}
