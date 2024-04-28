package com.mods.symbiogen.world.registers.goal;

import com.mods.symbiogen.core.SymMod;
import com.mods.symbiogen.world.registers.SyGEffect;
import com.mods.symbiogen.world.registers.entity.SyGMaster_IPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;

public class SyGNearestAttackTargetGoal2<T extends LivingEntity> extends TargetGoal {
    private static final int DEFAULT_RANDOM_INTERVAL = 10;
    protected final Class<T> targetType;
    protected final int randomInterval;
    private List<Class<? extends LivingEntity>> TargetEntity=new ArrayList<>();
    @Nullable
    protected LivingEntity target;
    protected TargetingConditions targetConditions;
    public SyGNearestAttackTargetGoal2(Mob pMob, Class<T> pTargetType, boolean pMustSee) {
        this(pMob, pTargetType, 10, pMustSee, false, (Predicate<LivingEntity>)null);
    }

    public SyGNearestAttackTargetGoal2(Mob pMob, Class<T> pTargetType, boolean pMustSee, Predicate<LivingEntity> pTargetPredicate) {
        this(pMob, pTargetType, 10, pMustSee, false, pTargetPredicate);
    }

    public SyGNearestAttackTargetGoal2(Mob pMob, Class<T> pTargetType, boolean pMustSee, boolean pMustReach) {
        this(pMob, pTargetType, 10, pMustSee, pMustReach, (Predicate<LivingEntity>)null);
    }

    public SyGNearestAttackTargetGoal2(Mob pMob, Class<T> pTargetType, int pRandomInterval, boolean pMustSee, boolean pMustReach, @Nullable Predicate<LivingEntity> pTargetPredicate) {
        super(pMob, pMustSee, pMustReach);
        this.targetType = pTargetType;
        this.randomInterval = reducedTickDelay(pRandomInterval);
        this.setFlags(EnumSet.of(Flag.TARGET));
        this.targetConditions = TargetingConditions.forCombat().range(this.getFollowDistance()).selector(pTargetPredicate);
        addEntity();
    }

  void addEntity(){
      TargetEntity.add(Pig.class);
      TargetEntity.add(Cow.class);
      TargetEntity.add(Zombie.class);
      TargetEntity.add(Villager.class);
      TargetEntity.add(Fox.class);
      TargetEntity.add(IronGolem.class);
      TargetEntity.add(PolarBear.class);
      TargetEntity.add(Sheep.class);
      TargetEntity.add(Wolf.class);
      TargetEntity.add(Pillager.class);
      TargetEntity.add(EnderDragon.class);
      TargetEntity.add(ZombieVillager.class);
      TargetEntity.add(Chicken.class);
      TargetEntity.add(SyGMaster_IPlayer.class);
      TargetEntity.add(Spider.class);
  }


    @Override
    public boolean canUse() {
        if (this.randomInterval > 0 && this.mob.getRandom().nextInt(this.randomInterval) != 0) {
            return false;
        }else {
            this.findTarget();
            return this.target != null;
        }
    }

    protected AABB getTargetSearchArea(double pTargetDistance) {
        return this.mob.getBoundingBox().inflate(pTargetDistance, 4.0D, pTargetDistance);
    }

    protected void findTarget() {
        if (this.targetType != Player.class && this.targetType != ServerPlayer.class) {
            this.target = this.mob.level().getNearestEntity(this.mob.level().getEntitiesOfClass(this.targetType, this.getTargetSearchArea(this.getFollowDistance()), (Entity) -> {
              if (TargetEntity.contains(Entity.getClass())){
                  return true;
              }else {
                  return false;
              }
            }), this.targetConditions, this.mob, this.mob.getX(), this.mob.getEyeY(), this.mob.getZ());
        } else {
            this.target = this.mob.level().getNearestPlayer(this.targetConditions, this.mob, this.mob.getX(), this.mob.getEyeY(), this.mob.getZ());
        }
    }




    @Override
    public void start() {
        this.mob.setTarget(this.target);
        super.start();
    }



    public void setTarget(@Nullable LivingEntity pTarget) {
        this.target = pTarget;
    }


}
