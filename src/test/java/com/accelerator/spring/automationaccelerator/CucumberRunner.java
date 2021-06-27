package com.accelerator.spring.automationaccelerator;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features",
        glue = "com.accelerator.spring.automationaccelerator.stepdefs",
        plugin = {
                "pretty",
                "html:D:\\MT-Accelerator\\temp\\"
        }
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

}
