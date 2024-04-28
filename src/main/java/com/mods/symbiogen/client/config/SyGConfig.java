package com.mods.symbiogen.client.config;

import com.mods.symbiogen.SymbioGen;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;


@Mod.EventBusSubscriber(modid = SymbioGen.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SyGConfig {
    static List<String> NameList=new ArrayList<>();
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec.ConfigValue<Boolean> splatEnable=BUILDER.define("enable", true);;
    private static final ForgeConfigSpec.IntValue evolution_stage = BUILDER
            .comment("Default value for evolution stage is 0-12.")
            .defineInRange("evolution_stage", 0, 0, 12);
    private static final ForgeConfigSpec.IntValue safety_period = BUILDER
            .comment("Safety period Default is 7.")
            .defineInRange("safety_period", 7, 0, Integer.MAX_VALUE);


    public static int evolution_stage_value;
    public static int safety_period_value;
    public static Boolean SplatEnable;



   public static final ForgeConfigSpec SPEC = BUILDER.build();



    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        evolution_stage_value = evolution_stage.get();
        safety_period_value = safety_period.get();
        SplatEnable=splatEnable.get();

    }
}
