package com.mods.symbiogen.client.render.model;

import com.mods.symbiogen.SymbioGen;
import com.mods.symbiogen.world.registers.entity.SyGMaster_Cow;
import com.mods.symbiogen.world.registers.entity.SyGMaster_Fox;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SyGMaster_Fox_model extends GeoModel<SyGMaster_Fox> {
    private final ResourceLocation TextUres=new ResourceLocation(SymbioGen.MODID,"textures/entities/syg_fox.png");


    @Override
    public ResourceLocation getAnimationResource(SyGMaster_Fox entity) {
        return new ResourceLocation(SymbioGen.MODID, "animations/syg_fox_model.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(SyGMaster_Fox entity) {
        return new ResourceLocation(SymbioGen.MODID, "geo/syg_fox.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SyGMaster_Fox entity) {
        return TextUres;
    }
}
