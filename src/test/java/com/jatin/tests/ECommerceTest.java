package com.jatin.tests;

import org.testng.annotations.Test;

import com.jatin.base.BaseTest;
import com.jatin.pages.AmazonHomePage;

public class ECommerceTest extends BaseTest {

    @Test
    public void testAmazon() {
        launchBrowser("https://www.amazon.in"); 
        
        // Page object banaya
        AmazonHomePage amazon = new AmazonHomePage(driver);
        
        // Page class ka method use kiya
        amazon.searchProduct("iPhone 15");
        
        System.out.println("Test Complete!");
        
        driver.quit();
    }
}