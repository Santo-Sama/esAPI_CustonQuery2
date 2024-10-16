package com.example.esAPI_CustomQuery2.controllers;

import com.example.esAPI_CustomQuery2.entities.Flight;
import com.example.esAPI_CustomQuery2.enums.FlightStatusEnum;
import com.example.esAPI_CustomQuery2.services.FlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/randoms")
    public ResponseEntity<List<Flight>> createRandoms(@RequestParam(required = false, defaultValue = "100") Integer n) {
        List<Flight> responseFlights = flightService.createRandoms(n);
        return ResponseEntity.ok().body(responseFlights);
    }

    @GetMapping("/read")
    public Page<Flight> readAll(@RequestParam(required = false, defaultValue = "0") Integer page,
                                @RequestParam(required = false, defaultValue = "100") Integer size) {
        Page<Flight> responseFlights = flightService.readAll(page, size);
        return responseFlights;
    }

    @GetMapping("/on-time")
    public ResponseEntity<List<Flight>> readOnTime() {
        List<Flight> flights = flightService.readOnTime();
        return ResponseEntity.ok().body(flights);
    }

    @GetMapping("/two-status")
    public ResponseEntity<List<Flight>> readTwoStatus(@RequestParam Integer p1, @RequestParam Integer p2){
        List<Flight> flights = flightService.readTwoStatus(p1, p2);
        return ResponseEntity.ok().body(flights);
    }
}
