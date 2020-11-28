package com.ecom.tests.SeleniumTests;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadProfileImageTest {
	
	@Before
	public void setUp() throws Exception {
		App.initWebDriver();
	}

	@After
	public void tearDown() throws Exception {
//		App.shutDownDriver();
	}

	@Test
	public void profileImageUploadTest() throws InterruptedException {
		
		WebDriver driver = RunEnvironment.getWebDriver();
		LoginApp.loginApp();
		
		Thread.sleep(2000);
		final String siteUrl = "https://github.com/settings/profile";
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(siteUrl);
//		Thread.sleep(2000); // So that page is loaded.
		
		// find edit button and click.	
		WebElement editButton = driver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div/div[2]/div[2]/div[2]/dl/dd/div/details/summary/div"));
		editButton.click();
		
		WebElement addFile = driver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div/div[2]/div[2]/div[2]/dl/dd/div/details/details-menu/label"));
		addFile.click();
		
		addFile.sendKeys("/home/wahidkhan74gmai/logo.png");
		
		
//		driver.switchTo().window(driver.getWindowHandle());
		
		
		
		driver.findElement(By.linkText("Set new profile picture")).click();
		Thread.sleep(2000); // Image uploading delay. 
		
		
		Thread.sleep(100000);
	}
}
