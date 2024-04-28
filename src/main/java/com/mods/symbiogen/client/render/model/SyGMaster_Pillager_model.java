package com.mods.symbiogen.client.render.model;

import com.mods.symbiogen.SymbioGen;
import com.mods.symbiogen.world.registers.entity.SyGMaster_Pillager;
import com.mods.symbiogen.world.registers.entity.SyGMaster_Villager;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SyGMaster_Pillager_model extends GeoModel<SyGMaster_Pillager> {
    private final ResourceLocation TextUres=new ResourceLocation(SymbioGen.MODID,"textures/entities/syg_pillager.png");


    @Override
    public ResourceLocation getAnimationResource(SyGMaster_Pillager entity) {
        return new ResourceLocation(SymbioGen.MODID, "animations/syg_pillager_model.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(SyGMaster_Pillager entity) {
        return new ResourceLocation(SymbioGen.MODID, "geo/syg_pillager.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SyGMaster_Pillager entity) {
        return TextUres;
    }
}
