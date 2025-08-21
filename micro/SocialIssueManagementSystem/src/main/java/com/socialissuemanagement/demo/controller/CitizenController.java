package com.socialissuemanagement.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.socialissuemanagement.demo.entities.Citizen;
import com.socialissuemanagement.demo.service.CitizenService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/citizens")
public class CitizenController {

    @Autowired
    private CitizenService citizenService;

    @PostMapping
    public Citizen createCitizen(@RequestBody Citizen citizen) {
        return citizenService.createCitizen(citizen);
    }

    @GetMapping
    public List<Citizen> getAllCitizens() {
        return citizenService.getAllCitizens();
    }

    @GetMapping("/{id}")
    public Citizen getCitizenById(@PathVariable Integer id) {
        return citizenService.getCitizenById(id);
    }

    @PutMapping("/{id}")
    public Citizen updateCitizen(@PathVariable Integer id, @RequestBody Citizen citizen) {
        return citizenService.updateCitizen(id, citizen);
    }

    @DeleteMapping("/{id}")
    public void deleteCitizen(@PathVariable Integer id) {
        citizenService.deleteCitizen(id);
    }
}
