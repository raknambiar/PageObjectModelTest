package com.crm.qa.testcases;

import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPageTest extends TestBase {
	LoginPage login;
	HomePage homepage;
	
	/*
	 * public LoginPageTest() { 
	 * super(); 
	 * }
	 */
	
 
  @BeforeMethod
  public void setUp() {
	  Initialization();
	  login = new LoginPage();
	  
  }

  @Test (priority =1)
  public void loginPageTitleTest() {
	 String text = login.validateLoginPageTitle();
	 Assert.assertEquals(text, "Cogmento CRM");
  }
  
  @Test (priority =2)
  public void loginTest() {
	  login.login(prop.getProperty("username"), prop.getProperty("password"));

  }
  
  @AfterMethod
  public void tearDown() {
	  driver.quit();
  }

}
