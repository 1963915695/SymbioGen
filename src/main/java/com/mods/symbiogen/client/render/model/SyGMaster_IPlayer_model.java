package com.mods.symbiogen.client.render.model;

import com.mods.symbiogen.SymbioGen;
import com.mods.symbiogen.world.registers.entity.SyGMaster_IPlayer;
import com.mods.symbiogen.world.registers.entity.SyGMaster_Player;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SyGMaster_IPlayer_model extends GeoModel<SyGMaster_IPlayer> {
    private final ResourceLocation TextUres=new ResourceLocation(SymbioGen.MODID,"textures/entities/syg_iplayer_slim.png");


    @Override
    public ResourceLocation getAnimationResource(SyGMaster_IPlayer entity) {
        return new ResourceLocation(SymbioGen.MODID, "animations/syg_iplayer_model.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(SyGMaster_IPlayer entity) {
        return new ResourceLocation(SymbioGen.MODID, "geo/syg_iplayer_slim.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SyGMaster_IPlayer entity) {
        return TextUres;
    }
}
