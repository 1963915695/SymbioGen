package com.mods.symbiogen.world.event;

import com.mods.symbiogen.SymbioGen;
import com.mods.symbiogen.client.config.SyGConfig;
import com.mods.symbiogen.core.SymMod;
import com.mods.symbiogen.world.capability.SyGCapabilityProvider;
import com.mods.symbiogen.world.capability.data.SyGAttrubes;
import com.mods.symbiogen.world.capability.data.SyGData;
import com.mods.symbiogen.world.network.SyGmessages;
import com.mods.symbiogen.world.network.data.SyGSyncDatas;
import com.mods.symbiogen.world.registers.Particle.DamageParticle;
import com.mods.symbiogen.world.registers.SyGParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

import static com.mods.symbiogen.world.registers.SyGIEntity.*;
@Mod.EventBusSubscriber(modid = SymbioGen.MODID)
public class SyGBus {
        @SubscribeEvent
        public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {//注册玩家的能力比如魔法值
            if (event.getObject() instanceof ServerPlayer) {
                if (!event.getObject().getCapability(SyGCapabilityProvider.PLAYER_ATTRIBUTE).isPresent()) {
                    event.addCapability(new ResourceLocation(SymbioGen.MODID, "profession"), new SyGCapabilityProvider());
                }
            }
        }
        @SubscribeEvent
        public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {//注册能力同上
            event.register(SyGAttrubes.class);

        }

        @SubscribeEvent
        public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
            if (event.side == LogicalSide.SERVER) {
                event.player.getCapability(SyGCapabilityProvider.PLAYER_ATTRIBUTE).ifPresent(Profession -> {
                    if (Profession.getProfession() != null && !Profession.getProfession().isEmpty()){
                        if ( event.player.getRandom().nextFloat() < 0.005f) {
                            SyGmessages.sendToPlayer(new SyGSyncDatas(Profession.getProfession()),(ServerPlayer) event.player);
                            if (SyGData.getIData() == null) {
                                SymMod.log("NetWork Sync data is null !");
                            }
                        }

                    }
                });
            }
        }

        @SubscribeEvent
        public static void endFix(PlayerEvent.Clone event)
        {
            if (!event.isWasDeath() && !event.getEntity().level().isClientSide)//切换维度
            {
                Player oldPlayer = event.getOriginal();
                oldPlayer.reviveCaps();
                event.getEntity().getCapability(SyGCapabilityProvider.PLAYER_ATTRIBUTE).ifPresent(cap ->
                        oldPlayer.getCapability(SyGCapabilityProvider.PLAYER_ATTRIBUTE).ifPresent(cap::copy));

                oldPlayer.invalidateCaps();
            }else if (!event.getEntity().level().isClientSide){//死亡
                Player oldPlayer = event.getOriginal();
                oldPlayer.reviveCaps();

                event.getEntity().getCapability(SyGCapabilityProvider.PLAYER_ATTRIBUTE).ifPresent(cap ->
                        oldPlayer.getCapability(SyGCapabilityProvider.PLAYER_ATTRIBUTE).ifPresent(cap::copy));
                oldPlayer.invalidateCaps();

            }
        }
        @SubscribeEvent
        public static void onSpawnPlacementRegister(SpawnPlacementRegisterEvent event) {
            event.register(Master_Catalog.get(),(pEntityType, pServerLevel, pSpawnType, pPos, pRandom) -> (pServerLevel.getDifficulty() != Difficulty.PEACEFUL && Monster.isDarkEnoughToSpawn(pServerLevel,pPos,pRandom) && Mob.checkMobSpawnRules(pEntityType,pServerLevel,pSpawnType,pPos,pRandom)));
            event.register(Master_Iplayer.get(),(pEntityType, pServerLevel, pSpawnType, pPos, pRandom) -> (pServerLevel.getDifficulty() != Difficulty.PEACEFUL && Monster.isDarkEnoughToSpawn(pServerLevel,pPos,pRandom) && Mob.checkMobSpawnRules(pEntityType,pServerLevel,pSpawnType,pPos,pRandom)));
        }

}



