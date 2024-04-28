package com.mods.symbiogen.client.render.model;

import com.mods.symbiogen.SymbioGen;
import com.mods.symbiogen.world.registers.entity.SyGMaster_Cow;
import com.mods.symbiogen.world.registers.entity.SyGMaster_Spider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SyGMaster_Spider_model extends GeoModel<SyGMaster_Spider> {
    private final ResourceLocation TextUres=new ResourceLocation(SymbioGen.MODID,"textures/entities/syg_spider.png");


    @Override
    public ResourceLocation getAnimationResource(SyGMaster_Spider entity) {
        return new ResourceLocation(SymbioGen.MODID, "animations/spider_model.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(SyGMaster_Spider entity) {
        return new ResourceLocation(SymbioGen.MODID, "geo/syg_spider_syg.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SyGMaster_Spider entity) {
        return TextUres;
    }
}
