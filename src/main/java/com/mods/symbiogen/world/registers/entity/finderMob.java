package com.mods.symbiogen.world.registers.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class finderMob extends Monster {
    protected static final float DEFAULT_WALK_TARGET_VALUE = 0.0F;

    protected finderMob(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
}
