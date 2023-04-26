package com.example.hotelmonitoring.data.DAO;

import com.example.hotelmonitoring.data.Object.PaymentType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentTypeDAO {
    private Connection conn;

    public PaymentTypeDAO(Connection conn) {
        this.conn = conn;
    }

    public void addPaymentType(PaymentType paymentType) throws SQLException {
        String sql = "INSERT INTO Payment_Type (Payment_Code, Payment_Desc) VALUES (?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, paymentType.getPaymentCode());
            stmt.setString(2, paymentType.getPaymentDesc());
            stmt.executeUpdate();
        }
    }

    public void updatePaymentType(PaymentType paymentType) throws SQLException {
        String sql = "UPDATE Payment_Type SET Payment_Desc = ? WHERE Payment_Code = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, paymentType.getPaymentDesc());
            stmt.setString(2, paymentType.getPaymentCode());
            stmt.executeUpdate();
        }
    }

    public void deletePaymentType(String paymentCode) throws SQLException {
        String sql = "DELETE FROM Payment_Type WHERE Payment_Code = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, paymentCode);
            stmt.executeUpdate();
        }
    }

    public PaymentType getPaymentTypeByCode(String paymentCode) throws SQLException {
        String sql = "SELECT Payment_Code, Payment_Desc FROM Payment_Type WHERE Payment_Code = ?";
        PaymentType paymentType = null;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, paymentCode);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String desc = rs.getString("Payment_Desc");
                paymentType = new PaymentType(paymentCode, desc);
            }
        }

        return paymentType;
    }

    public List<PaymentType> getAllPaymentTypes() throws SQLException {
        String sql = "SELECT Payment_Code, Payment_Desc FROM Payment_Type";
        List<PaymentType> paymentTypes = new ArrayList<>();

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String code = rs.getString("Payment_Code");
                String desc = rs.getString("Payment_Desc");
                PaymentType paymentType = new PaymentType(code, desc);
                paymentTypes.add(paymentType);
            }
        }

        return paymentTypes;
    }
}