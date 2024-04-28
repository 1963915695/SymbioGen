package com.mods.symbiogen.client.render.model;

import com.mods.symbiogen.SymbioGen;
import com.mods.symbiogen.world.registers.entity.SyGMaster_Catalog;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SyGMaster_Catalog_model extends GeoModel<SyGMaster_Catalog> {
   private final ResourceLocation TextUres=new ResourceLocation(SymbioGen.MODID,"textures/entities/sygmaster_catalog.png");

    @Override
    public ResourceLocation getAnimationResource(SyGMaster_Catalog entity) {
        return new ResourceLocation(SymbioGen.MODID, "animations/model.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(SyGMaster_Catalog entity) {
        return new ResourceLocation(SymbioGen.MODID, "geo/syg_entity_101.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SyGMaster_Catalog entity) {
        return TextUres;
    }


}
