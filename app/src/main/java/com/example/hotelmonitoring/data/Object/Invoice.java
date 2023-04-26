package com.example.hotelmonitoring.data.Object;

public class Invoice {
    private String invoiceId;
    private String reservationId;
    private String guestId;
    private float roomCharge;
    private float extraCharges;

    public Invoice(String invoiceId, String reservationId, String guestId, float roomCharge, float extraCharges) {
        this.invoiceId = invoiceId;
        this.reservationId = reservationId;
        this.guestId = guestId;
        this.roomCharge = roomCharge;
        this.extraCharges = extraCharges;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public float getRoomCharge() {
        return roomCharge;
    }

    public void setRoomCharge(float roomCharge) {
        this.roomCharge = roomCharge;
    }

    public float getExtraCharges() {
        return extraCharges;
    }

    public void setExtraCharges(float extraCharges) {
        this.extraCharges = extraCharges;
    }
}

