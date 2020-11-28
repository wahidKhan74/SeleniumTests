package com.ecom.tests.SeleniumTests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class BrowserBasedPopupWindowTest {

	@Before
	public void setUp() throws Exception {
		App.initWebDriver();
	}

	@After
	public void tearDown() throws Exception {
		App.shutDownDriver();
	}
	
	@Test
	public void windowPopup() throws IOException {
		
		WebDriver driver = RunEnvironment.getWebDriver();
		final String siteUrl = "http://output.jsbin.com/usidix/1";
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(siteUrl);
		
		driver.findElement(By.cssSelector("body > input[type=button]")).click();
		
		String alertMsg = driver.switchTo().alert().getText();
		String expectedAlertMsg = "This is an alert box.";
		
		System.out.println(alertMsg);
		assertEquals(expectedAlertMsg, alertMsg);
		
	}
}
