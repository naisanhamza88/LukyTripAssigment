package com.clickit.luckytripassingment.model;

import com.clickit.luckytripassingment.base.BaseEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Rooms extends BaseEntity {
    @SerializedName("room_id")
    private final int roomId;

    @SerializedName("name")
    private final String name;

    @SerializedName("room_description")
    private final String roomDescription;

    @SerializedName("number_of_rooms_left")
    private final int numberOfRoomsLeft;

    @SerializedName("max_occupancy")
    private final int maxOccupancy;

    @SerializedName("price")
    private final Price price;

    @SerializedName("bed_configurations")
    private final List<BedConfigurations> bedConfigurations;

    @SerializedName("photos")
    private final List<String> photos;

    public Rooms(int roomId, String name, String roomDescription, int numberOfRoomsLeft,
                 int maxOccupancy, Price price, List<BedConfigurations> bedConfigurations,
                 List<String> photos) {
        this.roomId = roomId;
        this.name = name;
        this.roomDescription = roomDescription;
        this.numberOfRoomsLeft = numberOfRoomsLeft;
        this.maxOccupancy = maxOccupancy;
        this.price = price;
        this.bedConfigurations = bedConfigurations;
        this.photos = photos;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getName() {
        return name;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public int getNumberOfRoomsLeft() {
        return numberOfRoomsLeft;
    }

    public int getMaxOccupancy() {
        return maxOccupancy;
    }

    public Price getPrice() {
        return price;
    }

    public List<BedConfigurations> getBedConfigurations() {
        return bedConfigurations;
    }

    public List<String> getPhotos() {
        return photos;
    }

}
