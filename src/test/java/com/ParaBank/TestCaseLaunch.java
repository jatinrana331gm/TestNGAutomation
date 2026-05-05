package com.ParaBank;

import com.jatin.utils.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCaseLaunch extends BaseClass {

	RegisterPage r;

	@BeforeMethod
	public void setup() {
		launchBrowser();
		r = new RegisterPage(driver);
	}

	@Test
	public void testHomePage() {
		r.clickregisterlink();
		Utility.takeScreenshot(driver, "1_Register_Click");
		System.out.println("Register link clicked");

		r.fillForm();
		Utility.takeScreenshot(driver, "2_Form_Filled");
		System.out.println("form filled successfully");

		r.registerButtonClick();
		System.out.println("done all");
	    Utility.takeScreenshot(driver, "3_Submitted");

		r.customerLogin();
	}

	@AfterMethod
	public void teardown() {
		closeBrowser();
	}
}