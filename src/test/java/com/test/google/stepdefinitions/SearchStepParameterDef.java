package com.test.google.stepdefinitions;

import com.test.google.pages.GoogleMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class SearchStepParameterDef {
    WebDriver driver = DriverHelper.getDriver();
    GoogleMainPage googleMainPage = new GoogleMainPage(driver);

    @Given("User navigate to the {string}")
    public void user_navigate_to_the(String website) {
        driver.get(website);
    }

    @When("User searches for {string}")
    public void user_searches_for(String searchItem) {
        googleMainPage.searchItem(searchItem);

    }

    @Then("User validates first page returns more than {int} Links")
    public void user_validates_first_page_returns_more_than_links(Integer expectedLink) throws InterruptedException {
        Assert.assertTrue(googleMainPage.linkCount(expectedLink));

    }

    @Then("User validates the result is less than {int}")
    public void user_validates_the_result_is_less_than(Integer expectedResult) {
        Assert.assertTrue(googleMainPage.ResultFromSearch(expectedResult));

    }

    @Then("User validates it loads less than {double}")
    public void user_validates_it_loads_less_than(Double expectedTime) {
        Assert.assertTrue(googleMainPage.searchResultLoadingSpeed(expectedTime));










    }

}
