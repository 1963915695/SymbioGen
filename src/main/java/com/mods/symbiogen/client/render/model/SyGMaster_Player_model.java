package com.mods.symbiogen.client.render.model;

import com.mods.symbiogen.SymbioGen;
import com.mods.symbiogen.world.registers.entity.SyGMaster_Player;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SyGMaster_Player_model extends GeoModel<SyGMaster_Player> {
    private final ResourceLocation TextUres=new ResourceLocation(SymbioGen.MODID,"textures/entities/syg_player.png");


    @Override
    public ResourceLocation getAnimationResource(SyGMaster_Player entity) {
        return new ResourceLocation(SymbioGen.MODID, "animations/syg_player_model.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(SyGMaster_Player entity) {
        return new ResourceLocation(SymbioGen.MODID, "geo/syg_player.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SyGMaster_Player entity) {
        return TextUres;
    }
}
