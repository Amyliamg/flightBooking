package com.example.flightbooking.controllers;


import com.example.flightbooking.Dto.ReservationRequest;
import com.example.flightbooking.entities.Flight;
import com.example.flightbooking.entities.Passenger;
import com.example.flightbooking.entities.Reservation;
import com.example.flightbooking.repos.FlightRepository;
import com.example.flightbooking.repos.PassengerRepository;
import com.example.flightbooking.repos.ReservationRepository;
import com.example.flightbooking.util.EmailUtil;
import com.example.flightbooking.util.PDFGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;

@Controller
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private FlightRepository flightRepository; // need flight information, so I need to use the corresponding repository

    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    private PDFGenerator pdfGenerator;

    @RequestMapping("showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
        Flight flight = flightRepository.findById(flightId).orElse(null);
        modelMap.addAttribute("flight", flight);
        return "completeReservation";
    }



    @RequestMapping(value = "completeReservation", method = RequestMethod.POST)
    public String completeReservation(ReservationRequest request, ModelMap modelMap) {
        Long flightId = request.getFlightId();
        Flight flight = flightRepository.findById(flightId).orElse(null);

        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setPhone(request.getPassengerPhone());
        passenger.setEmail(request.getPassengerEmail());

        passengerRepository.save(passenger); // since reservation has two foreign keys, passenger and flights, we need to store both of the entity first in order to let the reservation know how to connect

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(passenger);
        reservation.setCheckedIn(false);

        reservationRepository.save(reservation);
        String msg = "Reservation " + reservation.getId() + " is confirmed. " +
                "Please check in your flight in advance to save some time on your travel date.";
        modelMap.addAttribute("msg", msg);
        // Generate itinerary and send a confirmation email
        String cwd = System.getProperty("user.dir"); // in the root create a pdf.    .getProperty("user.dir") = get current work directory
        String filePath = cwd + "/reservation.pdf";
        pdfGenerator.generatePDF(reservation, filePath);
        emailUtil.sendEmail(passenger.getEmail(), "Flight Booked!", msg, filePath);

        // Remove the temporary pdf file after we sending to the user
        File pdfFile = new File(filePath);
        pdfFile.delete();


        return "reservationConfirmation";
    }

/*
Ways to pass the data from html to backend (store in database):
1. pass information as url parameter
- grab by @RequestParam("flightId")  or @Re
2. use the existed entity
- grab by @ModelAttribute("user") User user
3. create a Dto (data transfer object)
-

*/

}
