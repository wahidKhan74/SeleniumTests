package com.ecom.tests.SeleniumTests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotTest {

	@Before
	public void setUp() throws Exception {
		App.initWebDriver();
	}

	@After
	public void tearDown() throws Exception {
		App.shutDownDriver();
	}
	
	@Test
	public void takeScreenShot() throws IOException {
		
		WebDriver driver = RunEnvironment.getWebDriver();
		final String siteUrl = "https://github.com/";
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(siteUrl);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("/home/wahidkhan74gmai/test.png"));
	}
}
