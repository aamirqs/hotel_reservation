package com.example.hotelmonitoring.data.Object;

public class PaymentType {
    private String paymentCode;
    private String paymentDesc;

    public PaymentType(String paymentCode, String paymentDesc) {
        this.paymentCode = paymentCode;
        this.paymentDesc = paymentDesc;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public String getPaymentDesc() {
        return paymentDesc;
    }

    public void setPaymentDesc(String paymentDesc) {
        this.paymentDesc = paymentDesc;
    }
}
