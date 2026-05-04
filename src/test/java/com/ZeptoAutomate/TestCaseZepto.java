package com.ZeptoAutomate;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCaseZepto {
	WebDriver driver;

	@BeforeTest
	public void launchbrowser() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.zepto.com/?srsltid=AfmBOop8sA_At57bLrUeDvYgVxYC63gRxxB6dCN2NnZQNZ8aYiLvrJIF");
	}
	
	@Test
	public void Zepto() throws InterruptedException {
		Homepage homepage = new Homepage(driver);
		homepage.ClicksearchFor();
		homepage.selectSearchItem();
		homepage.addtoCart();
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit(); 
	}

}
