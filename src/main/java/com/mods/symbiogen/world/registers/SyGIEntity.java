package com.mods.symbiogen.world.registers;

import com.mods.symbiogen.SymbioGen;
import com.mods.symbiogen.core.SymMod;
import com.mods.symbiogen.world.registers.entity.*;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SyGIEntity {
    public static final DeferredRegister<EntityType<?>> ENTITYS=DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SymbioGen.MODID);
    private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
        return ENTITYS.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
    }

    public static final RegistryObject<EntityType<SyGMaster_Catalog>> Master_Catalog=register(SymMod.ModKey("Master_Catalog")
            , EntityType.Builder.<SyGMaster_Catalog>of(SyGMaster_Catalog::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SyGMaster_Catalog::new)
            .sized(0.6f, 1.8f));
    public static final RegistryObject<EntityType<SyGMaster_Villager>> Master_Villager=register(SymMod.ModKey("Master_Villager")
            , EntityType.Builder.<SyGMaster_Villager>of(SyGMaster_Villager::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SyGMaster_Villager::new)
                    .sized(0.6f, 1.8f));
    public static final RegistryObject<EntityType<SyGMaster_Pig>> Master_PIG=register(SymMod.ModKey("Master_PIG")
            , EntityType.Builder.<SyGMaster_Pig>of(SyGMaster_Pig::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SyGMaster_Pig::new)
                    .sized(0.6f, 1.8f));
    public static final RegistryObject<EntityType<SyGMaster_Player>> Master_Player=register(SymMod.ModKey("Master_Player")
            , EntityType.Builder.<SyGMaster_Player>of(SyGMaster_Player::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SyGMaster_Player::new)
                    .sized(0.6f, 1.8f));
    public static final RegistryObject<EntityType<SyGMaster_Sheep>> Master_Sheep=register(SymMod.ModKey("Master_Sheep")
            , EntityType.Builder.<SyGMaster_Sheep>of(SyGMaster_Sheep::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SyGMaster_Sheep::new)
                    .sized(0.6f, 1.8f)
    );
    public static final RegistryObject<EntityType<SyGMaster_Cow>> Master_Cow=register(SymMod.ModKey("Master_Cow")
            , EntityType.Builder.<SyGMaster_Cow>of(SyGMaster_Cow::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SyGMaster_Cow::new)
                    .sized(0.6f, 1.8f));
    public static final RegistryObject<EntityType<SyGMaster_Zomble>> Master_Zomble=register(SymMod.ModKey("Master_Zomble")
            , EntityType.Builder.<SyGMaster_Zomble>of(SyGMaster_Zomble::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SyGMaster_Zomble::new)
                    .sized(0.6f, 1.8f));
    public static final RegistryObject<EntityType<SyGMaster_Wolf>> Master_Wolf=register(SymMod.ModKey("Master_wolf")
            ,EntityType.Builder.<SyGMaster_Wolf>of(SyGMaster_Wolf::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SyGMaster_Wolf::new)
                    .sized(0.6f, 1.8f) );

    public static final RegistryObject<EntityType<SyGMaster_Chiken>> Master_Chiken=register(SymMod.ModKey("Master_Chiken")
            ,EntityType.Builder.<SyGMaster_Chiken>of(SyGMaster_Chiken::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SyGMaster_Chiken::new)
                    .sized(0.6f, 1.8f) );

    public static final RegistryObject<EntityType<SyGMaster_Pillager>> Master_Pillager=register(SymMod.ModKey("Master_Pillager")
            ,EntityType.Builder.<SyGMaster_Pillager>of(SyGMaster_Pillager::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SyGMaster_Pillager::new)
                    .sized(0.6f, 1.8f) );

    public static final RegistryObject<EntityType<SyGMaster_IPlayer>> Master_Iplayer=register(SymMod.ModKey("Master_Iplayer")
            ,EntityType.Builder.<SyGMaster_IPlayer>of(SyGMaster_IPlayer::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SyGMaster_IPlayer::new)
                    .sized(0.6f, 1.8f) );

    public static final RegistryObject<EntityType<SyGMaster_Polar_bear>> Master_Polar_bear=register(SymMod.ModKey("Master_Polar_bear")
            ,EntityType.Builder.<SyGMaster_Polar_bear>of(SyGMaster_Polar_bear::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SyGMaster_Polar_bear::new)
                    .sized(0.6f, 1.8f) );


    public static final RegistryObject<EntityType<SyGMaster_Fox>> Master_Fox=register(SymMod.ModKey("Master_Fox")
            ,EntityType.Builder.<SyGMaster_Fox>of(SyGMaster_Fox::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SyGMaster_Fox::new)
                    .sized(0.6f, 1.8f) );

    public static final RegistryObject<EntityType<SyGMaster_Spider>> Master_Spider=register(SymMod.ModKey("Master_Spider")
            ,EntityType.Builder.<SyGMaster_Spider>of(SyGMaster_Spider::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SyGMaster_Spider::new)
                    .sized(0.6f, 1.8f) );


}
