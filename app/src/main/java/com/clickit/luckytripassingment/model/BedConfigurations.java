package com.clickit.luckytripassingment.model;


import com.clickit.luckytripassingment.base.BaseEntity;
import com.google.gson.annotations.SerializedName;

public class BedConfigurations extends BaseEntity {
    @SerializedName("count")
    private final int count;

    @SerializedName("name")
    private final String name;

    public BedConfigurations(int count, String name) {
        this.count = count;
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }
}
