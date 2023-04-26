package com.example.hotelmonitoring.data.Object;

import com.example.hotelmonitoring.data.Object.PaymentType;

public class Payment {
    private String paymentID;
    private Invoice invoice;
    private String invoiceID;
    private PaymentType paymentType;
    private String paymentCode;
    private float paymentAmt;

    public Payment(String paymentID, Invoice invoice, PaymentType paymentType, float paymentAmt) {
        this.paymentID = paymentID;
        this.invoice = invoice;
        this.paymentType = paymentType;
        this.paymentAmt = paymentAmt;
    }

    public Payment(String paymentID, String invoiceID, String paymentCode, float paymentAmt) {
        this.paymentID = paymentID;
        this.invoice = invoice;
        this.paymentType = paymentType;
        this.paymentAmt = paymentAmt;
    }

    // getters and setters
    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public String getPaymentCode() {
        return paymentCode;
    }
    public float getPaymentAmt() {
        return paymentAmt;
    }

    public void setPaymentAmt(float paymentAmt) {
        this.paymentAmt = paymentAmt;
    }
}

