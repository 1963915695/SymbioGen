package com.mods.symbiogen.client.event;

import com.mods.symbiogen.SymbioGen;
import com.mods.symbiogen.world.registers.entity.SyGMaster_IPlayer;
import com.mods.symbiogen.world.registers.entity.SyGMaster_Player;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Matrix4f;
import org.joml.Quaternionf;

import java.util.Objects;
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SyGRender_LivingEntityName {
    @SubscribeEvent
    public static void onRenderLiving(RenderLivingEvent event) {
        Minecraft minecraft=Minecraft.getInstance();
        minecraft.execute(()->{
            RenderLivingEntityName(minecraft,event.getRenderer().getFont(),event.getEntity(),event.getEntity().getYRot(), event.getPartialTick(), event.getPoseStack(),event.getMultiBufferSource(), event.getPackedLight());
        });
    }

    private static void RenderLivingEntityName(Minecraft instance, Font font, LivingEntity entity, float yRot, float partialTick, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
         if (entity instanceof Player || entity instanceof SyGMaster_IPlayer || entity instanceof SyGMaster_Player){
             if (instance.player != null) {
                     RenderName(instance.player, yRot, poseStack, multiBufferSource, font, entity.getDisplayName(), entity, "#ffffff", "#000000", packedLight, 0.02f);
             }
         }
    }







    public static void RenderName(LocalPlayer player,float pEntityYaw, PoseStack stack, MultiBufferSource buffer, Font font, Component component, LivingEntity pEntity, String Corlor, String BacckgrundColor, int pPackedLight, float Scale){
        float YRt = player.getYHeadRot();
        float eyepos = (float) -pEntity.getEyePosition().y;
        float size = pEntity.getType().getHeight();
        int textWidth = font.width(component);
        int textHeight = font.lineHeight;
        float offsetX = -textWidth / 2.0f;
        float offsetY = -pEntity.getBbHeight() * Scale - textHeight * Scale;

        stack.pushPose();
        Quaternionf Qua = new Quaternionf(Axis.XP.rotationDegrees(180F));
        Quaternionf Qua1 = new Quaternionf(Axis.YP.rotationDegrees(-YRt));
        Quaternionf Qua2 = new Quaternionf(Axis.YP.rotationDegrees(pEntityYaw));
        stack.mulPose(Qua);
        stack.mulPose(Qua1);
        stack.mulPose(Qua2);

        stack.scale(Scale, Scale, Scale);
        if (size<1){
            stack.translate(0,-eyepos*1,0);
        }else {
            stack.translate(0,-eyepos*size,0);
        }
        font.drawInBatch(component, offsetX, offsetY, Objects.requireNonNull(TextColor.parseColor(Corlor)).getValue(), false, stack.last().pose(), buffer, Font.DisplayMode.NORMAL, Objects.requireNonNull(TextColor.parseColor(BacckgrundColor)).getValue(), pPackedLight);
        stack.popPose();
    }









    static void blit(ResourceLocation pAtlasLocation, PoseStack poseStack, int pX1, int pX2, int pY1, int pY2, int pBlitOffset, int pUWidth, int pVHeight, float pUOffset, float pVOffset, int pTextureWidth, int pTextureHeight) {
        innerBlit(pAtlasLocation,poseStack, pX1, pX2, pY1, pY2, pBlitOffset, (pUOffset + 0.0F) / (float)pTextureWidth, (pUOffset + (float)pUWidth) / (float)pTextureWidth, (pVOffset + 0.0F) / (float)pTextureHeight, (pVOffset + (float)pVHeight) / (float)pTextureHeight);
    }



    static void innerBlit(ResourceLocation pAtlasLocation, PoseStack poseStack, int pX1, int pX2, int pY1, int pY2, int pBlitOffset, float pMinU, float pMaxU, float pMinV, float pMaxV) {
      /*
       pAtlasLocation – 纹理图集的位置。
       pX1 – blit 位置第一个角的 x 坐标。
       pX2 – blit 位置第二个角的 x 坐标。
       pY1 – blit 位置第一个角的 y 坐标。
       pY2 – blit 位置第二个角的 y 坐标。
       pBlitOffset – 渲染顺序的 z 级偏移量。
       pMinU – 最小水平纹理坐标。
       pMaxU – 最大水平纹理坐标。
       pMinV – 最小垂直纹理坐标。
       pMaxV – 最大垂直纹理坐标。
       */
        RenderSystem.setShaderTexture(0, pAtlasLocation);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        Matrix4f matrix4f = poseStack.last().pose();
        BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.vertex(matrix4f, (float)pX1, (float)pY1, (float)pBlitOffset).uv(pMinU, pMinV).endVertex();
        bufferbuilder.vertex(matrix4f, (float)pX1, (float)pY2, (float)pBlitOffset).uv(pMinU, pMaxV).endVertex();
        bufferbuilder.vertex(matrix4f, (float)pX2, (float)pY2, (float)pBlitOffset).uv(pMaxU, pMaxV).endVertex();
        bufferbuilder.vertex(matrix4f, (float)pX2, (float)pY1, (float)pBlitOffset).uv(pMaxU, pMinV).endVertex();
        BufferUploader.drawWithShader(bufferbuilder.end());
    }






}
