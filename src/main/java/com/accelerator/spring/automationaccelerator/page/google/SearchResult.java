package com.accelerator.spring.automationaccelerator.page.google;

import com.accelerator.spring.automationaccelerator.annotations.PageFragment;
import com.accelerator.spring.automationaccelerator.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class SearchResult extends Base {

    //@FindBy(css = "div.rc")
    @FindBy(css = "div.g" )
    private List<WebElement> results;

    public int getCount(){
        return this.results.size();
    }

    @Override
    public boolean isAt(){
        return this.wait.until((d) -> !this.results.isEmpty());
    }

}
