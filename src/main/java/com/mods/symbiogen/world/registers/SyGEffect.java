package com.mods.symbiogen.world.registers;

import com.mods.symbiogen.SymbioGen;
import com.mods.symbiogen.core.SymMod;
import com.mods.symbiogen.effect.ISyGEffect;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.RegistryObject;

public class SyGEffect {
    public static final DeferredRegister<MobEffect> EFFECTS=DeferredRegister.create(Registries.MOB_EFFECT, SymbioGen.MODID);
    public static final RegistryObject<MobEffect> EXPALE_=EFFECTS.register(SymMod.ModKey("spr_effect"),()->new ISyGEffect(MobEffectCategory.HARMFUL,7561558));






}
