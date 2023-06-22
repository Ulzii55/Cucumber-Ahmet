package com.test.weborder.stepdefinitions;

import com.test.weborder.pages.WeborderLoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class WeborderLoginStepDef {
    WebDriver driver= DriverHelper.getDriver();
    WeborderLoginPage weborderLoginPage =new WeborderLoginPage(driver);
    @When("User provides {string},{string} and click Login button")
    public void user_provides_and_click_login_button(String username, String password) {
       weborderLoginPage.loginFunctionality(username,password);
    }
    @Then("User validates the {string}")
    public void user_validates_the(String expectedTitle) {
        Assert.assertEquals(expectedTitle,driver.getTitle().trim());
    }
    @Then("User validates the message {string}")
    public void user_validates_the_message(String expectedMessage) {
       Assert.assertEquals(expectedMessage, weborderLoginPage.errorMessage());
    }

}
















