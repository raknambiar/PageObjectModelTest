package com.crm.qa.testcases;

import org.testng.annotations.Test;

import com.cra.qa.util.TestUtil;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ContactsPageTest extends TestBase{
	LoginPage login;
	HomePage homepage;
	ContactsPage contactspage;
	
	
	/*
	 * public ContactsPageTest() { 
	 * super(); 
	 * }
	 */
	
  
  @BeforeMethod
  public void setUp() throws InterruptedException  {
	  Initialization();
	  System.out.println("before login = new login page");
	  login = new LoginPage();
	  homepage = new HomePage();
	  contactspage = new ContactsPage();
	  login.login(prop.getProperty("username"), prop.getProperty("password")); 
	  homepage.clickOnContactLink();
	  Thread.sleep(2000);
  }
 
  
	
	  @Test (priority =3) public void verifyContactLableTest() {
	  System.out.println("inside verifyContactLableTest");
	  Assert.assertTrue(contactspage.verifyContactLable()
	  ,"contact label is missing"); }
	  
	  @Test (priority =1) public void selectContactByNameTest() {
	  System.out.println("inside selectContactByNameTest");
	  
	  
	  contactspage.selectContactByName("Rishan Rakesh"); }
	  
	  @Test (priority =2) public void selectMultipleContactByNameTest() {
	  System.out.println("inside selectContactByNameTest");
	  
	  
	  contactspage.selectContactByName("Rishan Rakesh");
	  contactspage.selectContactByName("Rakesh Janardhanan");
	  contactspage.selectContactByName("Ian Rakesh"); }
	 
  
  @DataProvider 
  public Object[][] getCRMTestData() throws InvalidFormatException {
	  System.out.println("inside getCRMTestData");
	  Object data[][] = TestUtil.getTestData("contacts");
	  return data;
  }
  @Test (priority =4, dataProvider = "getCRMTestData")
  public void CreateNewContactTest(String firstName, String lastName) {
	  System.out.println("CreateNewContactTest");
	  contactspage.CreateNewContact(firstName, lastName);
  }
  @AfterMethod
  public void afterMethod() {
	 driver.quit();
  }

}
