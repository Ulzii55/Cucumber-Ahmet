package com.test.weborder.stepdefinitions;

import com.test.weborder.pages.FoodOrderPage;
import com.test.weborder.pages.WeborderLoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class WebGroupOrderDef {
    WebDriver driver = DriverHelper.getDriver();
    FoodOrderPage foodOrderPage = new FoodOrderPage(driver);
    WeborderLoginPage weborderLoginPage = new WeborderLoginPage(driver);

    @When("User provides {string},{string}, and clicks Sign in Button")
    public void user_provides_and_clicks_sign_in_button(String email, String password) throws InterruptedException {
       weborderLoginPage.loginFunctionality(email, password);

    }
    @Then("User clicks GroupOrderBox,clicks NextButton")
    public void user_clicks_group_order_box_clicks_next_button() throws InterruptedException {
        foodOrderPage.createGroupOrder();

    }
    @Then("User provides InviteNote {string}, InviteEmails {string},{string}")
    public void user_provides_invite_note_invite_emails(String note, String email1, String email2) throws InterruptedException {
        foodOrderPage.inputNoteAndEmails(note,email1,email2);
    }
    @Then("User Selects delivery {string} and validates address {string}")
    public void user_selects_delivery_and_validates_address( String expectedAddress) throws InterruptedException {
        Assert.assertTrue(expectedAddress, foodOrderPage.validateHouseAddress(expectedAddress));
    }
    @Then("User clicks GroupOrderButton, validates Header {string}, Order Info Contains {string}")
    public void user_clicks_group_order_button_validates_header_order_info_contains(String expectedHeader, String expectedDescription) throws InterruptedException {
        foodOrderPage.validateHeader(expectedHeader,expectedDescription);
    }


}
