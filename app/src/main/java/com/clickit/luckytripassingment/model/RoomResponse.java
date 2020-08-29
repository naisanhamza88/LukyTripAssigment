package com.clickit.luckytripassingment.model;

import android.os.Parcelable;

import com.clickit.luckytripassingment.base.BaseEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

public class RoomResponse extends BaseEntity {

    @SerializedName("rooms")
    private final List<Rooms> rooms;

    public RoomResponse(List<Rooms> rooms) {
        this.rooms = rooms;
    }

    public List<Rooms> getRooms() {
        return rooms;
    }


}
