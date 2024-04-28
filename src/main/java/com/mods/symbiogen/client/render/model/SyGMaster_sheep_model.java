package com.mods.symbiogen.client.render.model;

import com.mods.symbiogen.SymbioGen;
import com.mods.symbiogen.world.registers.entity.SyGMaster_Sheep;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SyGMaster_sheep_model extends GeoModel<SyGMaster_Sheep> {
    private final ResourceLocation TextUres=new ResourceLocation(SymbioGen.MODID,"textures/entities/syg_sheep.png");


    @Override
    public ResourceLocation getAnimationResource(SyGMaster_Sheep entity) {
        return new ResourceLocation(SymbioGen.MODID, "animations/syg_sheep_model.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(SyGMaster_Sheep entity) {
        return new ResourceLocation(SymbioGen.MODID, "geo/syg_sheep.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SyGMaster_Sheep entity) {
        return TextUres;
    }
}
