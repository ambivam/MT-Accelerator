package com.accelerator.spring.automationaccelerator;

import com.accelerator.spring.automationaccelerator.SpringBaseTestNGTest;
import com.accelerator.spring.automationaccelerator.entity.User;
import com.accelerator.spring.automationaccelerator.page.visa.VisaRegistrationPage;
import com.accelerator.spring.automationaccelerator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Date;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserVisaTest extends SpringBaseTestNGTest {

    @Autowired
    private VisaRegistrationPage registrationPage;

    @Autowired
    private UserRepository repository;

    @Test(dataProvider = "getData")
    public void VisaTest(User u){
        this.registrationPage.goTo();
        this.registrationPage.setNames(u.getFirstName(),u.getLastName());
        this.registrationPage.setCountryFromAndTo(u.getFromCountry(),u.getToCountry());
        this.registrationPage.setBirthDate(u.getDob().toInstant()
                                .atZone(ZoneId.systemDefault())
                                .toLocalDate());

        this.registrationPage.setContactDetails(u.getEmail(),u.getPhone());
        this.registrationPage.setComments(u.getComments());
        this.registrationPage.submit();
        System.out.println(
                this.registrationPage.getConfirmationNumber()
        );
    }

    @DataProvider
    public Object[] getData(){
        return this.repository.findByDobBetween(Date.valueOf("1995-01-01"),Date.valueOf("1999-01-01"))
                .stream()
                .limit(3)
                .toArray();
    }

}
