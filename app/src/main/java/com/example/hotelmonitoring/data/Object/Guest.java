package com.example.hotelmonitoring.data.Object;

public class Guest {
    private String guestId;
    private String guestFullName;
    private String guestPhoneNumber;

    public Guest(String guestId, String guestFullName, String guestPhoneNumber) {
        this.guestId = guestId;
        this.guestFullName = guestFullName;
        this.guestPhoneNumber = guestPhoneNumber;
    }

    public String getGuestID() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public String getGuestFullName() {
        return guestFullName;
    }

    public void setGuestFullName(String guestFullName) {
        this.guestFullName = guestFullName;
    }

    public String getGuestPhoneNumber() {
        return guestPhoneNumber;
    }

    public void setGuestPhoneNumber(String guestPhoneNumber) {
        this.guestPhoneNumber = guestPhoneNumber;
    }
}
