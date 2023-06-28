package com.test.smartbear.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class SmartBearOrderPage {
    public SmartBearOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#ctl00_MainContent_fmwOrder_ddlProduct")
    WebElement product;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtQuantity")
    WebElement quantity;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtName")
    WebElement name;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox2")
    WebElement street;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox3")
    WebElement city;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox4")
    WebElement state;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox5")
    WebElement zipCode;
    @FindBy(xpath = "//table[@id='ctl00_MainContent_fmwOrder_cardList']//label")
    List<WebElement> cardTypes;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox6")
    WebElement cardNumber;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox1")
    WebElement expirationDate;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_InsertButton")
    WebElement processButton;
    @FindBy(xpath = "//strong")
    WebElement message;


    public void productInformation(String MyMoney, String quantity) {
        BrowserUtils.selectBy(product, MyMoney, "text");
        this.quantity.sendKeys(quantity);
    }

    public void sendInformation(String name, String street, String city, String state, String zipCode) {
        this.name.sendKeys(name);
        this.street.sendKeys(street);
        this.city.sendKeys(street);
        this.state.sendKeys(state);
        this.zipCode.sendKeys(zipCode);
    }

    public void paymentInformation(String cardType, String cardNumber, String expirationDate) {
        for (WebElement card : cardTypes) {
            if (BrowserUtils.getText(card).equals(cardType)) {
                card.click();
                break;
            }
        }
        this.cardNumber.sendKeys(cardNumber);
        this.expirationDate.sendKeys(expirationDate);

    }
    public void clickProcessButton(){
        processButton.click();
    }

    public void validateMessage(String expectedMessage) throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(expectedMessage, BrowserUtils.getText(message));

    }


}
