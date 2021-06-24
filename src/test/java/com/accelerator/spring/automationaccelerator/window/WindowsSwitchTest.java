package com.accelerator.spring.automationaccelerator.window;

import com.accelerator.spring.automationaccelerator.SpringBaseTestNGTest;
import com.accelerator.spring.automationaccelerator.mouri.service.WindowSwitchService;
import com.accelerator.spring.automationaccelerator.page.window.MainPage;
import com.accelerator.spring.automationaccelerator.page.window.PageA;
import com.accelerator.spring.automationaccelerator.page.window.PageB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@TestPropertySource(properties="browser=chrome")
public class WindowsSwitchTest extends SpringBaseTestNGTest {
    @Autowired
    private MainPage mainPage;

    @Autowired
    private PageA pageA;

    @Autowired
    private PageB pageB;

    @Autowired
    private WindowSwitchService switchService;

    @BeforeClass
    public void setUp(){
        this.mainPage.goTo();
        this.mainPage.isAt();
        this.mainPage.launchAllWindows();
    }

    @Test
    public void switchTest(){
        this.switchService.switchByTitle("Page A");
        this.pageA.addToArea("hi Page A");
        this.switchService.switchByIndex(2);
        this.pageA.addToArea("hello page B");
    }

}
