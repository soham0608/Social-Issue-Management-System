package com.operatorservice.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.operatorservice.demo.entity.Role;
import com.operatorservice.demo.entity.User;
import com.operatorservice.demo.repository.RoleRepository;
import com.operatorservice.demo.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    // Create user with default role (Citizen with rid = 1)
    public User createUser(User user) {
        if (user.getRole() == null) {
            Role defaultRole = roleRepository.findById(1).orElse(null);
            if (defaultRole != null) {
                user.setRole(defaultRole);
            } else {
                throw new RuntimeException("Default role not found with ID 1");
            }
        }
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(Integer id, User updatedUser) {
        User user = getUserById(id);
        if (user != null) {
            user.setUname(updatedUser.getUname());
            user.setPassword(updatedUser.getPassword());
            user.setRole(updatedUser.getRole());
            user.setPhoneNo(updatedUser.getPhoneNo());
            user.setEmail(updatedUser.getEmail());
            user.setStatus(updatedUser.getStatus());
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    //  Optional helper: get user by email and password
    public User getUser(String email, String password) {
        return userRepository.findByUnameAndPassword(email, password);
    }

    //  Optional helper: get user by uname and password (used in login)
    public User getUserByUnameAndPassword(String uname, String password) {
        return userRepository.findByUnameAndPassword(uname, password);
    }
}

