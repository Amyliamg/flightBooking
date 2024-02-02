package com.example.flightbooking.controllers;

import com.example.flightbooking.entities.Flight;
import com.example.flightbooking.repos.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

@EnableCaching
@Controller
public class FlightController {
    @Autowired
    private FlightRepository flightRepository;

    @RequestMapping(value = "findFlights", method = RequestMethod.POST)
    public String findFlights(
            @RequestParam("from") String from,
            @RequestParam("to") String to,
            @RequestParam("departureDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date departureDate,
            ModelMap modelMap
    ) {

        List<Flight> flights = flightRepository.findFlights(from, to, departureDate);
        modelMap.addAttribute("flights", flights);
        return "displayFlights";
    }
}
