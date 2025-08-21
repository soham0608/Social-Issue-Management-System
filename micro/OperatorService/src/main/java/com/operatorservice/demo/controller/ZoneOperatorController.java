package com.operatorservice.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.operatorservice.demo.entity.ZoneOperator;
import com.operatorservice.demo.service.ZoneOperatorService;

import java.util.List;


@RestController
@RequestMapping("/api/operator")
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
