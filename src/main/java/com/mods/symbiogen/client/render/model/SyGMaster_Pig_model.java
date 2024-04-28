package com.mods.symbiogen.client.render.model;

import com.mods.symbiogen.SymbioGen;
import com.mods.symbiogen.world.registers.entity.SyGMaster_Pig;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SyGMaster_Pig_model extends GeoModel<SyGMaster_Pig> {
    private final ResourceLocation TextUres=new ResourceLocation(SymbioGen.MODID,"textures/entities/syg_pig.png");


    @Override
    public ResourceLocation getAnimationResource(SyGMaster_Pig entity) {
        return new ResourceLocation(SymbioGen.MODID, "animations/syg_pig.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(SyGMaster_Pig entity) {
        return new ResourceLocation(SymbioGen.MODID, "geo/syg_pig_model.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SyGMaster_Pig entity) {
        return TextUres;
    }
}
