package com.accelerator.spring.automationaccelerator;

import com.accelerator.spring.automationaccelerator.SpringBaseTestNGTest;
import com.accelerator.spring.automationaccelerator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class UserVisaTest extends SpringBaseTestNGTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void VisaTest(){
        this.repository.findById(85)
                .ifPresent(u -> System.out.println(u.getFirstName()));
    }

}
