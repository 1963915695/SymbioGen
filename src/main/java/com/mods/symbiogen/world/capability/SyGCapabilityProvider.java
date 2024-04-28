package com.mods.symbiogen.world.capability;

import com.mods.symbiogen.world.capability.data.SyGCapaAttribute;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SyGCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

    public static Capability<SyGCapaAttribute> PLAYER_ATTRIBUTE= CapabilityManager.get(new CapabilityToken<SyGCapaAttribute>() {
    }); private SyGCapaAttribute H2ATTRIBUTE=null;

    private final LazyOptional<SyGCapaAttribute> optional=LazyOptional.of(this::createAttrube);

    private SyGCapaAttribute createAttrube() {
        if (this.H2ATTRIBUTE==null){
            this.H2ATTRIBUTE=new SyGCapaAttribute();
        }
        return this.H2ATTRIBUTE;

    }


    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap==PLAYER_ATTRIBUTE){
            return optional.cast();
        }
        return  LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag IAttrube=new CompoundTag();
        createAttrube().savaNBtData(IAttrube);
        return IAttrube;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createAttrube().loadNbtData(nbt);
    }




}
