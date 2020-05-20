package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.cra.qa.util.TestUtil;
import com.cra.qa.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public TestBase() {
		System.out.println("inside tesbase constr");
		// TODO Auto-generated constructor stub
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/rakeshjanardhanan/PageObjectModel/PomWithMaven/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void Initialization() {
		System.out.println("inside Initialization");
		String browserName = prop.getProperty("browser");
		if(browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();		
		}else if(browserName.contains("chrome")) {
	//		System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new FirefoxDriver();	
		
		}else {
			System.out.println("No browser defined");
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
				
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		System.out.println(prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
	}
}
