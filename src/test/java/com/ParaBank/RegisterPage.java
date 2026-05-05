package com.ParaBank;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegisterPage {

	WebDriver driver;
	WebDriverWait wait;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Locators
	By registerlink = By.xpath("//a[text()='Register']");
	By firstName = By.name("customer.firstName");
	By lastName = By.id("customer.lastName");
	By Address = By.id("customer.address.street");
	By city = By.id("customer.address.city");
	By State = By.id("customer.address.state");
	By zipCode = By.id("customer.address.zipCode");
	By Phone = By.id("customer.phoneNumber");
	By SSN = By.id("customer.ssn");
	By username = By.id("customer.username");
	By password = By.id("customer.password");
	By conform = By.id("repeatedPassword");
	By registerButton = By.className("button");

	// Customer Login
	By usernameNew = By.name("username");
	By passwordNew = By.name("password");
	By loginButtonClick = By.xpath("//input[@value='Log In']");

//Methods 
	public void clickregisterlink() {
		wait.until(ExpectedConditions.elementToBeClickable(registerlink)).click();
	}

	public void fillForm() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys("Jatin");
		driver.findElement(lastName).sendKeys("Rana");
		driver.findElement(Address).sendKeys("Sonipat");
		driver.findElement(city).sendKeys("Sonipat");
		driver.findElement(State).sendKeys("Haryana");
		driver.findElement(zipCode).sendKeys("131001");
		driver.findElement(Phone).sendKeys("9999999999");
		driver.findElement(SSN).sendKeys("1234");
		driver.findElement(username).sendKeys("jatin123");
		driver.findElement(password).sendKeys("pass123");
		driver.findElement(conform).sendKeys("pass123");
	}

	public void registerButtonClick() {
		wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
	}

	// ////////////////
	public void customerLogin() {
		// Fill and Click
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameNew)).sendKeys("jatin123");
		driver.findElement(passwordNew).sendKeys("pass123");
		driver.findElement(loginButtonClick).click();

		// SIMPLE FIX: Wait for the new page element to appear
		// Isse StaleElementReferenceException nahi aayegi
		boolean isDashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")))
				.isDisplayed();

		Assert.assertTrue(isDashboard, "Login fail ho gaya!");
		System.out.println("Login Passed: Dashboard visible.");
	}
}
