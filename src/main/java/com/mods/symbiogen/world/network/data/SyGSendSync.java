package com.mods.symbiogen.world.network.data;

import com.mods.symbiogen.core.SymMod;
import com.mods.symbiogen.world.capability.SyGCapabilityProvider;
import com.mods.symbiogen.world.capability.data.SyGAttrubes;
import com.mods.symbiogen.world.network.SyGmessages;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.Map;
import java.util.function.Supplier;

public class SyGSendSync {


    public SyGSendSync(){

    }

    public SyGSendSync(FriendlyByteBuf byteBuf){

    }

    public void toBytes(FriendlyByteBuf buf){

    }

    public boolean handle (Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context=supplier.get();
        context.enqueueWork(()->{
            ServerPlayer player=context.getSender();
            if (player != null) {
                player.getCapability(SyGCapabilityProvider.PLAYER_ATTRIBUTE).ifPresent(Profession -> {
                    if (Profession.getProfession()!=null && !Profession.getProfession().isEmpty()) {//一些能力添加
                        Profession.add("","evolution_stage",0.0,0.0,0.0,false);
                        Profession.add("","safety_period",0.0,0.0,0.0,false);
                        SyGmessages.sendToPlayer(new SyGSyncDatas(Profession.getProfession()), player);
                    }
            });
        };

    });
        return  true;
    }


}
