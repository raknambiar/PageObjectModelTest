package com.crm.qa.testcases;

import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class HomePageTest extends TestBase{
	LoginPage login;
	HomePage homepage;
	ContactsPage contactspage;
	DealsPage dealspage;
	TasksPage taskspage;
	/*
	 * public HomePageTest() { 
	 * super(); 
	 * }
	 */
 
  @BeforeMethod
  public void setUp() {
	  System.out.println("inside SetUp");
	  Initialization();
	  System.out.println("before login = new login page");
	  login = new LoginPage();
	  homepage = new HomePage();
	  System.out.println("abt to click homepage");
	  login.login(prop.getProperty("username"), prop.getProperty("password"));
	
	  System.out.println("after clicking homepage");
  }
  
  @Test (priority =1)
  public void homePageTitleTest() {
	  System.out.println("inside homePageTitleTest");
	 String text = homepage.validateHomePageTitle();
	 Assert.assertEquals(text, "Cogmento CRM", "HomePage title not matched");
  }
  
  @Test (priority =2)
  public void verifyCorrectUsernameTest() {
	  System.out.println("inside verifyCorrectUsername");
	  Assert.assertTrue(homepage.verifyCorrectUsername());
  }
  
  @Test (priority =3)
  public void clickOnContactLinkTest() {
	  System.out.println("inside clickon contactlinktest");
	//  contactspage = homepage.clickOnContactLink();
	  homepage.clickOnContactLink();
  }
  
  @Test (priority =4)
  public void clickOnDealsLinkTest() {
	  System.out.println("inside clickOnDealsLinkTest");
//	  dealspage = homepage.clickOnDealsLink();
	  homepage.clickOnDealsLink();
  }
  
  @Test (priority =5)
  public void clickOnTasksLinkTest() {
	  System.out.println("inside clickOnTasksLinkTest");
	//  taskspage = homepage.clickOnTasksLink();
	  homepage.clickOnTasksLink();
  }
  
  @AfterMethod
  public void tearDown() {
	  driver.quit();
  }

}
