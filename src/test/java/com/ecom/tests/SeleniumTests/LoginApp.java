package com.ecom.tests.SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginApp {
	
	public static void loginApp() {
		
		WebDriver driver = RunEnvironment.getWebDriver();
		String loginUrl = "https://github.com/login";
		driver.get(loginUrl);
		
		WebElement email = driver.findElement(By.id("login_field"));
		System.out.println(email.getTagName() );
		email.sendKeys("XXX@gmail.com");
		
		WebElement pass = driver.findElement(By.id("password"));
		System.out.println(pass.getTagName() );
		pass.sendKeys("XX");
		
		WebElement submit = driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[4]/input[12]"));
		
		submit.submit();
	}
}
