package com.example.flightbooking.entities;

import com.example.flightbooking.entities.AbstractEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "FLIGHT")  // which table it points to
public class Flight extends AbstractEntity {
    //@Column(name = "FLIGHT_NUMBER") if can not find the flight number in the dataset
    private String flightNumber; // camo case, but in the sql, we will use the snake case
    private String operatingAirlines;
    private String departureCity;
    private String arrivalCity;
    private Timestamp estimatedDepartureTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd") //format the data
    @Temporal(TemporalType.DATE) // 我只对template里面的date 感兴趣
    private Date dateOfDeparture;

    // comment + n 自动生成getter and setter


    public String getFlightNumber() { //只读
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) { //只写，对外不透明的
        this.flightNumber = flightNumber;
    }

    public String getOperatingAirlines() {
        return operatingAirlines;
    }

    public void setOperatingAirlines(String operatingAirlines) {
        this.operatingAirlines = operatingAirlines;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public Timestamp getEstimatedDepartureTime() {
        return estimatedDepartureTime;
    }

    public void setEstimatedDepartureTime(Timestamp estimatedDepartureTime) {
        this.estimatedDepartureTime = estimatedDepartureTime;
    }

    public Date getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(Date dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }
}