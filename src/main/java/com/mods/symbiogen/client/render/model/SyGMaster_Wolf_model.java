package com.mods.symbiogen.client.render.model;

import com.mods.symbiogen.SymbioGen;
import com.mods.symbiogen.world.registers.entity.SyGMaster_Cow;
import com.mods.symbiogen.world.registers.entity.SyGMaster_Wolf;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SyGMaster_Wolf_model extends GeoModel<SyGMaster_Wolf> {
    private final ResourceLocation TextUres=new ResourceLocation(SymbioGen.MODID,"textures/entities/syg_wolf.png");


    @Override
    public ResourceLocation getAnimationResource(SyGMaster_Wolf entity) {
        return new ResourceLocation(SymbioGen.MODID, "animations/wolf_model.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(SyGMaster_Wolf entity) {
        return new ResourceLocation(SymbioGen.MODID, "geo/syg_wolf.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SyGMaster_Wolf entity) {
        return TextUres;
    }
}
