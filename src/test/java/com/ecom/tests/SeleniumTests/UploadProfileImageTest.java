package com.ecom.tests.SeleniumTests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
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
	public void profileImageUploadTest() throws InterruptedException, IOException {
		
		WebDriver driver = RunEnvironment.getWebDriver();
		LoginApp.loginApp();
		
		Thread.sleep(2000);
		final String siteUrl = "https://github.com/settings/profile";
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(siteUrl);
		
		// find edit button and click.	
		WebElement editButton = driver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div/div[2]/div[2]/div[2]/dl/dd/div/details/summary/div"));
		editButton.click();
		
		WebElement addFile = driver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div/div[2]/div[2]/div[2]/dl/dd/div/details/details-menu/label"));
		addFile.click();
		Thread.sleep(5000); // Image uploading delay.

		//Close windows popup
		Runtime.getRuntime().exec("E:\\AuScript\\ProfileUpload.exe");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/details/details-dialog/form/div[2]/button")).click();
		Thread.sleep(2000); // Image uploading delay. 
		
		
	}
}
