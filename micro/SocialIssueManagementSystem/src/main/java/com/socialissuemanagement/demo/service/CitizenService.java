package com.socialissuemanagement.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialissuemanagement.demo.entities.Citizen;
import com.socialissuemanagement.demo.entities.User;
import com.socialissuemanagement.demo.repository.CitizenRepository;
import com.socialissuemanagement.demo.repository.UserRepository;

import java.util.List;

@Service
public class CitizenService {

    @Autowired
    private CitizenRepository citizenRepository;

    @Autowired
    private UserRepository userRepository; // Correctly injected

    public Citizen createCitizen(Citizen citizen) {
        // Ensure user exists before assigning
        Integer uid = citizen.getUser().getUid();
        User user = userRepository.findById(uid)
                .orElseThrow(() -> new RuntimeException("User with uid " + uid + " not found"));
        citizen.setUser(user);

        return citizenRepository.save(citizen);
    }

    public List<Citizen> getAllCitizens() {
        return citizenRepository.findAll();
    }

    public Citizen getCitizenById(Integer id) {
        return citizenRepository.findById(id).orElse(null);
    }

    public Citizen updateCitizen(Integer id, Citizen updatedCitizen) {
        Citizen existingCitizen = citizenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Citizen not found with id " + id));

        // Validate and attach User
        Integer uid = updatedCitizen.getUser().getUid();
        User user = userRepository.findById(uid)
                .orElseThrow(() -> new RuntimeException("User with uid " + uid + " not found"));
        existingCitizen.setUser(user);

        // Update other fields
        existingCitizen.setFname(updatedCitizen.getFname());
        existingCitizen.setLname(updatedCitizen.getLname());
        existingCitizen.setAddress(updatedCitizen.getAddress());
        existingCitizen.setArea(updatedCitizen.getArea());
        existingCitizen.setGender(updatedCitizen.getGender());
        existingCitizen.setDob(updatedCitizen.getDob());
        existingCitizen.setAadharNo(updatedCitizen.getAadharNo());

        return citizenRepository.save(existingCitizen);
    }

    public void deleteCitizen(Integer id) {
        citizenRepository.deleteById(id);
    }
    
    public Citizen getCitizen(User user) {
    	return citizenRepository.getCitizen(user);
    }
}
