package com.mods.symbiogen.world.registers.Particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

public class DamageParticle extends TextureSheetParticle {
    public static SsprParticleProvider provider(SpriteSet spriteSet) {
        return new SsprParticleProvider(spriteSet);
    }

    public static class SsprParticleProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public SsprParticleProvider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new DamageParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
        }
    }

    private final SpriteSet spriteSet;
    private float angularVelocity;
    private float angularAcceleration;

    protected DamageParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
        super(world, x, y, z);
        this.spriteSet = spriteSet;
        this.setSize(1.1f, 1.2f);
        this.quadSize *= 0.7f;
        this.lifetime = 7;
        this.gravity = 3f;
        this.hasPhysics = true;
        this.xd = vx * 0.314;
        this.yd = vy * 0.314;
        this.zd = vz * 0.314;
        this.angularVelocity = 0.314f;
        this.angularAcceleration = 0f;
        this.setSpriteFromAge(spriteSet);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public void tick() {
        super.tick();
        this.oRoll = this.roll;
        this.roll += this.angularVelocity;
        this.angularVelocity += this.angularAcceleration;
        if (!this.removed) {
            this.setSprite(this.spriteSet.get((this.age / 20) % 1 + 1, 1));
        }
    }




}
