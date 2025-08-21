package com.socialissuemanagement.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.socialissuemanagement.demo.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    @Query("select u from User u where u.email = ?1 and u.password = ?2")
    User findByUnameAndPassword(String email, String password);
}








//public interface UserRepository extends JpaRepository<User, Integer> {
//
//    Optional<User> findByEmail(String email);
//
////    @Query("select u from User u where u.email = ?1 and u.password = ?2")
////    User findByEmailPwd(String email, String password);
//    
//    @Query("select u from User u where u.email = ?1 and u.password = ?2")
//    User findByEmailPwd(String email, String password);
//    
//}
