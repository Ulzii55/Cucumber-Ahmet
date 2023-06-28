package com.test.smartbear.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class SmartBearViewOrderPage {
    public SmartBearViewOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[.='View all orders']")
    WebElement viewAllOrderButton;
    @FindBy(xpath = "//tr[2]//td")
    List<WebElement> allInformation;

    public void clickViewOrderButton() {
        viewAllOrderButton.click();
    }

    public void validateAllInformation(String name, String product, String quantity,
                                       String street, String city, String state,
                                       String zipCode, String cardType, String cardNumber,
                                       String expirationDate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now().plusDays(1);
        String currentDate = dtf.format(now);

        List<String> expectedInformation = Arrays.asList("", name, product, quantity, currentDate, street, city,
                state, zipCode, cardType, cardNumber, expirationDate, "");
        for (int i = 1; i < allInformation.size() - 1; i++) {
            if (BrowserUtils.getText(allInformation.get(i)).equals(expectedInformation.get(i))) {
                Assert.assertEquals(expectedInformation.get(i), BrowserUtils.getText(allInformation.get(i)));

            }
        }
    }
}
