package com.ParaBank;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	WebDriver driver;
	WebDriverWait wait;

	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://parabank.parasoft.com");
	}

	public void closeBrowser() {
		driver.quit();
	}
}