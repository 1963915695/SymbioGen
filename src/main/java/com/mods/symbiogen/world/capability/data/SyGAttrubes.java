package com.mods.symbiogen.world.capability.data;

import net.minecraft.network.FriendlyByteBuf;

public class SyGAttrubes {
    String ID;
    String Name;
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    boolean start;
    double min,max,value;
    public static SyGAttrubes deserialize(FriendlyByteBuf buffer) {//序列化
        SyGAttrubes table = new SyGAttrubes();
        table.setID(buffer.readUtf());
        table.setName(buffer.readUtf());
        table.setMin(buffer.readDouble());
        table.setMax(buffer.readDouble());
        table.setValue(buffer.readDouble());
        table.setStart(buffer.readBoolean());
        return table;
    }
    public void serialize(FriendlyByteBuf buf) {//反序列化
        buf.writeUtf(this.ID);
        buf.writeUtf(this.Name);
        buf.writeDouble(this.min);
        buf.writeDouble(this.max);
        buf.writeDouble(this.value);
        buf.writeBoolean(this.start);
    }
}
