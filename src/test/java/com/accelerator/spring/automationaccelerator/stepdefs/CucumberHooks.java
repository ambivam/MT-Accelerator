package com.accelerator.spring.automationaccelerator.stepdefs;

import com.accelerator.spring.automationaccelerator.mouri.annotations.LazyAutowired;
import com.accelerator.spring.automationaccelerator.mouri.service.ScreenshotService;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

public class CucumberHooks {
    @LazyAutowired
    private ScreenshotService screenshotService;

    @LazyAutowired
    private ApplicationContext ctx;

    @AfterStep
    public void afterStep(Scenario scenario){
        if(scenario.isFailed()){
            scenario.embed(this.screenshotService.getScreenshot(),"image/png",scenario.getName());
        }
    }

    @After
    public void afterScenario(){
        this.ctx.getBean(WebDriver.class).quit();
    }

}
