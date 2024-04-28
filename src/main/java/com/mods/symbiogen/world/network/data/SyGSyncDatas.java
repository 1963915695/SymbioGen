package com.mods.symbiogen.world.network.data;

import com.mods.symbiogen.world.capability.data.SyGAttrubes;
import com.mods.symbiogen.world.capability.data.SyGData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.function.Supplier;

public class SyGSyncDatas {
    Map<String, SyGAttrubes> testMap;

    public SyGSyncDatas(Map<String, SyGAttrubes> IData){
        this.testMap=IData;
    }

    public SyGSyncDatas(FriendlyByteBuf byteBuf){
        this.testMap= byteBuf.readMap(FriendlyByteBuf::readUtf,SyGAttrubes::deserialize);
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeMap(this.testMap, FriendlyByteBuf::writeUtf, (buf1, value) -> value.serialize(buf));//反序列化
    }

    public boolean handle (Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context=supplier.get();
        context.enqueueWork(()->{
            SyGData.set(testMap);
        });
        return  true;
    }


}
