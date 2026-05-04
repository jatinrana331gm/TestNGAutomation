package com.jatin.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    public WebDriver driver;
    
    public void launchBrowser(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
       
        
        // 2. Hardcoded "google.com" ki jagah hum 'url' variable use karenge
        
        driver.get(url); 
        System.out.println("Browser successfully launch ho gaya URL ke saath: " + url);
    }
    
    public void searchText(String input) {
        driver.findElement(By.name("q")).sendKeys(input);
        driver.findElement(By.name("q")).submit();
        System.out.println("Search action perform ho gaya: " + input);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser close ho gaya.");
        }
    }
}






















//package com.jatin.pages;
//
//import org.openqa.selenium.By; // Shortcut ke liye import add kiya
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class BaseTestClass {
//    public WebDriver driver;
//
//    // Browser launch karne ka method
//    public void launchBrowser() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://www.google.com");
//        System.out.println("Browser successfully launch ho gaya.");
//    }
//    
//    // Search karne ka method (Re-usable logic)
//    public void searchText(String input) {
//    	
//        // 'By.name' direct use kiya kyunki upar import hai
//    	
//        driver.findElement(By.name("q")).sendKeys(input);
//        driver.findElement(By.name("q")).submit();
//        System.out.println("Search action perform ho gaya: " + input);
//    }
//
//    // Browser close karne ka method
//    public void closeBrowser() {
//        if (driver != null) {
//            driver.quit();
//            System.out.println("Browser close ho gaya.");
//        }
//    }
//}