package com.BookFlight.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By close = By.xpath("//span[@class='commonModal__close']");

	By backtoClassic = By.xpath("//span[contains(text(),'Back to Classic Search')]");

	By roundtrip = By.xpath("//li[@data-cy='roundTrip']");
	By sourceCity = By.id("fromCity");
	By sourceSearchBox = By.xpath("//input[@aria-controls='react-autowhatever-1']");

	By destinationCity = By.id("toCity");
	By destinationSearchBox = By.xpath("//input[@aria-controls='react-autowhatever-1']");
	By searchButton = By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']");

//  	  Action Methods :
	public void closePopUp() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(close).click();
	}

	public void backtoClassicSearch() throws InterruptedException {
		driver.findElement(backtoClassic).click();
		Thread.sleep(2000);
	}

	public void clickRoundTripButton() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(roundtrip).click();
	}

	public void enterSourceCity(String fromCity) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(sourceCity).click();
		Thread.sleep(2000);
		driver.findElement(sourceSearchBox).sendKeys(fromCity);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'" + fromCity + "')]")).click();
	}

	public void enterDestinationCity(String toCity) throws InterruptedException {
		driver.findElement(destinationCity).click();
		Thread.sleep(2000);
		driver.findElement(destinationSearchBox).sendKeys(toCity);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'" + toCity + "')]")).click();
	}

	public void selectDepartureDate() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@aria-label,'Fri May 15 2026')]")).click();
	}

	public void selectReturnDate() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@aria-label,'Mon May 18 2026')]")).click();
	}

	public void clickSearchButton() {

		driver.findElement(searchButton).click();
	}
}
