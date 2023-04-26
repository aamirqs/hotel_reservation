package com.example.hotelmonitoring.data.Object;

public class RoomType {
    private String roomTypeCode;
    private String roomDesc;
    private float roomCost;

    public RoomType(String roomTypeCode, String roomDesc, float roomCost) {
        this.roomTypeCode = roomTypeCode;
        this.roomDesc = roomDesc;
        this.roomCost = roomCost;
    }

    public String getRoomTypeCode() {
        return roomTypeCode;
    }

    public void setRoomTypeCode(String roomTypeCode) {
        this.roomTypeCode = roomTypeCode;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    public float getRoomCost() {
        return roomCost;
    }

    public void setRoomCost(float roomCost) {
        this.roomCost = roomCost;
    }
}
