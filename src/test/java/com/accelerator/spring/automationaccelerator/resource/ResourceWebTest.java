package com.accelerator.spring.automationaccelerator.resource;

import com.accelerator.spring.automationaccelerator.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResourceWebTest extends SpringBaseTestNGTest {

    @Value("https://www.google.com")
    private Resource resourceWeb;

    @Value("${screenshot.path}/some.txt")
    private Path path;

    //To read info from URL
    @Test
    public void resourceWebTest() throws IOException {
        System.out.println(resourceWeb.getInputStream().read());
    }

    //Downloading Files
    @Test
    public void resourceDownloadTest() throws IOException{
        FileCopyUtils.copy(resourceWeb.getInputStream(), Files.newOutputStream(path));
    }


}
