package com.ZeptoAutomate;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import org.openqa.selenium.io.FileHandler;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {

	WebDriver driver;
	WebDriverWait wait;

	public Homepage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	By searchclcikBox = By.xpath("//a[contains(@aria-label,'Search for products')]");
	By enterSeearchText = By.xpath("//input[contains(@placeholder,'Search for over 5000 products')]");
	By selectSearchresultItem = By.xpath(
			"//span[contains(text(),'Artistque Tempered Glass For Iphone 17 A')]/ancestor::div[@class='cslgId cTH4Df']");
	By addToCart = By
			.xpath("(//button[contains(@aria-label,'Increase quantity by one')])/ancestor::div[@class='ZMs6c']");

	// print details
	By allDetails = By.xpath("//div[@class='__9M1qu']");

	public void ClicksearchFor() {
		wait.until(ExpectedConditions.elementToBeClickable(searchclcikBox)).click();
//		driver.findElement(searchclcikBox).click();
		wait.until(ExpectedConditions.elementToBeClickable(enterSeearchText)).sendKeys("iphone 17" + Keys.ENTER);
//		driver.findElement(enterSeearchText).sendKeys("iphone 17" + Keys.ENTER);
	}

	public void selectSearchItem() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selectSearchresultItem));
		element.click();
	}

	public void addtoCart() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,50)");
		wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();
	}

	public void takeScreenshot(String fileName) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destination = new File("./screenshots/" + fileName + ".png");
			FileHandler.copy(source, destination);
			System.out.println("Screenshot saved: " + destination.getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void printAllDetailsWithLoop() {

		List<WebElement> detailsList = driver.findElements(allDetails);

		System.out.println("======= Product Details (Loop) =======");

		for (WebElement detail : detailsList) {
			String text = detail.getText();
			if (!text.isEmpty()) {
				System.out.println("-> " + text);
			}
		}
		System.out.println("======================================");
	}

	public void navigationHome() {
		driver.navigate().back();
		System.out.println("Ek step peeche gaye.");

		driver.navigate().back();
		System.out.println("Do step peeche gaye.");
	}

}
