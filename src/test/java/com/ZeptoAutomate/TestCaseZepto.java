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

		homepage.takeScreenshot("after_add_to_cart");
		homepage.printAllDetailsWithLoop();
		homepage.takeScreenshot("Loop_Details_Result");
		homepage.navigationHome();
		homepage.takeScreenshot("Final_Homepage_View");
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit(); 
	}

}
