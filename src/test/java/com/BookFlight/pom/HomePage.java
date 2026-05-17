package com.BookFlight.pom;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
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
	By searchButton = By.xpath("//a[contains(@class,'widgetSearchBtn')]");

	public void closePopUp() throws InterruptedException {
		Thread.sleep(2000);
		try {
			driver.findElement(close).click();
		} catch (Exception e) {
			System.out.println("Pop-up not found, skipping.");
		}
	}

	public void backtoClassicSearch() throws InterruptedException {
		Thread.sleep(2000);
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", driver.findElement(backtoClassic));
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Back to Classic Search option not present, skipping directly to search.");
		}
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
		Thread.sleep(2000);
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

		LocalDate depDate = LocalDate.now().plusDays(3);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E MMM dd yyyy", Locale.ENGLISH);
		String dynamicDepDate = depDate.format(formatter);

		driver.findElement(By.xpath("//div[contains(@aria-label,'" + dynamicDepDate + "')]")).click();
	}

	public void selectReturnDate() throws InterruptedException {
		Thread.sleep(2000);

		LocalDate retDate = LocalDate.now().plusDays(8);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E MMM dd yyyy", Locale.ENGLISH);
		String dynamicRetDate = retDate.format(formatter);

		driver.findElement(By.xpath("//div[contains(@aria-label,'" + dynamicRetDate + "')]")).click();
	}

	public void clickSearchButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(searchButton));
		System.out.println("Search Button clicked via JavaScript successfully!");
	}
}