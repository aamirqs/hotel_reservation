package com.example.hotelmonitoring.data.DAO;

import com.example.hotelmonitoring.data.Object.Reservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class ReservationDAO {
    private Connection connection;

    public ReservationDAO(Connection connection) {
        this.connection = connection;
    }

    public ReservationDAO(){}

    public void addReservation(Reservation reservation) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO Reservation (Reservation_ID, Room_ID, Guest_ID, Employee_ID, Check_In_Date, Check_Out_Date) VALUES (?, ?, ?, ?, ?, ?)"
            );
            statement.setString(1, reservation.getReservationID());
            statement.setString(2, reservation.getRoom().getRoomID());
            statement.setString(3, reservation.getGuest().getGuestID());
            statement.setString(4, reservation.getEmployee().getEmployeeID());
            statement.setDate(5, new Date(reservation.getCheckInDate().getTime()));
            statement.setDate(6, new Date(reservation.getCheckOutDate().getTime()));
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    public void updateReservation(Reservation reservation) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "UPDATE Reservation SET Room_ID = ?, Guest_ID = ?, Employee_ID = ?, Check_In_Date = ?, Check_Out_Date = ? WHERE Reservation_ID = ?"
            );
            statement.setString(1, reservation.getRoom().getRoomID());
            statement.setString(2, reservation.getGuest().getGuestID());
            statement.setString(3, reservation.getEmployee().getEmployeeID());
            statement.setDate(4, new Date(reservation.getCheckInDate().getTime()));
            statement.setDate(5, new Date(reservation.getCheckOutDate().getTime()));
            statement.setString(6, reservation.getReservationID());
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    public void deleteReservation(Reservation reservation) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "DELETE FROM Reservation WHERE Reservation_ID = ?"
            );
            statement.setString(1, reservation.getReservationID());
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    public Reservation getReservationByID(String reservationID) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(
                    "SELECT Room_ID, Guest_ID, Employee_ID, Check_In_Date, Check_Out_Date FROM Reservation WHERE Reservation_ID = ?"
            );
            statement.setString(1, reservationID);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String roomID = resultSet.getString("Room_ID");
                String guestID = resultSet.getString("Guest_ID");
                String employeeID = resultSet.getString("Employee_ID");
                Date checkInDate = resultSet.getDate("Check_In_Date");
                Date checkOutDate = resultSet.getDate("Check_Out_Date");
                Reservation reservation = new Reservation(
                        reservationID,
                        new String(roomID),
                        new String(guestID),
                        new String(employeeID),
                        (Date) new java.util.Date(checkInDate.getTime()),
                        (Date) new java.util.Date(checkOutDate.getTime())
                );
                return reservation;
            } else {
                return null;
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
    }

    public List<Reservation> getAllReservations() throws SQLException {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(
                    "SELECT Reservation_ID, Room_ID, Guest_ID, Employee_ID, Check_In_Date, Check_Out_Date FROM Reservation"
            );
            List<Reservation> reservations = new ArrayList<>();
            while (resultSet.next()) {
                String reservationID = resultSet.getString("Reservation_ID");
                String roomID = resultSet.getString("Room_ID");
                String guestID = resultSet.getString("Guest_ID");
                String employeeID = resultSet.getString("Employee_ID");
                Date checkInDate = resultSet.getDate("Check_In_Date");
                Date checkOutDate = resultSet.getDate("Check_Out_Date");
                Reservation reservation = new Reservation(
                        reservationID,
                        new String(roomID),
                        new String(guestID),
                        new String(employeeID),
                        (Date) new java.util.Date(checkInDate.getTime()),
                        (Date) new java.util.Date(checkOutDate.getTime())
                );
                reservations.add(reservation);
            }
            return reservations;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
    }
}