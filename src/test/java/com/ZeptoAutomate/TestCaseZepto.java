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
	public void Zepto() {
		Homepage homepage = new Homepage(driver);

		homepage.ClicksearchFor();
		homepage.takeScreenshot("1_Search_Initiated");

		homepage.selectSearchItem();
		homepage.takeScreenshot("2_Item_Selected");

		homepage.addtoCart();
		homepage.takeScreenshot("3_Added_To_Cart");

		homepage.printAllDetailsWithLoop();
		homepage.takeScreenshot("4_Details_Logged");

		homepage.navigationHome();
		homepage.takeScreenshot("5_Final_Home_View");
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
