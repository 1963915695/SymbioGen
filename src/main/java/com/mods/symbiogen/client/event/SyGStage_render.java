package com.mods.symbiogen.client.event;

import com.mods.symbiogen.client.render.hud.SygStage_bar;
import com.mods.symbiogen.world.capability.data.SyGData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SyGStage_render {
    public static final IGuiOverlay OVERLAY = SyGStage_render::render;
    private static boolean complete = true;
    private static void render(ForgeGui forgeGui, GuiGraphics guiGraphics, float v, int i, int i1) {
        Minecraft minecraft = Minecraft.getInstance();
        SygStage_bar Bar = new SygStage_bar(minecraft);
        if (complete && !minecraft.options.renderDebug) {
           if (SyGData.getIData()!=null && !SyGData.getIData().isEmpty()){
               Bar.render(
                       guiGraphics,
                       "textures/gui/hud_1.png"
                       ,"textures/gui/hud_2.png"
                       ,SyGData.getIData().get("evolution_stage_value").getValue()
                       ,SyGData.getIData().get("evolution_stage_value").getMax()
                       ,minecraft.getWindow().getGuiScaledHeight()/2
                       ,minecraft.getWindow().getGuiScaledHeight()/2
                       ,144
                       ,16
               );
           }
        }
    }
    @SubscribeEvent
    public static void onRegisterGuiOverlays(RegisterGuiOverlaysEvent event) {
        event.registerAbove(VanillaGuiOverlay.TITLE_TEXT.id(), "overlay", OVERLAY);
    }

    @SubscribeEvent
    public static void onLoadComplete(FMLLoadCompleteEvent event) {
        complete = true;
    }


}
