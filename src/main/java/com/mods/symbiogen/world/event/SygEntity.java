package com.mods.symbiogen.world.event;

import com.mods.symbiogen.client.render.entity.*;
import com.mods.symbiogen.core.SyGMobType;
import com.mods.symbiogen.world.capability.SyGCapabilityProvider;
import com.mods.symbiogen.world.capability.data.SyGCapaAttribute;
import com.mods.symbiogen.world.network.*;
import com.mods.symbiogen.world.network.data.SyGSendSync;
import com.mods.symbiogen.world.registers.SyGEffect;
import com.mods.symbiogen.world.registers.SyGIEntity;
import com.mods.symbiogen.world.registers.SyGParticleTypes;
import com.mods.symbiogen.world.registers.entity.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SygEntity {
    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        Minecraft minecraft = Minecraft.getInstance();
        if (event.getSource().getEntity() != null && event.getEntity() != null && minecraft.player!=null) {
            ServerPlayer IServerPlayer = (ServerPlayer) event.getEntity().getServer().overworld().getPlayerByUUID(minecraft.player.getUUID());
            if (IServerPlayer != null) {
                IServerPlayer.getCapability(SyGCapabilityProvider.PLAYER_ATTRIBUTE).ifPresent(thirst -> {
                    if (thirst.getProfession() != null && !thirst.getProfession().isEmpty()) {
                        Level Level = event.getSource().getEntity().level();
                        LivingEntity SourceEntity = (LivingEntity) event.getSource().getEntity();
                        if (Level instanceof ServerLevel) {
                            if (SourceEntity.getMobType() == SyGMobType.SYMBIO && event.getEntity() instanceof Villager) {
                                create1(event.getEntity(),((ServerLevel) Level),thirst,SyGIEntity.Master_Villager.get());
                            } else if (SourceEntity.getMobType() == SyGMobType.SYMBIO && event.getEntity() instanceof Pig) {
                                create1(event.getEntity(),((ServerLevel) Level),thirst,SyGIEntity.Master_PIG.get());
                            } else if (SourceEntity.getMobType() == SyGMobType.SYMBIO && event.getEntity() instanceof Player){
                                create1(event.getEntity(),((ServerLevel) Level),thirst,SyGIEntity.Master_Player.get());
                            }else if (SourceEntity.getMobType() == SyGMobType.SYMBIO && event.getEntity() instanceof Sheep){
                                create1(event.getEntity(),((ServerLevel) Level),thirst,SyGIEntity.Master_Sheep.get());
                            }else if (SourceEntity.getMobType() == SyGMobType.SYMBIO && event.getEntity() instanceof Cow){
                                create1(event.getEntity(),((ServerLevel) Level),thirst,SyGIEntity.Master_Cow.get());
                            }else if (SourceEntity.getMobType() == SyGMobType.SYMBIO && event.getEntity() instanceof Zombie){
                                create1(event.getEntity(),((ServerLevel) Level),thirst,SyGIEntity.Master_Zomble.get());
                            }else if (SourceEntity.getMobType() == SyGMobType.SYMBIO && event.getEntity() instanceof Wolf){
                                create1(event.getEntity(),((ServerLevel) Level),thirst,SyGIEntity.Master_Wolf.get());
                            }else if (SourceEntity.getMobType() == SyGMobType.SYMBIO && event.getEntity() instanceof SyGMaster_IPlayer){
                                create1(event.getEntity(),((ServerLevel) Level),thirst,SyGIEntity.Master_Player.get());
                            }else if (SourceEntity.getMobType() == SyGMobType.SYMBIO && event.getEntity() instanceof Chicken){
                                create1(event.getEntity(),((ServerLevel) Level),thirst,SyGIEntity.Master_Chiken.get());
                            }else if (SourceEntity.getMobType() == SyGMobType.SYMBIO && event.getEntity().getClass() == Pillager.class){
                                create1(event.getEntity(),((ServerLevel) Level),thirst,SyGIEntity.Master_Pillager.get());
                            }else if (SourceEntity.getMobType() == SyGMobType.SYMBIO && event.getEntity().getClass() == PolarBear.class){
                                create1(event.getEntity(),((ServerLevel) Level),thirst,SyGIEntity.Master_Polar_bear.get());
                            }else if (SourceEntity.getMobType() == SyGMobType.SYMBIO && event.getEntity().getClass() == Fox.class){
                                create1(event.getEntity(),((ServerLevel) Level),thirst,SyGIEntity.Master_Fox.get());
                            }else if (SourceEntity.getMobType() == SyGMobType.SYMBIO && event.getEntity().getClass() == Spider.class){
                                create1(event.getEntity(),((ServerLevel) Level),thirst,SyGIEntity.Master_Spider.get());
                            }


                        }
                    }
                });
            }


        }
    }

    public static void create1(net.minecraft.world.entity.Entity Source, ServerLevel level, SyGCapaAttribute data, EntityType<?> IEntity){
        IEntity.spawn(level, new BlockPos(Source.getBlockX(), Source.getBlockY(), Source.getBlockZ()), MobSpawnType.SPAWN_EGG);
        data.getProfession().get("evolution_stage_value").setValue(data.getProfession().get("evolution_stage_value").getValue() + 0.5);
        if (Source instanceof Player){
        }else {
            Source.remove(net.minecraft.world.entity.Entity.RemovalReason.DISCARDED);
        }
        SyGmessages.sendToServer(new SyGSendSync());
        level.sendParticles(ParticleTypes.EXPLOSION,Source.getBlockX(),Source.getBlockY()+1,Source.getBlockZ(),1,0,0,0,1.5f);
    }


    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        if (event.getEntity().getServer()!=null){
           if ( event.getSource().getEntity() instanceof Player){
               Random random=new Random();
               event.getEntity().getServer().overworld().sendParticles(SyGParticleTypes.Damage.get(), event.getEntity().getBlockX(), event.getEntity().getBlockY() + 1, event.getEntity().getBlockZ(),random.nextInt(7,15) , 0.1D, 0, 0.1D, 1.5f);
           }
          }

    }


    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.getEntity().level() instanceof ClientLevel) {
            event.getEntity().getCapability(SyGCapabilityProvider.PLAYER_ATTRIBUTE).ifPresent(thirst -> {
                if (thirst.getProfession() != null && !thirst.getProfession().isEmpty()) {
                   if (thirst.getProfession().size()==1){
                       SyGmessages.sendToServer(new SyGSendSync());
                   }
                }
            });
        }
    }




    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        Minecraft minecraft = Minecraft.getInstance();
        MinecraftServer IServer = event.getEntity().getServer();
        if (event.getEntity().getEffect(SyGEffect.EXPALE_.get()) != null && IServer!=null && minecraft.player!=null) {
            ServerPlayer OServerPlayer = (ServerPlayer) event.getEntity().getServer().overworld().getPlayerByUUID(minecraft.player.getUUID());
            if (OServerPlayer != null) {
                ServerLevel IServerLevel = event.getEntity().getServer().overworld();
                OServerPlayer.getCapability(SyGCapabilityProvider.PLAYER_ATTRIBUTE).ifPresent(thirst -> {
                    if (thirst.getProfession() != null && !thirst.getProfession().isEmpty()) {
                        int ITime = event.getEntity().getEffect(SyGEffect.EXPALE_.get()).getDuration() / 20;
                        if (ITime <= 0 && event.getEntity() instanceof Villager) {
                            create1(event.getEntity(),IServerLevel,thirst,SyGIEntity.Master_Villager.get());
                        } else if (ITime <= 0 && event.getEntity() instanceof Pig) {
                            create1(event.getEntity(),IServerLevel,thirst,SyGIEntity.Master_PIG.get());
                        } else if (ITime <= 0 && event.getEntity() instanceof Sheep) {
                            create1(event.getEntity(),IServerLevel,thirst,SyGIEntity.Master_Sheep.get());
                        }else if (ITime <= 0 && event.getEntity() instanceof Cow) {
                            create1(event.getEntity(),IServerLevel,thirst,SyGIEntity.Master_Cow.get());
                        }else if (ITime <= 0 && event.getEntity() instanceof Zombie) {
                            create1(event.getEntity(),IServerLevel,thirst,SyGIEntity.Master_Zomble.get());
                        }else if (ITime <= 0 && event.getEntity() instanceof Wolf) {
                            create1(event.getEntity(),IServerLevel,thirst,SyGIEntity.Master_Wolf.get());
                        }else if (ITime <= 0 && event.getEntity() instanceof Chicken) {
                            create1(event.getEntity(),IServerLevel,thirst,SyGIEntity.Master_Chiken.get());
                        }else if (ITime <= 0 && event.getEntity() instanceof Pillager) {
                            create1(event.getEntity(),IServerLevel,thirst,SyGIEntity.Master_Pillager.get());
                        }else if (ITime <= 0 && event.getEntity() instanceof PolarBear) {
                            create1(event.getEntity(),IServerLevel,thirst,SyGIEntity.Master_Polar_bear.get());
                        }else if (ITime <= 0 && event.getEntity() instanceof Fox) {
                            create1(event.getEntity(),IServerLevel,thirst,SyGIEntity.Master_Fox.get());
                        }else if (ITime <= 0 && event.getEntity() instanceof Spider) {
                            create1(event.getEntity(),IServerLevel,thirst,SyGIEntity.Master_Spider.get());
                        }else if (ITime <= 0 && event.getEntity() instanceof SyGMaster_IPlayer) {
                            create1(event.getEntity(),IServerLevel,thirst,SyGIEntity.Master_Player.get());
                        }
                    }
                });
            }


        }


    }

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    static class MobBus {
        @SubscribeEvent
        public static void registerAttributes(EntityAttributeCreationEvent event) {
            event.put(SyGIEntity.Master_Catalog.get(), SyGMaster_Catalog.createAttributes().build());
            event.put(SyGIEntity.Master_Villager.get(), SyGMaster_Villager.createAttributes().build());
            event.put(SyGIEntity.Master_PIG.get(), SyGMaster_Pig.createAttributes().build());
            event.put(SyGIEntity.Master_Player.get(), SyGMaster_Player.createAttributes().build());
            event.put(SyGIEntity.Master_Sheep.get(), SyGMaster_Sheep.createAttributes().build());
            event.put(SyGIEntity.Master_Cow.get(), SyGMaster_Cow.createAttributes().build());
            event.put(SyGIEntity.Master_Zomble.get(), SyGMaster_Zomble.createAttributes().build());
            event.put(SyGIEntity.Master_Wolf.get(), SyGMaster_Wolf.createAttributes().build());
            event.put(SyGIEntity.Master_Iplayer.get(), SyGMaster_IPlayer.createAttributes().build());
            event.put(SyGIEntity.Master_Chiken.get(), SyGMaster_Chiken.createAttributes().build());
            event.put(SyGIEntity.Master_Pillager.get(), SyGMaster_Pillager.createAttributes().build());
            event.put(SyGIEntity.Master_Polar_bear.get(), SyGMaster_Polar_bear.createAttributes().build());
            event.put(SyGIEntity.Master_Fox.get(), SyGMaster_Fox.createAttributes().build());
            event.put(SyGIEntity.Master_Spider.get(), SyGMaster_Spider.createAttributes().build());


        }

        @SubscribeEvent
        public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(SyGIEntity.Master_Catalog.get(), SyGMaster_Catalog_Render::new);
            event.registerEntityRenderer(SyGIEntity.Master_Villager.get(), SyGMaster_villager_render::new);
            event.registerEntityRenderer(SyGIEntity.Master_PIG.get(), SyGMaster_Pig_Render::new);
            event.registerEntityRenderer(SyGIEntity.Master_Player.get(), SyGMaster_Player_Render::new);
            event.registerEntityRenderer(SyGIEntity.Master_Sheep.get(), SyGMaster_sheep_Render::new);
            event.registerEntityRenderer(SyGIEntity.Master_Cow.get(), SyGMaster_Cow_Render::new);
            event.registerEntityRenderer(SyGIEntity.Master_Zomble.get(), SyGMaster_Zomble_Render::new);
            event.registerEntityRenderer(SyGIEntity.Master_Wolf.get(), SyGMaster_Wolf_Render::new);
            event.registerEntityRenderer(SyGIEntity.Master_Chiken.get(), SyGMaster_Chiken_render::new);
            event.registerEntityRenderer(SyGIEntity.Master_Pillager.get(), SyGMaster_Pillager_render::new);
            event.registerEntityRenderer(SyGIEntity.Master_Iplayer.get(), SyGMaster_IPlayer_Render::new);
            event.registerEntityRenderer(SyGIEntity.Master_Polar_bear.get(), SyGMaster_Polar_bear_Render::new);
            event.registerEntityRenderer(SyGIEntity.Master_Fox.get(), SyGMaster_Fox_Render::new);
            event.registerEntityRenderer(SyGIEntity.Master_Spider.get(), SyGMaster_Spider_Render::new);




        }



}

@Mod.EventBusSubscriber
class EntityBus {
    @SubscribeEvent
    public static void onEntityTick(LivingEvent.LivingTickEvent event) {
        if (event != null && event.getEntity() != null) {
            if (event.getEntity() instanceof SyGMaster_Villager syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }
            if (event.getEntity() instanceof SyGMaster_Player syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }
            if (event.getEntity() instanceof SyGMaster_Pig syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }
            if (event.getEntity() instanceof SyGMaster_Zomble syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }
            if (event.getEntity() instanceof SyGMaster_Cow syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }
            if (event.getEntity() instanceof SyGMaster_Sheep syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }
            if (event.getEntity() instanceof SyGMaster_Wolf syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }
            if (event.getEntity() instanceof SyGMaster_IPlayer syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }
            if (event.getEntity() instanceof SyGMaster_Chiken syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }
            if (event.getEntity() instanceof SyGMaster_Pillager syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }
            if (event.getEntity() instanceof SyGMaster_Polar_bear syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }
            if (event.getEntity() instanceof SyGMaster_Fox syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }
            if (event.getEntity() instanceof SyGMaster_Spider syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }
        }
    }


}
}