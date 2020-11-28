package com.ecom.tests.SeleniumTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import okhttp3.OkHttpClient;

public class App 
{
	public static void initWebDriver() {
    	OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(1000, TimeUnit.SECONDS)
    			.readTimeout(6000, TimeUnit.SECONDS)
    			.writeTimeout(6000, TimeUnit.SECONDS)
    			.build();
    	okHttpClient.retryOnConnectionFailure();
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\HOME\\Desktop\\Siimplilearn\\SeleniumTests\\driver\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	RunEnvironment.setWebDriver(driver);
    	
    }
    
    public static void shutDownDriver() {
    	RunEnvironment.getWebDriver().quit();
    }
}
