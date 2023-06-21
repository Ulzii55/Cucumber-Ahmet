package com.test.google.stepdefinitions;

import com.test.google.pages.GoogleMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class SearchStepDef {
    WebDriver driver= DriverHelper.getDriver();
    GoogleMainPage googleMainPage=new GoogleMainPage(driver);

    @Given("User navigate to the google")
    public void user_navigate_to_the_google() {
        driver.get("https://www.google.com/");
    }
    @When("User searches for CodeFish")
    public void user_searches_for_code_fish() {
      googleMainPage.searchItem("CodeFish");

    }
    @Then("User validates first page returns more than ten Links")
    public void user_validates_first_page_returns_more_than_ten_links() {
        Assert.assertTrue(googleMainPage.linkCount(10));

    }

    @When("User searches for Kyrgyz Food in USA")
    public void user_searches_for_kyrgyz_food_in_usa() {
       googleMainPage.searchItem("Kyrgyz Food In USA");
    }
    @Then("User validates the result is less than three hundred million")
    public void user_validates_the_result_is_less_than_three_hundred_million() {
         Assert.assertTrue(googleMainPage.ResultFromSearch(300000000));
    }
    @When("User searches for Turkish Baklava")
    public void user_searches_for_turkish_baklava() {
       googleMainPage.searchItem("Turkish Baklava");
    }
    @Then("User validates it loads less than one seconds")
    public void user_validates_it_loads_less_than_one_seconds() {
      googleMainPage.searchResultLoadingSpeed(1.0);
    }

}
