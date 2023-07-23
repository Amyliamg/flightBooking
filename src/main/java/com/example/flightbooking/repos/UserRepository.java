package com.example.flightbooking.repos;

import com.example.flightbooking.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Spring Data JPA will generate the query for us for free
    // if we follow their naming convention
    User findByEmail(String email); // extra functions, user could find their account by email
}