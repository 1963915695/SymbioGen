package com.mods.symbiogen.client.render.entity;

import com.mods.symbiogen.client.render.model.SyGMaster_Catalog_model;
import com.mods.symbiogen.client.render.model.SyGMaster_villager_model;
import com.mods.symbiogen.world.registers.entity.SyGMaster_Catalog;
import com.mods.symbiogen.world.registers.entity.SyGMaster_Sheep;
import com.mods.symbiogen.world.registers.entity.SyGMaster_Villager;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SyGMaster_villager_render extends GeoEntityRenderer<SyGMaster_Villager> {
    public SyGMaster_villager_render(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SyGMaster_villager_model());
        this.shadowRadius = 0.5f;
    }

    @Override
    public RenderType getRenderType(SyGMaster_Villager animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }

    @Override
    public void preRender(PoseStack poseStack, SyGMaster_Villager entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
                          float blue, float alpha) {
        float scale = 1f;
        this.scaleHeight = scale;
        this.scaleWidth = scale;
        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }
    @Override
    protected float getDeathMaxRotation(SyGMaster_Villager entityLivingBaseIn) {
        return 0.0F;
    }

}
