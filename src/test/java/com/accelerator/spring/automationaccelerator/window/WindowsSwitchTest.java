package com.accelerator.spring.automationaccelerator.window;

import com.accelerator.spring.automationaccelerator.SpringBaseTestNGTest;
import com.accelerator.spring.automationaccelerator.mouri.service.WindowSwitchService;
import com.accelerator.spring.automationaccelerator.page.window.MainPage;
import com.accelerator.spring.automationaccelerator.page.window.PageA;
import com.accelerator.spring.automationaccelerator.page.window.PageB;
import com.accelerator.spring.automationaccelerator.page.window.PageC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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
    private PageC pageC;

    @Autowired
    private WindowSwitchService switchService;

    @BeforeClass
    public void setUp(){
        this.mainPage.goTo();
        this.mainPage.isAt();
        this.mainPage.launchAllWindows();
    }

    @Test(dataProvider = "getData")
    public void switchTest(int index)  {
        /*this.switchService.switchByTitle("Page A");
        this.pageA.addToArea("hi Page A");
        this.switchService.switchByIndex(2);
        this.pageB.addToArea("hello page B");*/

        this.pageA.addToArea(index + "\n");
        this.pageB.addToArea((index*2) + "\n");
        this.pageC.addToArea((index*3) + "\n");
    }

    @DataProvider
    public Object[] getData(){
        return new Object[]{
                3,
                4,
                1,
                5,
                6,
                2
        };

        }

}


