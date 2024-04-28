package com.mods.symbiogen.client.render.model;

import com.mods.symbiogen.SymbioGen;
import com.mods.symbiogen.world.registers.entity.SyGMaster_Cow;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SyGMaster_Cow_model extends GeoModel<SyGMaster_Cow> {
    private final ResourceLocation TextUres=new ResourceLocation(SymbioGen.MODID,"textures/entities/syg_cow.png");


    @Override
    public ResourceLocation getAnimationResource(SyGMaster_Cow entity) {
        return new ResourceLocation(SymbioGen.MODID, "animations/syg_cow_model.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(SyGMaster_Cow entity) {
        return new ResourceLocation(SymbioGen.MODID, "geo/syg_cow.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SyGMaster_Cow entity) {
        return TextUres;
    }
}
