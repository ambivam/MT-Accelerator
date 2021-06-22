package com.accelerator.spring.automationaccelerator.page.flights;

import com.accelerator.spring.automationaccelerator.mouri.annotations.Page;
import com.accelerator.spring.automationaccelerator.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@Page
public class FlightPage extends Base {

    @FindBy(css = "span.thxQSb")
    private List<WebElement> elements;

    public void goTo(final String url){
        this.driver.get(url);
        this.driver.manage().window().maximize();
    }

    public List<String> getlabels(){
        return this.elements
                .stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> !this.elements.isEmpty());
    }


}
