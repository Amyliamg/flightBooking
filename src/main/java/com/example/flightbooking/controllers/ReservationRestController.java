package com.example.flightbooking.controllers;

import com.example.flightbooking.Dto.ReservationRequest;
import com.example.flightbooking.Dto.ReservationUpdateRequest;
import com.example.flightbooking.entities.Reservation;
import com.example.flightbooking.repos.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOriginv
// allow people with different request or port to use this API
public class ReservationRestController {
    @Autowired
    private ReservationRepository reservationRepository;

    @RequestMapping("/reservations/{id}") // this api could be used by other services
    public Reservation findReservation(@PathVariable Long id) {
        return reservationRepository.findById(id).orElse(null); // return is JSON
    }

    @RequestMapping("/reservations")
    public Reservation updateReservationRequest(@RequestBody ReservationUpdateRequest request) {
        Reservation reservation = reservationRepository.findById(request.getId()).orElse(null);
        if (reservation == null) {
            return null;
        }

        reservation.setCheckedIn(request.isCheckedIn());
        return reservationRepository.save(reservation);
    }

}