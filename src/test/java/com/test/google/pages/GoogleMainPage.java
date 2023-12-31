package com.test.google.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class GoogleMainPage {
    public GoogleMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//textarea[@name='q']")
    WebElement searchBar;

    @FindBy(xpath = "//a//h3")
    List<WebElement> allLinks;

    @FindBy(xpath = "//div[@id='result-stats']")
    WebElement result;

    public void searchItem(String item) {
        searchBar.sendKeys(item, Keys.ENTER);
    }

    public boolean linkCount(int expectedNumber) throws InterruptedException {
        Thread.sleep(2000);
        return allLinks.size() > expectedNumber;
    }
    public boolean ResultFromSearch(int expectedResult){
        String [] result= BrowserUtils.getText(this.result).split(" ");
        return Integer.parseInt(result[1].replace(",",""))<expectedResult;
    }
    public boolean searchResultLoadingSpeed(double expectedResult){
        String []result=BrowserUtils.getText(this.result).split(" ");
        return Double.parseDouble(result[3].replace("(","").trim())<expectedResult;
    }

}
