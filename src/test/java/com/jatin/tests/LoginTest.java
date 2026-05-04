package com.jatin.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jatin.base.BaseTest;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void setup() {
        // Base class ka method call kiya aur URL pass kiya
        launchBrowser("https://www.google.com"); 
    }

    @Test(priority = 1)
    public void googleSearchValidation() {
        System.out.println("Google Page Title: " + driver.getTitle());
        searchText("TestNG Automation by Jatin"); 
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser(); // Browser close karne ke liye
    }
}





//package com.jatin.tests;
//
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import com.jatin.pages.BaseTestClass;
//
//public class LoginTest extends BaseTestClass {
//
//    @BeforeMethod
//    public void setup() {
//        launchBrowser(); // Base class se call hua
//    }
//
//    @Test(priority = 1)
//    public void googleSearchValidation() {
//        System.out.println("Title hai: " + driver.getTitle());
//        
//        searchText("TestNG Automation by Jatin"); 
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        closeBrowser(); // Base class se call hua
//    }
//}