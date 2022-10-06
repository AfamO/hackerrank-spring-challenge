package com.hackerrank.sample.repository;

import com.hackerrank.sample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findByFirstName(String firstName);
    public User findByPhoneNumber(String phoneNumber);

}
