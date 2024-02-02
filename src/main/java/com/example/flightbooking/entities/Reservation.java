package com.example.flightbooking.entities;


import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation extends AbstractEntity{
    @OneToOne
    private Flight flight;

    @OneToOne
    private Passenger passenger;

    private Boolean checkedIn;


    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Boolean getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(Boolean checkedIn) {
        this.checkedIn = checkedIn;
    }


}