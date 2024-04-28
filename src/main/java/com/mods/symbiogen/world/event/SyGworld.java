package com.mods.symbiogen.world.event;

import com.mods.symbiogen.core.SymMod;
import com.mods.symbiogen.world.capability.data.SyGData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SyGworld {
    @SubscribeEvent
    public static void onTickLevelTick(TickEvent.LevelTickEvent event) {//世界tick
        Minecraft minecraft=Minecraft.getInstance();
        if (minecraft.player != null) {
            Player IPlayer = event.level.getPlayerByUUID(
                    minecraft.player.getUUID()
            );
            if (IPlayer != null) {
                 if (event.level.getServer() != null) {
                     BlockPos Pos=new BlockPos(IPlayer.getBlockX(),IPlayer.getBlockY(),IPlayer.getBlockZ());
                     //event.level.getEntitiesOfClass(LivingEntity.class,new AABB(new BlockPos(10,10,-10)));
                     int Darken = event.level.getSkyDarken();
                     long worldTime = event.level.getDayTime();
                     int day = (int) (worldTime / 24000L);
                     long timeOfDay = worldTime % 24000L;
                     int hour = (int) ((timeOfDay + 6000L) / 1000L) % 24;
                     int minute = (int) ((timeOfDay % 1000L) / 16.666D);




                    // SymMod.log("时间:"+day+"|"+hour+"|"+minute+"|月亮光照亮度:"+Darken);
                }
            }





            if (event.side.isClient() && minecraft.player != null && event.level instanceof ClientLevel) {
                long worldTime = event.level.getDayTime();
                int day = (int) (worldTime / 24000L);
                MinecraftServer IServer = event.level.getServer();

            }





        }
    }
}
