package com.accelerator.spring.automationaccelerator.resource;


import com.accelerator.spring.automationaccelerator.SpringBaseTestNGTest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;

public class ResourceTest extends SpringBaseTestNGTest {

    @Value("classpath:data/testdata.csv")
    private Resource resource;



    @Value("file:D:\\MT-Accelerator\\src\\test\\resources\\data\\testdata.csv")
    private Resource resourceExternal;

    //To read file from classpath
    @Test
    public void resourceTest() throws IOException {
        Files.readAllLines(resource.getFile().toPath()).forEach(System.out::println);
    }

    //To read file from external path
    @Test
    public void resourceExternalFileTest() throws IOException {
        Files.readAllLines(resourceExternal.getFile().toPath()).forEach(System.out::println);
    }



}
