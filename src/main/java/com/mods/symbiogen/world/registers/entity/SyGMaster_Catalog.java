package com.mods.symbiogen.world.registers.entity;

import com.mods.symbiogen.core.SyGMobType;
import com.mods.symbiogen.core.SymMod;
import com.mods.symbiogen.world.registers.SyGIEntity;
import com.mods.symbiogen.world.registers.SyGItem;
import com.mods.symbiogen.world.registers.goal.SyGMeleeGoal;
import com.mods.symbiogen.world.registers.goal.SyGNearestAttackTargetGoal;
import com.mods.symbiogen.world.registers.goal.SyGNearestAttackTargetGoal2;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Predicate;

public class SyGMaster_Catalog extends finderMob implements GeoEntity {
    public String animationprocedure = "empty";

    public final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (livingEntity) -> {
        return  !(livingEntity.getMobType()==this.getMobType()) && livingEntity.attackable();
    };
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public SyGMaster_Catalog(PlayMessages.SpawnEntity packet, Level world) {
        this(SyGIEntity.Master_Catalog.get(), world);
    }

    public SyGMaster_Catalog(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        setNoAi(false);
    }


    @Override
    protected void registerGoals() {

        super.registerGoals();
        this.goalSelector.addGoal(1, new SyGMeleeGoal(this, 0.5, false,false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
            }
        });
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(5, new FloatGoal(this));
        this.goalSelector.addGoal(6,new SyGNearestAttackTargetGoal2<>(this, LivingEntity.class, false, LIVING_ENTITY_SELECTOR));
    }

    @Override
    public @NotNull MobType getMobType() {
        return SyGMobType.SYMBIO;
    }

    @Override
    public @NotNull Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
    private PlayState movementPredicate(AnimationState event) {
        if (this.animationprocedure.equals("empty")) {
            if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F))

            ) {
                return event.setAndContinue(RawAnimation.begin().thenLoop("animation.model.move"));
            }
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.model.new"));
        }
        return PlayState.STOP;
    }

    @Override
    public EntityDimensions getDimensions(Pose p_33597_) {
        return super.getDimensions(p_33597_).scale((float) 3);
    }



    private PlayState Procedure(AnimationState event) {
        if (!animationprocedure.equals("empty") && event.getController().getAnimationState() == AnimationController.State.STOPPED) {
            event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
            if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
                this.animationprocedure = "empty";
                event.getController().forceAnimationReset();
            }
        } else if (animationprocedure.equals("empty")) {
            return PlayState.STOP;
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "movement", 4, this::movementPredicate));
        controllerRegistrar.add(new AnimationController<>(this, "procedure", 4, this::Procedure));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }


    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.4);
        builder = builder.add(Attributes.MAX_HEALTH, 10);
        builder = builder.add(Attributes.ARMOR, 0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 0.0);
        builder = builder.add(Attributes.FOLLOW_RANGE, 32);
        return builder;
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }



    @Override
    protected void tickDeath() {
        ++this.deathTime;
        if (this.deathTime == 20) {
            this.remove(Entity.RemovalReason.KILLED);
            this.dropExperience();
            //this.level().getServer().getLootData().getLootTable(this.getLootTable()).addPool(LootPool.lootPool().build());
        }
    }

    protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
        super.dropCustomDeathLoot(source, looting, recentlyHitIn);
        this.spawnAtLocation(new ItemStack(SyGItem.ITEM_1.get()));
    }

}
