package com.accelerator.spring.automationaccelerator.page.google;

import com.accelerator.spring.automationaccelerator.mouri.annotations.PageFragment;
import com.accelerator.spring.automationaccelerator.page.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class SearchComponent extends Base {

    @FindBy(name="q")
    private WebElement searchBox;

    @FindBy(name="btnk")
    private List<WebElement> searchBtns;

    public void search(final String keyword){
        this.searchBox.sendKeys(keyword);
        this.searchBox.sendKeys(Keys.ENTER);

        /*this.searchBox.sendKeys(Keys.TAB);

        System.out.println(this.searchBtns.size());
        this.searchBtns
                .stream()
                .filter(e -> e.isDisplayed() && e.isEnabled())
                .findFirst()
                .ifPresent((e) -> e.click());*/
    }

    @Override
    public boolean isAt(){
        return this.wait.until((d) -> this.searchBox.isDisplayed());
    }
}
