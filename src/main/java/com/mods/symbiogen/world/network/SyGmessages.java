package com.mods.symbiogen.world.network;

import com.mods.symbiogen.SymbioGen;
import com.mods.symbiogen.world.network.data.SyGSendSync;
import com.mods.symbiogen.world.network.data.SyGSyncDatas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class SyGmessages {
    private static SimpleChannel INSTANCE;

    private static int id=0;
    private static int id(){
        return id++;
    }

    public static void Register(){
        SimpleChannel network= NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(SymbioGen.MODID,"messages"))
                .networkProtocolVersion(()->"1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        network.messageBuilder(SyGSyncDatas.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(SyGSyncDatas::new)
                .encoder(SyGSyncDatas::toBytes)
                .consumerMainThread(SyGSyncDatas::handle)
                .add();
        network.messageBuilder(SyGSendSync.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(SyGSendSync::new)
                .encoder(SyGSendSync::toBytes)
                .consumerMainThread(SyGSendSync::handle)
                .add();

        INSTANCE=network;
    }
    public static <MSG> void sendToServer(MSG message){
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player){
        INSTANCE.send(PacketDistributor.PLAYER.with(()->player),message);
    }

}
