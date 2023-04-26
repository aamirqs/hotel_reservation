package com.example.hotelmonitoring.data.DAO;

import com.example.hotelmonitoring.data.Object.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {

    private Connection connection;

    public PaymentDAO(Connection connection) {
        this.connection = connection;
    }

    public void addPayment(Payment payment) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Payment (Payment_ID, Invoice_ID, Payment_Code, Payment_Amt) VALUES (?, ?, ?, ?)");
        statement.setString(1, payment.getPaymentID());
        statement.setString(2, payment.getInvoiceID());
        statement.setString(3, payment.getPaymentCode());
        statement.setFloat(4, payment.getPaymentAmt());
        statement.executeUpdate();
        statement.close();
    }

    public void updatePayment(Payment payment) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("UPDATE Payment SET Payment_Code=?, Payment_Amt=? WHERE Payment_ID=?");
        statement.setString(1, payment.getPaymentCode());
        statement.setFloat(2, payment.getPaymentAmt());
        statement.setString(3, payment.getPaymentID());
        statement.executeUpdate();
        statement.close();
    }

    public void deletePayment(String paymentID) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Payment WHERE Payment_ID=?");
        statement.setString(1, paymentID);
        statement.executeUpdate();
        statement.close();
    }

    public Payment getPaymentByID(String paymentID) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Payment WHERE Payment_ID=?");
        statement.setString(1, paymentID);
        ResultSet rs = statement.executeQuery();
        Payment payment = null;
        if (rs.next()) {
            payment = new Payment(rs.getString("Payment_ID"), rs.getString("Invoice_ID"), rs.getString("Payment_Code"), rs.getFloat("Payment_Amt"));
        }
        rs.close();
        statement.close();
        return payment;
    }

    public List<Payment> getAllPayments() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Payment");
        ResultSet rs = statement.executeQuery();
        List<Payment> payments = new ArrayList<>();
        while (rs.next()) {
            Payment payment = new Payment(rs.getString("Payment_ID"), rs.getString("Invoice_ID"), rs.getString("Payment_Code"), rs.getFloat("Payment_Amt"));
            payments.add(payment);
        }
        rs.close();
        statement.close();
        return payments;
    }
}