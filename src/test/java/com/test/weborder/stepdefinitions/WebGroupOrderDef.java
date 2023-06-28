package com.test.weborder.stepdefinitions;

import com.test.weborder.pages.FoodOrderPage;
import com.test.weborder.pages.WeborderLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class WebGroupOrderDef {
    WebDriver driver = DriverHelper.getDriver();
    FoodOrderPage foodOrderPage = new FoodOrderPage(driver);
    WeborderLoginPage weborderLoginPage = new WeborderLoginPage(driver);
    @Given("User provides username and password for successful login")
    public void user_provides_username_and_password_for_successful_login() {
       weborderLoginPage.loginFunctionality(ConfigReader.readProperty("QA_weborder_username"),
                                            ConfigReader.readProperty("QA_weborder_password"));
    }
    @When("User clicks GroupOrderBox,clicks NextButton")
    public void user_clicks_group_order_box_clicks_next_button() {
        foodOrderPage.clickGrouOrderButton();
        foodOrderPage.clickNextButton();
    }
    @When("User provides note {string} to invitees box")
    public void user_provides_note_to_invitees_box(String message) {
        foodOrderPage.sendMessage(message);
    }
    @When("User provides gmail {string},{string} to invite list")
    public void user_provides_gmail_to_invite_list(String email1, String email2) {

       foodOrderPage.sendEmails(email1, email2);
    }
    @When("User chooses the location {string} and validates address {string}")
    public void user_chooses_the_location_and_validates_address(String expectedLocation, String expectedAddress) throws InterruptedException {
         foodOrderPage.chooseLocationAndValidateAddress(expectedLocation,expectedAddress);
    }
    @When("User clicks Create Group Order Button")
    public void user_clicks_create_group_order_button() throws InterruptedException {
       foodOrderPage.clickCreateGroupOrderButton();
    }
    @Then("User validates the {string} and {string} from description")
    public void user_validates_the_and_from_description(String string, String string2) {

    }

}

