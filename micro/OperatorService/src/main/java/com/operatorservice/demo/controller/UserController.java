//package com.socialissuemanagement.demo.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.socialissuemanagement.demo.entities.LoginInfo;
//import com.socialissuemanagement.demo.entities.User;
//import com.socialissuemanagement.demo.repository.UserRepository;
//import com.socialissuemanagement.demo.service.UserService;
//
//import dao.LoginRequestDTO;
//import dao.LoginResponseDTO;
//
//import java.util.List;
//
//@CrossOrigin(origins = "http://localhost:3000")
//@RestController
//@RequestMapping("/api/users")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/register")
//    public User createUser(@RequestBody User user) {
//        return userService.createUser(user);
//    }
//
//    @GetMapping
//    public List<User> getAllUsers() {
//        return userService.getAllUsers();
//    }
//
//    @GetMapping("/{id}")
//    public User getUserById(@PathVariable Integer id) {
//        return userService.getUserById(id);
//    }
//
//    @PutMapping("/{id}")
//    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
//        return userService.updateUser(id, user);
//    }
//    
//    
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginDto) {
//        User user = UserRepository.findByUnameAndPassword(
//            loginDto.getUname(), loginDto.getPassword()
//        );
//
//        if (user != null) {
//            LoginResponseDTO responseDto = new LoginResponseDTO(
//                user.getUid(),
//                user.getUname(),
//                user.getRole().getRid()
//            );
//            return ResponseEntity.ok(responseDto);
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                    .body("Invalid username or password");
//        }
//    }
//
//
////    @PostMapping("/login")
////    public User checklogin(@RequestBody LoginInfo linfo) {
////    	return userService.getUser(linfo.getEmail(), linfo.getPassword());
////    	
////    }
//    
//
//    @DeleteMapping("/{id}")
//    public void deleteUser(@PathVariable Integer id) {
//        userService.deleteUser(id);
//    }
//}



package com.operatorservice.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.operatorservice.demo.entity.User;
import com.operatorservice.demo.service.UserService;
import com.operatorservice.demo.repository.UserRepository;

import java.util.List;


@RestController
@RequestMapping("/api/userz")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository; // <-- Inject repository properly

    @PostMapping("/register")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }
    
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}
