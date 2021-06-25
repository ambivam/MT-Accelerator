package com.accelerator.spring.automationaccelerator.visa;

import com.accelerator.spring.automationaccelerator.SpringBaseTestNGTest;
import com.accelerator.spring.automationaccelerator.entity.User;
import com.accelerator.spring.automationaccelerator.page.visa.VisaRegistrationPage;
import com.accelerator.spring.automationaccelerator.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Date;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserVisaTest extends SpringBaseTestNGTest {

    private static final Logger logger = LoggerFactory.getLogger(UserVisaTest.class);


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

        logger.info("Request Confirmation # INFO : "+this.registrationPage.getConfirmationNumber());
        logger.warn("Request Confirmation # WARN : "+this.registrationPage.getConfirmationNumber());


        /*System.out.println(
                this.registrationPage.getConfirmationNumber()
        );*/
    }

    @DataProvider
    public Object[] getData(ITestContext context){
        return this.repository.findByDobBetween(
                Date.valueOf(context.getCurrentXmlTest().getParameter("dobFrom")),
                Date.valueOf(context.getCurrentXmlTest().getParameter("dobTo")))
                .stream()
                .limit(3)
                .toArray();
    }

}
