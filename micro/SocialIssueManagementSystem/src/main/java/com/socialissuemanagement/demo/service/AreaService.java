package com.socialissuemanagement.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialissuemanagement.demo.entities.Area;
import com.socialissuemanagement.demo.repository.AreaRepository;

import java.util.List;

@Service
public class AreaService {

    @Autowired
    private AreaRepository areaRepository;

    public Area createArea(Area area) {
        return areaRepository.save(area);
    }

    public List<Area> getAllAreas() {
        return areaRepository.findAll();
    }

    public Area getAreaById(Integer id) {
        return areaRepository.findById(id).orElse(null);
    }

    public Area updateArea(Integer id, Area updatedArea) {
        Area area = getAreaById(id);
        if (area != null) {
            area.setAreaName(updatedArea.getAreaName());
            area.setPincode(updatedArea.getPincode());
            return areaRepository.save(area);
        }
        return null;
    }

    public void deleteArea(Integer id) {
        areaRepository.deleteById(id);
    }
}
