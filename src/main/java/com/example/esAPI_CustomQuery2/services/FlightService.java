package com.example.esAPI_CustomQuery2.services;
import com.example.esAPI_CustomQuery2.entities.Flight;
import com.example.esAPI_CustomQuery2.enums.FlightStatusEnum;
import com.example.esAPI_CustomQuery2.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    private String randomString(){
        Random random = new Random();
        IntStream ints = random.ints(3);
        int[] arrInt = ints.toArray();
        String randomString = "";
        for (int i : arrInt){
            randomString = randomString + i;
        }
        return randomString;
    }

    private Integer randomStatus() {
        Random random = new Random();
        int index = random.nextInt(3); // tra 0 e 2 compresi
        FlightStatusEnum[] statuses = FlightStatusEnum.values();
        return statuses[index].getId();
    }

    public List<Flight> createRandoms(Integer number) {
        List<Flight> flights = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Flight flight = new Flight();
            flight.setDescription(randomString());
            flight.setFromAirport(randomString());
            flight.setToAirport(randomString());
            flight.setStatusEnumId(randomStatus());

            flights.add(flight);
        }
        List<Flight> responseFlights = flightRepository.saveAll(flights);
        return responseFlights;
    }

    public Page<Flight> readAll(Integer page, Integer size) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.ASC, "fromAirport"));
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Flight> flights = flightRepository.findAll(pageable);
        return flights;
    }

    public List<Flight> readOnTime() {
        List<Flight> flights = flightRepository.findAll();
        List<Flight> responseFlights = new ArrayList<>();
        for (Flight flightCheck : flights){
            if (flightCheck.getStatusEnumId().equals(FlightStatusEnum.ONTIME.getId())){
                responseFlights.add(flightCheck);
            }
        }
        return responseFlights;
    }

    public List<Flight> readTwoStatus(Integer p1, Integer p2){
        List<Flight> flights = flightRepository.findTwoStatus(p1, p2);
        return flights;
    }
}