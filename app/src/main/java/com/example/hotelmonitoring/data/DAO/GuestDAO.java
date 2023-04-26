package com.example.hotelmonitoring.data.DAO;

import com.example.hotelmonitoring.data.Object.Guest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestDAO {
    private Connection connection;

    public GuestDAO(Connection connection) {
        this.connection = connection;
    }

    public void addGuest(Guest guest) throws SQLException {
        String query = "INSERT INTO Guest (Guest_ID, Guest_Full_Name, Guest_Phone_Number) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, guest.getGuestID());
        statement.setString(2, guest.getGuestFullName());
        statement.setString(3, guest.getGuestPhoneNumber());
        statement.executeUpdate();
    }

    public void updateGuest(Guest guest) throws SQLException {
        String query = "UPDATE Guest SET Guest_Full_Name=?, Guest_Phone_Number=? WHERE Guest_ID=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, guest.getGuestFullName());
        statement.setString(2, guest.getGuestPhoneNumber());
        statement.setString(3, guest.getGuestID());
        statement.executeUpdate();
    }

    public void deleteGuest(String guestId) throws SQLException {
        String query = "DELETE FROM Guest WHERE Guest_ID=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, guestId);
        statement.executeUpdate();
    }

    public Guest getGuestById(String guestId) throws SQLException {
        String query = "SELECT * FROM Guest WHERE Guest_ID=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, guestId);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            String guestFullName = rs.getString("Guest_Full_Name");
            String guestPhoneNumber = rs.getString("Guest_Phone_Number");
            Guest guest = new Guest(guestId, guestFullName, guestPhoneNumber);
            return guest;
        }
        return null;
    }

    public List<Guest> getAllGuests() throws SQLException {
        String query = "SELECT * FROM Guest";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        List<Guest> guests = new ArrayList<>();
        while (rs.next()) {
            String guestId = rs.getString("Guest_ID");
            String guestFullName = rs.getString("Guest_Full_Name");
            String guestPhoneNumber = rs.getString("Guest_Phone_Number");
            Guest guest = new Guest(guestId, guestFullName, guestPhoneNumber);
            guests.add(guest);
        }
        return guests;
    }

    public boolean isPhoneNumberUnique(String phoneNumber) throws SQLException {
        String query = "SELECT * FROM Guest WHERE Guest_Phone_Number=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, phoneNumber);
        ResultSet rs = statement.executeQuery();
        return !rs.next();
    }
}