package com.accelerator.spring.automationaccelerator.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSteps {

    

    @Given("I am on the google site")
    public void launchSite() {
    }

    @When("I enter {string} as a keyword")
    public void enterKeyword(String keyword) {
    }

    @And("I click on the search button")
    public void clickSearch() {
    }

    @Then("I should see at least {int} results")
    public void verifyResult(int count) {
    }
}
