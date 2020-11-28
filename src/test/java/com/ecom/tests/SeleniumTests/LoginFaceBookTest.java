package com.ecom.tests.SeleniumTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginFaceBookTest {

	@Before
	public void setUp() throws Exception {
		App.initWebDriver();
	}

	@After
	public void tearDown() throws Exception {
		App.shutDownDriver();
	}

	@Test
	public void loginFailureTest() throws InterruptedException {
		WebDriver driver = RunEnvironment.getWebDriver();
		final String siteUrl = "https://www.facebook.com/";
		driver.get(siteUrl);
		
		WebElement email = driver.findElement(By.id("email"));
		System.out.println(email.getTagName() );
		email.sendKeys("abcd@gmail.com");
		
		WebElement pass = driver.findElement(By.id("pass"));
		System.out.println(pass.getTagName() );
		pass.sendKeys("abcd@123");
		
		WebElement submit = driver.findElement(By.xpath("//*[@id=\"u_0_b\"]"));
		
		submit.submit();
		
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//*[@id=\"error_box\"]")).isDisplayed()) {
			assertTrue("Login Failure with wrong creds",true);
		} else {
			assertTrue("Login Success with wrong creds",false);
		}
		
		Thread.sleep(100000);
	}

}
