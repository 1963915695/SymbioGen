package com.mods.symbiogen.client.render.model;

import com.mods.symbiogen.SymbioGen;
import com.mods.symbiogen.world.registers.entity.SyGMaster_Cow;
import com.mods.symbiogen.world.registers.entity.SyGMaster_Polar_bear;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SyGMaster_Polar_bear_model extends GeoModel<SyGMaster_Polar_bear> {
    private final ResourceLocation TextUres=new ResourceLocation(SymbioGen.MODID,"textures/entities/syg_polar_bear.png");


    @Override
    public ResourceLocation getAnimationResource(SyGMaster_Polar_bear entity) {
        return new ResourceLocation(SymbioGen.MODID, "animations/polar_bear_model.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(SyGMaster_Polar_bear entity) {
        return new ResourceLocation(SymbioGen.MODID, "geo/syg_polar_bear.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SyGMaster_Polar_bear entity) {
        return TextUres;
    }
}
