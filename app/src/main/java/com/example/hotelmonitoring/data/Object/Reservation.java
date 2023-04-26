package com.example.hotelmonitoring.data.Object;

import com.example.hotelmonitoring.data.Object.Employee;
import com.example.hotelmonitoring.data.Object.Guest;
import com.example.hotelmonitoring.data.Object.Room;

import java.sql.Date;

public class Reservation {
    private String reservationID;
    private Room room;
    private String roomID;
    private Guest guest;
    private String guestID;
    private Employee employee;
    private String employeeID;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(String reservationID, Room room, Guest guest, Employee employee,
                       Date checkInDate, Date checkOutDate) {
        this.reservationID = reservationID;
        this.room = room;
        this.guest = guest;
        this.employee = employee;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Reservation(String reservationID, String roomID, String guestID, String employeeID,
                       Date checkInDate, Date checkOutDate) {
        this.reservationID = reservationID;
        this.roomID = roomID;
        this.guestID = guestID;
        this.employee = employee;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public String getReservationID() {
        return reservationID;
    }

    public void setReservationID(String reservationID) {
        this.reservationID = reservationID;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public String getGuestID() {
        return guestID;
    }

    public void setGuestID(String guestID) {
        this.guestID = guestID;
    }
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }
    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
}
