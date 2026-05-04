package com.BookFlight.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.BookFlight.pom.HomePage;

public class TestCases {

	WebDriver driver;

	@BeforeTest
	public void launchChromeBrowser() {
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

	}

	@Test
	public void searchFlightTickets() throws InterruptedException {
		HomePage homepage = new HomePage(driver);
		homepage.closePopUp();
//		homepage.backtoClassicSearch();
		homepage.clickRoundTripButton();
		homepage.enterSourceCity("Pune");
		homepage.enterDestinationCity("Hyderabad");
		homepage.selectDepartureDate();
		homepage.selectReturnDate();
		homepage.clickSearchButton();

	}

	@AfterTest
	public void closeBrowser() {
//		driver.close(); 
	}
}
