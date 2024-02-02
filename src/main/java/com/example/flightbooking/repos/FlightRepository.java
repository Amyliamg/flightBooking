package com.example.flightbooking.repos;

import com.example.flightbooking.entities.Flight;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Cacheable("flights")
    @Query("from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")
    List<Flight> findFlights(

            @Param("departureCity") String from,
            @Param("arrivalCity") String to,
            @Param("dateOfDeparture") Date departureDate
    );
}