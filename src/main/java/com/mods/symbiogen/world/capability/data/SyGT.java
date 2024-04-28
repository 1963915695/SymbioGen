package com.mods.symbiogen.world.capability.data;

import net.minecraft.nbt.CompoundTag;

import java.util.Map;

public interface SyGT {
    void copy(SyGT cap);
    Map<String, SyGAttrubes> getProfession();

    CompoundTag savaNBtData(CompoundTag tag);
    void loadNbtData(CompoundTag tag);
    void add(String id,String name,Double min,Double max,Double value,Boolean s);
}
