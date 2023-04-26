package com.example.hotelmonitoring.data.DAO;

import com.example.hotelmonitoring.data.Object.Room;
import com.example.hotelmonitoring.data.Object.RoomType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {
    private Connection connection;

    public RoomDAO(Connection connection) {
        this.connection = connection;
    }

    public void addRoom(Room room) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Room (Room_ID, Room_Num, Room_Type_Code) VALUES (?, ?, ?);");
        preparedStatement.setString(1, room.getRoomID());
        preparedStatement.setInt(2, room.getRoomNum());
        preparedStatement.setString(3, room.getRoomType().getRoomTypeCode());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public Room getRoomById(String roomId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM Room WHERE Room_ID = ?;");
        preparedStatement.setString(1, roomId);
        ResultSet resultSet = preparedStatement.executeQuery();
        Room room = null;
        if (resultSet.next()) {
            room = new Room(resultSet.getString("Room_ID"),
                    resultSet.getInt("Room_Num"),
                    getRoomTypeByCode(resultSet.getString("Room_Type_Code")));
        }
        resultSet.close();
        preparedStatement.close();
        return room;
    }

    public List<Room> getAllRooms() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Room;");
        List<Room> rooms = new ArrayList<>();
        while (resultSet.next()) {
            Room room = new Room(resultSet.getString("Room_ID"),
                    resultSet.getInt("Room_Num"),
                    getRoomTypeByCode(resultSet.getString("Room_Type_Code")));
            rooms.add(room);
        }
        resultSet.close();
        statement.close();
        return rooms;
    }

    public void updateRoom(Room room) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE Room SET Room_Num = ?, Room_Type_Code = ? WHERE Room_ID = ?;");
        preparedStatement.setInt(1, room.getRoomNum());
        preparedStatement.setString(2, room.getRoomType().getRoomTypeCode());
        preparedStatement.setString(3, room.getRoomID());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void deleteRoom(Room room) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM Room WHERE Room_ID = ?;");
        preparedStatement.setString(1, room.getRoomID());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public RoomType getRoomTypeByCode(String roomTypeCode) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM Room_Type WHERE Room_Type_Code = ?;");
        preparedStatement.setString(1, roomTypeCode);
        ResultSet resultSet = preparedStatement.executeQuery();
        RoomType roomType = null;
        if (resultSet.next()) {
            roomType = new RoomType(resultSet.getString("Room_Type_Code"),
                    resultSet.getString("Room_Desc"),
                    resultSet.getFloat("Room_Cost"));
        }
        resultSet.close();
        preparedStatement.close();
        return roomType;
    }

}
