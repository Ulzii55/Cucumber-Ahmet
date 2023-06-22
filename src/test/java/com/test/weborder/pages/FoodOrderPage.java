package com.test.weborder.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;


public class FoodOrderPage {

    public FoodOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#ConfirmAddressID")
    WebElement deliveryOptionDropDown;
    @FindBy(css = "#addressPreview")
    WebElement address;
    @FindBy(css = ".custom-control-label")
    WebElement groupOrderCheckBox;
    @FindBy(css = "#getAddressNextButton")
    WebElement nextButton;
    @FindBy(css = "#InviteNote")
    WebElement inviteSection;
    @FindBy(css = "#InviteList")
    WebElement inviteList;
    @FindBy(css = "#createGroupOrder")
    WebElement createGroupOrderButton;
    @FindBy(xpath = "//h1[@class='topBannerHeader']")
    WebElement header;
    @FindBy(xpath = "//p[contains(text(),'Your group order is now pending')]")
    WebElement description;

    public void createGroupOrder() throws InterruptedException {
        Thread.sleep(2000);
        groupOrderCheckBox.click();
        nextButton.click();
    }

    public void inputNoteAndEmails(String Note, String email1, String email2) throws InterruptedException {
        inviteSection.sendKeys(Note);
        Thread.sleep(1000);
        inviteList.sendKeys(email1, email2);

    }

    public void validateHouseAddress(String expectedAddress) {
        Assert.assertTrue(expectedAddress, address.getText().contains(expectedAddress));
        createGroupOrderButton.click();

    }

    public void validateHeader(String expectedHeader, String expectedDescription) {
        createGroupOrderButton.click();
        Assert.assertEquals(expectedHeader, BrowserUtils.getText(header));
        Assert.assertTrue(expectedDescription.contains(BrowserUtils.getText(description)));

    }


}
