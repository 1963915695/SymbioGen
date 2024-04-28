package com.mods.symbiogen.core;

import com.mods.symbiogen.SymbioGen;
import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

public class SymMod {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static void log(String log){
        LOGGER.info(log);
    }


    public static String ModKey(String key){
        return SymbioGen.MODID+"_" +key.toLowerCase().replace(" ","_");
    }







}
