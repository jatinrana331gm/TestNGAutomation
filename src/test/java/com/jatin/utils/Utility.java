package com.jatin.utils;

import java.io.File;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static void takeScreenshot(WebDriver driver, String fileName) {
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
}