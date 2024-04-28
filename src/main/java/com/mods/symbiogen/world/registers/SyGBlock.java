package com.mods.symbiogen.world.registers;

import com.mods.symbiogen.SymbioGen;

import com.mods.symbiogen.core.SymMod;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SyGBlock {
    public static final DeferredRegister<Block> BLOCKS=DeferredRegister.create(ForgeRegistries.BLOCKS, SymbioGen.MODID);
    public static final RegistryObject<Block> INFECTED_GRASS_BLOCK=BLOCKS.register(SymMod.ModKey("infected_grass_block"),()->new Block(BlockBehaviour.Properties.of()));




}
