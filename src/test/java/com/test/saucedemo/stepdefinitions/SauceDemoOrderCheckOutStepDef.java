package com.test.saucedemo.stepdefinitions;

import com.test.saucedemo.pages.SauceDemoCheckOutPage;
import com.test.saucedemo.pages.SauceDemoLoginPage;
import com.test.saucedemo.pages.SauceDemoProductsPage;
import io.cucumber.datatable.DataTable;
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

    @Given("User provides username and password and login for SauceDemo Website")
    public void user_provides_username_and_password_and_login_for_sauce_demo_website() {
        sauceDemoLoginPage.userLogin(ConfigReader.readProperty("QA_sauceDemo_username"),
                                     ConfigReader.readProperty("QA_sauceDemo_password"));
    }

    @Then("User chooses the first {string} and clicks Add to cart")
    public void user_chooses_the_first_and_clicks_add_to_cart(String item) {
       sauceDemoProductsPage.chooseProduct(item);

    }

    @Then("User clicks on the cart sign on the top right and clicks on the checkout button")
    public void user_clicks_on_the_cart_sign_on_the_top_right_and_clicks_on_the_checkout_button() {
           sauceDemoProductsPage.clickCartButton();
           sauceDemoCheckOutPage.clickCheckOutButton();
    }

    @Then("User fills in the {string},{string},{string} and clicks clicks on the Continue Button")
    public void user_fills_in_the_and_clicks_clicks_on_the_continue_button(String firstName, String lastName, String zipCode) {
             sauceDemoCheckOutPage.inputInformation(firstName,lastName,zipCode);
             sauceDemoCheckOutPage.clickContinueButton();
    }

    @Then("User Validates the {string},{string} is eight percent and {string}")
    public void user_validates_the_is_eight_percent_and(String expectedItemTitle, String expectedTaxAmount, String expectedTotalAmount) {
        sauceDemoCheckOutPage.validateDetails(expectedItemTitle,expectedTaxAmount,expectedTotalAmount);
    }

    @Then("User clicks on the Finish Button")
    public void user_clicks_on_the_finish_button() {
     sauceDemoCheckOutPage.clickFinshButton();
    }

    @Then("User Validates {string}")
    public void user_validates(String expectedMessage) {
      sauceDemoCheckOutPage.validateThankYouMessage(expectedMessage);
    }

    @Then("User choosec the first item and clicks Add to cart")
    public void user_choosec_the_first_item_and_clicks_add_to_cart(DataTable dataTable) {

    }
    @Then("User fills in the \\(firstName,lastName, and zipCode) and clicks clicks on the Continue Button")
    public void user_fills_in_the_first_name_last_name_and_zip_code_and_clicks_clicks_on_the_continue_button(DataTable dataTable) {

    }
    @Then("User Validates the \\(item, taxAmount is eight percent and total amount")
    public void user_validates_the_item_tax_amount_is_eight_percent_and_total_amount(DataTable dataTable) {

    }
    @Then("User Validates thank you message")
    public void user_validates_thank_you_message(DataTable dataTable) {

    }




}
