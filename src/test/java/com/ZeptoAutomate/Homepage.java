package com.ZeptoAutomate;

import java.time.Duration;

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
	By selectSearchresultItem = By.xpath("//span[contains(text(),'Artistque Tempered Glass For Iphone 17 A')]/ancestor::div[@class='cslgId cTH4Df']");
	By addToCart = By.xpath("(//button[contains(@aria-label,'Increase quantity by one')])/ancestor::div[@class='ZMs6c']");

	public void ClicksearchFor() throws InterruptedException {
		driver.findElement(searchclcikBox).click();
		Thread.sleep(2000);
		driver.findElement(enterSeearchText).sendKeys("iphone 17" + Keys.ENTER);
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
}
