package com.example.flightbooking.controllers;


import com.example.flightbooking.entities.Flight;
import com.example.flightbooking.repos.FlightRepository;
import com.example.flightbooking.repos.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private FlightRepository flightRepository; // need flight information, so I need to use the corresponding repository


    @RequestMapping("showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
        Flight flight = flightRepository.findById(flightId).orElse(null);
        modelMap.addAttribute("flight", flight);
        return "completeReservation";
    }


    @RequestMapping("completeReservation", method = RequestMethod.POST)
    public String completeReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
        Flight flight = flightRepository.findById(flightId).orElse(null);
        modelMap.addAttribute("flight", flight);
        return "happy";
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
