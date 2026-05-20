package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
@CrossOrigin("*")
public class FlightController {

    @Autowired
    private FlightRepository repository;

    @GetMapping
    public List<Flight> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Flight add(@RequestBody Flight flight) {
        return repository.save(flight);
    }
}