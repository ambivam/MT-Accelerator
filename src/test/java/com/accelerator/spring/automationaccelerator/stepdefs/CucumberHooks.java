package com.accelerator.spring.automationaccelerator.stepdefs;

import com.accelerator.spring.automationaccelerator.mouri.annotations.LazyAutowired;
import com.accelerator.spring.automationaccelerator.mouri.service.ScreenshotService;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class CucumberHooks {
    @LazyAutowired
    private ScreenshotService screenshotService;

    @AfterStep
    public void afterStep(Scenario scenario){
        if(scenario.isFailed()){
            scenario.embed(this.screenshotService.getScreenshot(),"image/png",scenario.getName());
        }
    }

}
