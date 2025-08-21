//package com.socialissuemanagement.demo.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.socialissuemanagement.demo.entities.Role;
//import com.socialissuemanagement.demo.entities.User;
//import com.socialissuemanagement.demo.repository.RoleRepository;
//import com.socialissuemanagement.demo.repository.UserRepository;
//
//import java.util.List;
//
//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//    
//  @Autowired
//  private RoleRepository roleRepository;
//  
//  public User createUser(User user) {
//	    Role defaultRole = roleRepository.findById(1).orElse(null);
//	    if (defaultRole != null) {
//	        user.setRole(defaultRole);
//	    } else {
//	        throw new RuntimeException("Default role not found with ID 1");
//	    }
//	    return userRepository.save(user);
//	}
//
////    public User createUser(User user) {
////        return userRepository.save(user);
////    }
//
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    public User getUserById(Integer id) {
//        return userRepository.findById(id).orElse(null);
//    }
//
//    public User updateUser(Integer id, User updatedUser) {
//        User user = getUserById(id);
//        if (user != null) {
//            user.setUname(updatedUser.getUname());
//            user.setPassword(updatedUser.getPassword());
//            user.setRole(updatedUser.getRole());
//            user.setPhoneNo(updatedUser.getPhoneNo());
//            user.setEmail(updatedUser.getEmail());
//            user.setStatus(updatedUser.getStatus());
//            return userRepository.save(user);
//        }
//        return null;
//    }
//
//    public void deleteUser(Integer id) {
//        userRepository.deleteById(id);
//    }
//    
//    public User getUser(String email, String password) {
//    	return userRepository.findByEmailPwd(email, password);
//    }
//    
//    
//}
//
//
//
////@Autowired
////private RoleRepository roleRepository; // Make sure this is added
////
//
//




package com.example.SecondService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SecondService.entities.Role;
import com.example.SecondService.entities.User;
import com.example.SecondService.repositories.RoleRepository;
import com.example.SecondService.repositories.UserRepository;

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

