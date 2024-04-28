package com.mods.symbiogen.world.registers;

import com.mods.symbiogen.SymbioGen;
import com.mods.symbiogen.core.SymMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.mods.symbiogen.world.registers.SyGItem.*;

public class SyGtables {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SymbioGen.MODID);
    public static final RegistryObject<CreativeModeTab> TAB1 = CREATIVE_MODE_TABS.register(SymMod.ModKey("item_group"), () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ITEM_GROUP.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ITEM_INFECTED_GRASS_BLOCK.get());
                output.accept(Cow_egg.get());
                output.accept(Zomble_egg.get());
                output.accept(Player_egg.get());
                output.accept(Wolf_egg.get());
                output.accept(PIG_egg.get());
                output.accept(Sheep_egg.get());
                output.accept(Catalog_egg.get());
                output.accept(Villager_egg.get());
                output.accept(Iplayer_egg.get());
                output.accept(Pillager_egg.get());
                output.accept(Chiken_egg.get());
                output.accept(Polar_bear_egg.get());
                output.accept(Fox_egg.get());
            }).build());
}
