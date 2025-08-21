package com.operatorservice.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.operatorservice.demo.entity.ZoneOperator;
import com.operatorservice.demo.repository.ZoneOperatorRepository;

import java.util.List;

@Service
public class ZoneOperatorService {

    @Autowired
    private ZoneOperatorRepository zoneOperatorRepository;

    public ZoneOperator createZoneOperator(ZoneOperator zoneOperator) {
        return zoneOperatorRepository.save(zoneOperator);
    }

    public List<ZoneOperator> getAllZoneOperators() {
        return zoneOperatorRepository.findAll();
    }

    public ZoneOperator getZoneOperatorById(Integer id) {
        return zoneOperatorRepository.findById(id).orElse(null);
    }

    public ZoneOperator updateZoneOperator(Integer id, ZoneOperator updatedOperator) {
        ZoneOperator operator = getZoneOperatorById(id);
        if (operator != null) {
            operator.setUser(updatedOperator.getUser());
            operator.setDesignation(updatedOperator.getDesignation());
            operator.setArea(updatedOperator.getArea());
            operator.setJoinedDate(updatedOperator.getJoinedDate());
            return zoneOperatorRepository.save(operator);
        }
        return null;
    }

    public void deleteZoneOperator(Integer id) {
        zoneOperatorRepository.deleteById(id);
    }
}
