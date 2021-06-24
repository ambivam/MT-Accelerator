package com.accelerator.spring.automationaccelerator.page.window;

import com.accelerator.spring.automationaccelerator.mouri.annotations.Page;
import com.accelerator.spring.automationaccelerator.mouri.annotations.Window;
import com.accelerator.spring.automationaccelerator.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Window("Page C")
public class PageC extends Base {

    @FindBy(id = "area")
    private WebElement textArea;

    public void addToArea(final String msg){
        this.textArea.sendKeys(msg);
    }

    @Override
    public boolean isAt(){
        return this.wait.until((d) -> this.textArea.isDisplayed());
    }

}

