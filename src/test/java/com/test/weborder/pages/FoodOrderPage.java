package com.test.weborder.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserUtils;


public class FoodOrderPage {

    public FoodOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".custom-control-label")
    WebElement groupOrderCheckBox;
    @FindBy(css = "#getAddressNextButton")
    WebElement nextButton;
    @FindBy(css = "#InviteNote")
    WebElement inviteSection;
    @FindBy(css = "#InviteList")
    WebElement inviteList;
    @FindBy(css = "#ConfirmAddressID")
    WebElement Location;
    @FindBy(css = "#addressPreview")
    WebElement address;
    @FindBy(css = "#createGroupOrder")
    WebElement createGroupOrderButton;
    @FindBy(xpath = "//h1[@class='topBannerHeader']")
    WebElement header;
    @FindBy(xpath = "//p[contains(text(),'Your group order is now pending')]")
    WebElement description;

    public void clickGrouOrderButton() {
        if (groupOrderCheckBox.isDisplayed()) {
            groupOrderCheckBox.click();
        }
    }

    public void clickNextButton() {
        nextButton.click();
    }

    public void sendMessage(String message) {
        inviteSection.sendKeys(message);
    }

    public void sendEmails(String email1, String email2) {
        inviteList.sendKeys(email1 + " ," + email2);
    }

    public void chooseLocationAndValidateAddress(String location, String expectedAddress) throws InterruptedException {
        BrowserUtils.selectBy(this.Location, location, "text");
        Assert.assertTrue(BrowserUtils.getText(address).contains(expectedAddress));
        Thread.sleep(2000);
    }

    public void clickCreateGroupOrderButton() throws InterruptedException {
        createGroupOrderButton.click();
        Thread.sleep(2000);
    }
    public  void validateheaderAndValidateDescription(String expectedHeader,String expectedDescription){
        Assert.assertEquals(expectedHeader,BrowserUtils.getText(header));
        Assert.assertTrue(BrowserUtils.getText(description).contains(expectedDescription));
    }


}






















