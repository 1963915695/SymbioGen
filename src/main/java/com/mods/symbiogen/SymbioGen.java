package com.mods.symbiogen;

import com.mods.symbiogen.client.config.SyGConfig;
import com.mods.symbiogen.world.network.SyGmessages;
import com.mods.symbiogen.world.registers.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(SymbioGen.MODID)
public class SymbioGen {
    public static final String MODID = "symbiogen";

    public SymbioGen() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);


        SyGItem.ITEMS.register(modEventBus);
        SyGBlock.BLOCKS.register(modEventBus);
        SyGtables.CREATIVE_MODE_TABS.register(modEventBus);
        SyGIEntity.ENTITYS.register(modEventBus);
        SyGEffect.EFFECTS.register(modEventBus);
        SyGParticleTypes.REGISTRY.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);




        
        SyGmessages.Register();//注册网络数据包组件


        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SyGConfig.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

}
