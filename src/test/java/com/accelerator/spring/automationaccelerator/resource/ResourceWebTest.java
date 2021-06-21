package com.accelerator.spring.automationaccelerator.resource;

import com.accelerator.spring.automationaccelerator.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.testng.annotations.Test;

import java.io.IOException;

public class ResourceWebTest extends SpringBaseTestNGTest {

    @Value("https://www.google.com")
    private Resource resourceWeb;

    //To read info from URL
    @Test
    public void resourceWebTest() throws IOException {
        System.out.println(resourceWeb.getInputStream().read());
    }
}
