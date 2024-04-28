package com.mods.symbiogen.client.render.hud;

import com.mods.symbiogen.SymbioGen;
import com.mods.symbiogen.core.SymMod;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.BossHealthOverlay;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.BossEvent;

public class SygStage_bar {
    Minecraft minecraft;
    float Ivalue;

    public SygStage_bar(Minecraft Iminecraft) {
        this.minecraft=Iminecraft;
    }

    public void render(GuiGraphics guiGraphics, String path, String path1, double StageValue, double StageValueMax, int x, int y, int w, int h) {
        float Stage = (float) (StageValue / StageValueMax);








    }










}
