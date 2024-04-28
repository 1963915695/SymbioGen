package com.mods.symbiogen.client.render.model;

import com.mods.symbiogen.SymbioGen;
import com.mods.symbiogen.world.registers.entity.SyGMaster_Chiken;
import com.mods.symbiogen.world.registers.entity.SyGMaster_Villager;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SyGMaster_Chiken_model extends GeoModel<SyGMaster_Chiken> {
    private final ResourceLocation TextUres=new ResourceLocation(SymbioGen.MODID,"textures/entities/syg_chicken.png");


    @Override
    public ResourceLocation getAnimationResource(SyGMaster_Chiken entity) {
        return new ResourceLocation(SymbioGen.MODID, "animations/syg_chicken_model.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(SyGMaster_Chiken entity) {
        return new ResourceLocation(SymbioGen.MODID, "geo/syg_chicken.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SyGMaster_Chiken entity) {
        return TextUres;
    }
}
