package com.accelerator.spring.automationaccelerator;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "classpath:features",
        glue = "com.accelerator.spring.automationaccelerator.stepdefs",
        plugin = {
                "pretty",
                "html:D:\\MT-Accelerator\\temp\\"
        }
)


public class CucumberRunner extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
