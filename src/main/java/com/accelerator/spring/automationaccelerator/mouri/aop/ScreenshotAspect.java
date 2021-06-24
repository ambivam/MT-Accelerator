package com.accelerator.spring.automationaccelerator.mouri.aop;

import com.accelerator.spring.automationaccelerator.mouri.annotations.TakeScreenshot;
import com.accelerator.spring.automationaccelerator.mouri.service.ScreenshotService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Aspect
@Component

public class ScreenshotAspect {

    @Autowired
    private ScreenshotService screenshotService;

    @After("@annotation(takeScreenshot)")
    public void after(TakeScreenshot takeScreenshot) throws IOException{
        this.screenshotService.takeScreenShot();
    }

}
