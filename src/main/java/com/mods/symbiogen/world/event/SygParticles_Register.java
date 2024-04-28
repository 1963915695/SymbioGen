package com.mods.symbiogen.world.event;

import com.mods.symbiogen.world.registers.Particle.DamageParticle;
import com.mods.symbiogen.world.registers.SyGParticleTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SygParticles_Register {
    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(SyGParticleTypes.Damage.get(), DamageParticle::provider);
    }
}
