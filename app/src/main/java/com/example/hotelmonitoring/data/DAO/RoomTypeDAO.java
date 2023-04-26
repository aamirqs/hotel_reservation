package com.example.hotelmonitoring.data.DAO;

import com.example.hotelmonitoring.data.Object.RoomType;

import java.sql.*;
import java.util.*;

public class RoomTypeDAO {
    private Connection conn;

    public RoomTypeDAO(Connection conn) {
        this.conn = conn;
    }

    public List<RoomType> getAllRoomTypes() throws SQLException {
        List<RoomType> roomTypes = new ArrayList<>();

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Room_Type");

            while (rs.next()) {
                RoomType roomType = new RoomType(
                        rs.getString("Room_Type_Code"),
                        rs.getString("Room_Desc"),
                        rs.getFloat("Room_Cost")
                );

                roomTypes.add(roomType);
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
        }

        return roomTypes;
    }

    public RoomType getRoomTypeByCode(String roomTypeCode) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("SELECT * FROM Room_Type WHERE Room_Type_Code = ?");
            stmt.setString(1, roomTypeCode);
            rs = stmt.executeQuery();

            if (rs.next()) {
                RoomType roomType = new RoomType(
                        rs.getString("Room_Type_Code"),
                        rs.getString("Room_Desc"),
                        rs.getFloat("Room_Cost")
                );

                return roomType;
            } else {
                return null;
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
        }
    }

    public void addRoomType(RoomType roomType) throws SQLException {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO Room_Type (Room_Type_Code, Room_Desc, Room_Cost) VALUES (?, ?, ?)");
            stmt.setString(1, roomType.getRoomTypeCode());
            stmt.setString(2, roomType.getRoomDesc());
            stmt.setFloat(3, roomType.getRoomCost());
            stmt.executeUpdate();
        } finally {
            if (stmt != null) stmt.close();
        }
    }

    public void updateRoomType(RoomType roomType) throws SQLException {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("UPDATE Room_Type SET Room_Desc = ?, Room_Cost = ? WHERE Room_Type_Code = ?");
            stmt.setString(1, roomType.getRoomDesc());
            stmt.setFloat(2, roomType.getRoomCost());
            stmt.setString(3, roomType.getRoomTypeCode());
            stmt.executeUpdate();
        } finally {
            if (stmt != null) stmt.close();
        }
    }

    public void deleteRoomType(String roomTypeCode) throws SQLException {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("DELETE FROM Room_Type WHERE Room_Type_Code = ?");
            stmt.setString(1, roomTypeCode);
            stmt.executeUpdate();
        } finally {
            if (stmt != null) stmt.close();
        }
    }
}