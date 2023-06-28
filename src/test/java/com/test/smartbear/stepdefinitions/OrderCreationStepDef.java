package com.test.smartbear.stepdefinitions;

import com.test.smartbear.pages.SmartBearLoginPage;
import com.test.smartbear.pages.SmartBearMainPage;
import com.test.smartbear.pages.SmartBearOrderPage;
import com.test.smartbear.pages.SmartBearViewOrderPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

import java.sql.SQLOutput;
import java.util.Map;

public class OrderCreationStepDef {
    WebDriver driver= DriverHelper.getDriver();
    SmartBearLoginPage smartBearLoginPage=new SmartBearLoginPage(driver);
    SmartBearMainPage smartBearMainPage=new SmartBearMainPage(driver);
    SmartBearOrderPage smartBearOrderPage=new SmartBearOrderPage(driver);
    SmartBearViewOrderPage smartBearViewOrderPage= new SmartBearViewOrderPage(driver);

    @Given("User provides username and password for SmartBear login")
    public void user_provides_username_and_password_for_smart_bear_login() {
       smartBearLoginPage.login(ConfigReader.readProperty("QA_smartBear_username"),
                                ConfigReader.readProperty("QA_smartBear_password"));

    }
    @When("User clicks Order Button provides the {string} and {string} for product information")
    public void user_clicks_order_button_provides_the_and_for_product_information(String product, String quatity) {
            smartBearMainPage.clickOrderButton();
            smartBearOrderPage.productInformation(product,quatity);

    }
    @When("User provides {string},{string},{string},{string},{string} for address information")
    public void user_provides_for_address_information(String name, String street, String city, String state, String zipCode) {
          smartBearOrderPage.sendInformation(name,street,city,state,zipCode);
    }
    @When("User provides {string},{string},{string} for payment information")
    public void user_provides_for_payment_information(String visa, String cardNumber, String expirationDate) {
           smartBearOrderPage.paymentInformation(visa,cardNumber,expirationDate);
    }
    @Then("User clicks process button and validates {string}")
    public void user_clicks_process_button_and_validates(String expectedMessage) throws InterruptedException {

          smartBearOrderPage.validateMessage(expectedMessage);
    }
    @Then("User validates all information {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},frome table")
    public void user_validates_all_information_frome_table(String name, String product, String quantity, String street, String city,
                                                           String state, String zipCode, String cardType, String cardNumber, String expirationDate) {
             smartBearViewOrderPage.clickViewOrderButton();
             smartBearViewOrderPage.validateAllInformation(name,product,quantity,street,city,state,zipCode,cardType,cardNumber,expirationDate);
    }
    @When("User clicks OrderButton and provides the product and quantity for product information")
    public void user_clicks_order_button_and_provides_the_product_and_quantity_for_product_information(DataTable dataTable) {

        Map<String,String> productInformation=dataTable.asMap();
        System.out.println(productInformation);
        smartBearMainPage.clickOrderButton();
        smartBearOrderPage.productInformation(productInformation.get("product"),
                productInformation.get("quantity"));

    }
    @When("User provides customerName,street,city,state,zipcode for address information")
    public void user_provides_customer_name_street_city_state_zipcode_for_address_information(DataTable dataTable) {
        Map<String,String> userInformation=dataTable.asMap();
        System.out.println(userInformation);
        smartBearOrderPage.sendInformation(userInformation.get("Ulzii"),
                                           userInformation.get("123 Main Street"),
                                           userInformation.get("Chicago"),
                                           userInformation.get("IL"),
                                           userInformation.get("60102"));

    }
    @When("User provides cardType,cardNumber,expireDate for payment information")
    public void user_provides_card_type_card_number_expire_date_for_payment_information(DataTable dataTable) {
          Map<String,String> paymentInformation=dataTable.asMap();
        System.out.println(paymentInformation);
        smartBearOrderPage.paymentInformation(paymentInformation.get("Visa"),
                                               paymentInformation.get("112423453"),
                                                 paymentInformation.get("06/25"));
    }
    @When("User clicks procees button and validates message")
    public void user_clicks_procees_button_and_validates_message(DataTable dataTable) {
     smartBearOrderPage.clickProcessButton();


    }


}
