package com.accelerator.spring.automationaccelerator.mouri.aop;

import com.accelerator.spring.automationaccelerator.mouri.annotations.Window;
import com.accelerator.spring.automationaccelerator.mouri.service.WindowSwitchService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WindowAspect {

    @Autowired
    private WindowSwitchService switchService;

    @Before("@target(window) && within(com.accelerator.spring.automationaccelerator..*)")
    public void before(Window window) throws Throwable {
        this.switchService.switchByTitle(window.value());
    }

    @After("@target(window) && within(com.accelerator.spring.automationaccelerator..*)")
    public void after(Window window) throws Throwable {
        this.switchService.switchByIndex(0);
    }

}
