package com.jatin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {
    WebDriver driver;

    // Elements ko alag rakha
    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    WebElement searchButton;

    // Constructor (PageFactory initialize karne ke liye)
    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Sirf Actions yahan honge
    public void searchProduct(String productName) {
        searchBox.sendKeys(productName);
        searchButton.click();
    }
}
