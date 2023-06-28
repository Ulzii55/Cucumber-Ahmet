package com.test.saucedemo.stepdefinitions;

import com.test.saucedemo.pages.SauceDemoCheckOutPage;
import com.test.saucedemo.pages.SauceDemoLoginPage;
import com.test.saucedemo.pages.SauceDemoProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class SauceDemoOrderCheckOutStepDef {
    WebDriver driver = DriverHelper.getDriver();
    SauceDemoLoginPage sauceDemoLoginPage = new SauceDemoLoginPage(driver);
    SauceDemoProductsPage sauceDemoProductsPage = new SauceDemoProductsPage(driver);
    SauceDemoCheckOutPage sauceDemoCheckOutPage = new SauceDemoCheckOutPage(driver);

    @Given("User provides username\" and password and login for SauceDemo Website")
    public void user_provides_username_and_password_and_login_for_sauce_demo_website() {
        sauceDemoLoginPage.userLogin(ConfigReader.readProperty("QA_sauceDemo_username"),
                                     ConfigReader.readProperty("QA_sauceDemo_password"));
    }

    @Then("User chooses the first {string} and clicks Add to Cart")
    public void user_chooses_the_first_and_clicks_add_to_cart(String string) {

    }

    @Then("User clicks on the Cart sign on the top right")
    public void user_clicks_on_the_cart_sign_on_the_top_right() {

    }

    @Then("User clicks on the Checkout button")
    public void user_clicks_on_the_checkout_button() {

    }

    @Then("User fills in the {string},{string}, and'<postalCode>'")
    public void user_fills_in_the_and_postal_code(String string, String string2) {

    }

    @Then("User clicks on the Continue button")
    public void user_clicks_on_the_continue_button() {

    }

    @Then("User validates the {string}, {string}, and {string}")
    public void user_validates_the_and(String string, String string2, String string3) {

    }

    @Then("User validates the'' is correct")
    public void user_validates_the_is_correct() {

    }

    @Then("User clicks on the Finish button")
    public void user_clicks_on_the_finish_button() {

    }

    @Then("User validates the Thank you for your order message")
    public void user_validates_the_thank_you_for_your_order_message() {

    }

}
