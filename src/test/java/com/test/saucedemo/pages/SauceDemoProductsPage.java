package com.test.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class SauceDemoProductsPage {
    public SauceDemoProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    List<WebElement> allItems;

    @FindBy(xpath = "//div//button[@class='btn btn_primary btn_small btn_inventory']")
    WebElement addCartButtons;

    @FindBy(css = ".shopping_cart_link")
    WebElement cartSign;

    public void chooseProduct(String product) {
        for (WebElement item : allItems) {
            if (BrowserUtils.getText(item).equals(product)) {
                addCartButtons.click();
            }
            break;
        }
    }

    public void clickCartButton() {
        cartSign.click();
    }

}
