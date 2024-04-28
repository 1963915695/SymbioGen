package com.mods.symbiogen.client.render.model;

import com.mods.symbiogen.SymbioGen;
import com.mods.symbiogen.world.registers.entity.SyGMaster_Catalog;
import com.mods.symbiogen.world.registers.entity.SyGMaster_Villager;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SyGMaster_villager_model extends GeoModel<SyGMaster_Villager> {
    private final ResourceLocation TextUres=new ResourceLocation(SymbioGen.MODID,"textures/entities/syg_villager.png");


    @Override
    public ResourceLocation getAnimationResource(SyGMaster_Villager entity) {
        return new ResourceLocation(SymbioGen.MODID, "animations/syg_villager_model.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(SyGMaster_Villager entity) {
        return new ResourceLocation(SymbioGen.MODID, "geo/syg_villager.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SyGMaster_Villager entity) {
        return TextUres;
    }
}
