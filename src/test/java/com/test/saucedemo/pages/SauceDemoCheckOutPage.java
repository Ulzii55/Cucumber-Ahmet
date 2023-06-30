package com.test.saucedemo.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class SauceDemoCheckOutPage {
    public SauceDemoCheckOutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#checkout")
    WebElement checkoutButton;

    @FindBy(css = "#first-name")
    WebElement firstName;

    @FindBy(css = "#last-name")
    WebElement lastName;

    @FindBy(css = "#postal-code")
    WebElement zipCode;

    @FindBy(css = "#continue")
    WebElement continueButton;

    @FindBy(css = ".inventory_item_name")
    WebElement itemTitle;

    @FindBy(css = ".summary_subtotal_label")
    WebElement itemPrice;

    @FindBy(css = ".summary_tax_label")
    WebElement taxAmount;

    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    WebElement totalAmount;

    @FindBy(css = "#finish")
    WebElement finishButton;

    @FindBy(xpath = "//h2[@class='complete-header']")
    WebElement thankYouMessage;

    public void clickCheckOutButton() {
        checkoutButton.click();
    }

    public void inputInformation(String firstName, String lastName, String zipCode) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.zipCode.sendKeys(zipCode);

    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void validateDetails(String expectedItemTitle, String expectedTaxAmount, String expectedTotalAmount) {
        Assert.assertEquals(expectedItemTitle, BrowserUtils.getText(itemTitle));
        Assert.assertTrue(expectedTaxAmount.contains(BrowserUtils.getText(taxAmount)));
        Assert.assertTrue(expectedTotalAmount.contains(BrowserUtils.getText(totalAmount)));
    }

    public void clickFinshButton() {
        finishButton.click();
    }
    public void validateThankYouMessage(String expectedMessage){
        Assert.assertEquals(expectedMessage,BrowserUtils.getText(thankYouMessage));
    }


}
