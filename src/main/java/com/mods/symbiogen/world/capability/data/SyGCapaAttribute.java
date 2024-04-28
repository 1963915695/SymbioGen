package com.mods.symbiogen.world.capability.data;

import com.mods.symbiogen.core.SymMod;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;

import java.util.HashMap;
import java.util.Map;

public class SyGCapaAttribute implements SyGT{
    private Map<String,SyGAttrubes> Data=new HashMap<>();

    public SyGCapaAttribute() {
        add("","evolution_stage_value",0.0d,100.0,0.0d,false);
    }

    @Override
    public void copy(SyGT cap) {
        Data = cap.getProfession();
    }



    @Override
    public Map<String, SyGAttrubes> getProfession() {
        return Data;
    }

    @Override
    public CompoundTag savaNBtData(CompoundTag tag) {
        if (this.Data != null) {
            ListTag tagList = new ListTag();
            this.Data.values().forEach(tab -> {
                CompoundTag dataTag = new CompoundTag();
                dataTag.putString("id", tab.getID());
                dataTag.putString("name", tab.getName());
                dataTag.putDouble("min", tab.getMin());
                dataTag.putDouble("max", tab.getMax());
                dataTag.putDouble("value", tab.getValue());
                dataTag.putBoolean("start",tab.isStart());
                tagList.add(dataTag);
            });
            tag.put(SymMod.ModKey("attribute"), tagList);
        }
        return tag;
    }

    @Override
    public void loadNbtData(CompoundTag tag) {
        if (this.Data==null){
            this.Data=new HashMap<>();
        }
        if (tag.contains(SymMod.ModKey("attribute"), 9)) {
            ListTag dataList = tag.getList(SymMod.ModKey("attribute"), 10);
            dataList.forEach(dataTag -> {
                if (dataTag instanceof CompoundTag compoundData) {
                    String id = compoundData.getString("id");
                    String name = compoundData.getString("name");
                    double min = compoundData.getDouble("min");
                    double max = compoundData.getDouble("max");
                    double value = compoundData.getDouble("value");
                    boolean start=compoundData.getBoolean("start");
                    this.Data.put(id,create(id,name,min,max,value,start));
                }
            });
        }
    }
    @Override
    public void add(String name, String id, Double min, Double max, Double value, Boolean s) {
        this.Data.put(id,create(id,name,min,max,value,s));
    }

    public static SyGAttrubes create(String Iid, String Iname, Double Imin, Double Imax, Double Ivalue, boolean Istart){
        SyGAttrubes TAB=new SyGAttrubes();
        TAB.ID=Iid;
        TAB.Name=Iname;
        TAB.max=Imax;
        TAB.min=Imin;
        TAB.value=Ivalue;
        TAB.start=Istart;
        return TAB;
    }


}
