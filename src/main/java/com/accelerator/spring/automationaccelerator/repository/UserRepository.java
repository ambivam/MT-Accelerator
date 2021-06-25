package com.accelerator.spring.automationaccelerator.repository;

import com.accelerator.spring.automationaccelerator.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findByFirstNameStartingWith(String startsWith);

}
