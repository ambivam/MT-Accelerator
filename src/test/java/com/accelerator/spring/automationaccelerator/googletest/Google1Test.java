package com.accelerator.spring.automationaccelerator.googletest;

import com.accelerator.spring.automationaccelerator.SpringBaseTestNGTest;
import com.accelerator.spring.automationaccelerator.mouri.annotations.LazyAutowired;
import com.accelerator.spring.automationaccelerator.page.google.GooglePage;
import com.accelerator.spring.automationaccelerator.mouri.service.ScreenshotService;
import com.accelerator.spring.automationaccelerator.visa.UserVisaTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Google1Test extends SpringBaseTestNGTest {

    private static final Logger logger = LoggerFactory.getLogger(Google1Test.class);

    @LazyAutowired
    private GooglePage googlePage;

    @LazyAutowired
    private ScreenshotService screenshotService;


    @Test
    public void googleTest() throws IOException {
        logger.info("Executing Google1Test");
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());


        this.googlePage.getSearchComponent().search("spring boot");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
        this.screenshotService.takeScreenShot();
        this.googlePage.close();
        //this.screenshotService.takeScreenShot("temp.png");

    }

}
