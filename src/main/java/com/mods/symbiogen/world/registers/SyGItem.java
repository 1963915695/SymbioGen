package com.mods.symbiogen.world.registers;

import com.mods.symbiogen.SymbioGen;
import com.mods.symbiogen.core.SymMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SyGItem {
    public static final DeferredRegister<Item> ITEMS=DeferredRegister.create(ForgeRegistries.ITEMS, SymbioGen.MODID);
    public static final RegistryObject<Item> ITEM_GROUP=ITEMS.register(SymMod.ModKey("item_group"),()->new Item(new Item.Properties()));
    public static final RegistryObject<BlockItem> ITEM_INFECTED_GRASS_BLOCK=ITEMS.register(SymMod.ModKey("infected_grass_block"),
            ()->new BlockItem(SyGBlock.INFECTED_GRASS_BLOCK.get(),new Item.Properties()));

    public static final RegistryObject<Item> ITEM_1=ITEMS.register(SymMod.ModKey("item_1"),()->new Item(new Item.Properties()));







    public static final RegistryObject<Item> Catalog_egg = ITEMS.register(SymMod.ModKey("Master_Catalog_egg"), () -> new ForgeSpawnEggItem(SyGIEntity.Master_Catalog, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> Zomble_egg = ITEMS.register(SymMod.ModKey("Master_Zomble_egg"), () -> new ForgeSpawnEggItem(SyGIEntity.Master_Zomble, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> Cow_egg = ITEMS.register(SymMod.ModKey("Master_Cow_egg"), () -> new ForgeSpawnEggItem(SyGIEntity.Master_Cow, -1, -1, new Item.Properties()));

    public static final RegistryObject<Item> PIG_egg = ITEMS.register(SymMod.ModKey("Master_PIG_egg"), () -> new ForgeSpawnEggItem(SyGIEntity.Master_PIG, -1, -1, new Item.Properties()));

    public static final RegistryObject<Item> Player_egg = ITEMS.register(SymMod.ModKey("Master_Player_egg"), () -> new ForgeSpawnEggItem(SyGIEntity.Master_Player, -1, -1, new Item.Properties()));

    public static final RegistryObject<Item> Sheep_egg = ITEMS.register(SymMod.ModKey("Master_Sheep_egg"), () -> new ForgeSpawnEggItem(SyGIEntity.Master_Sheep, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> Villager_egg = ITEMS.register(SymMod.ModKey("Master_Villager_egg"), () -> new ForgeSpawnEggItem(SyGIEntity.Master_Villager, -1, -1, new Item.Properties()));

    public static final RegistryObject<Item> Wolf_egg = ITEMS.register(SymMod.ModKey("Master_Wolf_egg"), () -> new ForgeSpawnEggItem(SyGIEntity.Master_Wolf, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> Iplayer_egg = ITEMS.register(SymMod.ModKey("Master_Iplayer_egg"), () -> new ForgeSpawnEggItem(SyGIEntity.Master_Iplayer, -1, -1, new Item.Properties()));

    public static final RegistryObject<Item> Chiken_egg = ITEMS.register(SymMod.ModKey("Master_Chiken_egg"), () -> new ForgeSpawnEggItem(SyGIEntity.Master_Chiken, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> Pillager_egg = ITEMS.register(SymMod.ModKey("Master_Pillager_egg"), () -> new ForgeSpawnEggItem(SyGIEntity.Master_Pillager, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> Polar_bear_egg = ITEMS.register(SymMod.ModKey("Polar_bear_egg"), () -> new ForgeSpawnEggItem(SyGIEntity.Master_Polar_bear, -1, -1, new Item.Properties()));

    public static final RegistryObject<Item> Fox_egg = ITEMS.register(SymMod.ModKey("fox_egg"), () -> new ForgeSpawnEggItem(SyGIEntity.Master_Fox, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> Spider_egg = ITEMS.register(SymMod.ModKey("Spider_egg"), () -> new ForgeSpawnEggItem(SyGIEntity.Master_Spider, -1, -1, new Item.Properties()));

}
