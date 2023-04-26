package com.example.hotelmonitoring.data.DAO;

import com.example.hotelmonitoring.data.Object.Invoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InvoiceDAO {

    private Connection connection;

    public InvoiceDAO(Connection connection) {
        this.connection = connection;
    }

    public void addInvoice(Invoice invoice) throws SQLException {
        String sql = "INSERT INTO Invoice (Invoice_ID, Reservation_ID, Guest_ID, Room_Charge, Extra_Charges) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, invoice.getInvoiceId());
            statement.setString(2, invoice.getReservationId());
            statement.setString(3, invoice.getGuestId());
            statement.setFloat(4, invoice.getRoomCharge());
            statement.setFloat(5, invoice.getExtraCharges());
            statement.executeUpdate();
        }
    }

    public Invoice getInvoiceById(String invoiceId) throws SQLException {
        String sql = "SELECT * FROM Invoice WHERE Invoice_ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, invoiceId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String reservationId = resultSet.getString("Reservation_ID");
                    String guestId = resultSet.getString("Guest_ID");
                    float roomCharge = resultSet.getFloat("Room_Charge");
                    float extraCharges = resultSet.getFloat("Extra_Charges");
                    return new Invoice(invoiceId, reservationId, guestId, roomCharge, extraCharges);
                } else {
                    return null;
                }
            }
        }
    }

    public void updateInvoice(Invoice invoice) throws SQLException {
        String sql = "UPDATE Invoice SET Reservation_ID = ?, Guest_ID = ?, Room_Charge = ?, Extra_Charges = ? WHERE Invoice_ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, invoice.getReservationId());
            statement.setString(2, invoice.getGuestId());
            statement.setFloat(3, invoice.getRoomCharge());
            statement.setFloat(4, invoice.getExtraCharges());
            statement.setString(5, invoice.getInvoiceId());
            statement.executeUpdate();
        }
    }

    public void deleteInvoice(String invoiceId) throws SQLException {
        String sql = "DELETE FROM Invoice WHERE Invoice_ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, invoiceId);
            statement.executeUpdate();
        }
    }
}
