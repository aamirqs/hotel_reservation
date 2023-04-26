package com.example.hotelmonitoring.data.Object;

public class Room {
    private String roomId;
    private int roomNum;
    private RoomType roomType;

    private String roomTypeCode;

    public Room(String roomId, int roomNum, RoomType roomType) {
        this.roomId = roomId;
        this.roomNum = roomNum;
        this.roomType = roomType;
    }

    public Room(String roomId, int roomNum, String roomTypeCode) {
        this.roomId = roomId;
        this.roomNum = roomNum;
        this.roomTypeCode = roomTypeCode;
    }
    public String getRoomID() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public String getRoomTypeCode() {
        return roomTypeCode;
    }

    public void setRoomTypeCode(String roomTypeCode) {
        this.roomTypeCode = roomTypeCode;
    }
}

