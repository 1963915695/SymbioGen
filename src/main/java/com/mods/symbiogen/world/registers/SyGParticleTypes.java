package com.mods.symbiogen.world.registers;

import com.mods.symbiogen.SymbioGen;
import com.mods.symbiogen.core.SymMod;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SyGParticleTypes {
    public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, SymbioGen.MODID);
    public static final RegistryObject<SimpleParticleType> Damage = REGISTRY.register(SymMod.ModKey("blood"), () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> Damage1 = REGISTRY.register(SymMod.ModKey("blood_splat"), () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> Damage2 = REGISTRY.register(SymMod.ModKey("blood_splash"), () -> new SimpleParticleType(false));

}
