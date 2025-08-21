package com.socialissuemanagement.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.socialissuemanagement.demo.entities.ZoneOperator;
import com.socialissuemanagement.demo.service.ZoneOperatorService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/operators")
public class ZoneOperatorController {

    @Autowired
    private ZoneOperatorService zoneOperatorService;

    @PostMapping
    public ZoneOperator createZoneOperator(@RequestBody ZoneOperator operator) {
        return zoneOperatorService.createZoneOperator(operator);
    }

    @GetMapping
    public List<ZoneOperator> getAllZoneOperators() {
        return zoneOperatorService.getAllZoneOperators();
    }

    @GetMapping("/{id}")
    public ZoneOperator getZoneOperatorById(@PathVariable Integer id) {
        return zoneOperatorService.getZoneOperatorById(id);
    }

    @PutMapping("/{id}")
    public ZoneOperator updateZoneOperator(@PathVariable Integer id, @RequestBody ZoneOperator operator) {
        return zoneOperatorService.updateZoneOperator(id, operator);
    }

    @DeleteMapping("/{id}")
    public void deleteZoneOperator(@PathVariable Integer id) {
        zoneOperatorService.deleteZoneOperator(id);
    }
}
