package com.accelerator.spring.automationaccelerator.props;

import com.accelerator.spring.automationaccelerator.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class PropsTest extends SpringBaseTestNGTest {

    @Autowired
    private ResourceLoader loader;

    @Test
    public void propsTest() throws IOException {
        Properties properties = PropertiesLoaderUtils.loadProperties(loader.getResource("my.properties"));
        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));
    }
}
