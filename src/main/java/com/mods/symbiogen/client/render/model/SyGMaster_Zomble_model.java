package com.mods.symbiogen.client.render.model;

import com.mods.symbiogen.SymbioGen;
import com.mods.symbiogen.world.registers.entity.SyGMaster_Zomble;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SyGMaster_Zomble_model extends GeoModel<SyGMaster_Zomble> {
    private final ResourceLocation TextUres=new ResourceLocation(SymbioGen.MODID,"textures/entities/syg_zomble.png");


    @Override
    public ResourceLocation getAnimationResource(SyGMaster_Zomble entity) {
        return new ResourceLocation(SymbioGen.MODID, "animations/syg_zomble_model.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(SyGMaster_Zomble entity) {
        return new ResourceLocation(SymbioGen.MODID, "geo/syg_zomble.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SyGMaster_Zomble entity) {
        return TextUres;
    }
}
