package com.test.smartbear.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearMainPage {
    public SmartBearMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[contains(text(),'Order')]")
    WebElement orderButton;

    public void clickOrderButton(){
        orderButton.click();
    }
}
