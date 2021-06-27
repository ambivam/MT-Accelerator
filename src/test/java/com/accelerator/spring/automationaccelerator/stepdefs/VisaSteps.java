package com.accelerator.spring.automationaccelerator.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VisaSteps {
    @Given("I am on VISA registration form")
    public void iAmOnVISARegistrationForm() {
    }

    @When("I select my from country {string} and to country {string}")
    public void iSelectMyFromCountryAndToCountry(String arg0, String arg1) {
    }

    @And("I enter my dob as {string}")
    public void iEnterMyDobAs(String arg0) {
    }

    @And("I enter my name as {string} and {string}")
    public void iEnterMyNameAsAnd(String arg0, String arg1) {
    }

    @And("I enter my contact details as {string} and {string}")
    public void iEnterMyContactDetailsAsAnd(String arg0, String arg1) {
    }

    @And("I enter the comments {string}")
    public void iEnterTheComments(String arg0) {
    }

    @And("I submit the form")
    public void iSubmitTheForm() {
    }

    @Then("I should see get the confirmation number")
    public void iShouldSeeGetTheConfirmationNumber() {
    }
}
