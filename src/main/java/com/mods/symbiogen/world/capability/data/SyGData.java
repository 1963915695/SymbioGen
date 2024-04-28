package com.mods.symbiogen.world.capability.data;

import java.util.Map;

public class SyGData {
    private static Map<String, SyGAttrubes> IData;


    public static void set(Map<String, SyGAttrubes> Data) {
        SyGData.IData = Data;
    }

    public static Map<String, SyGAttrubes> getIData() {
        return IData;
    }
}
