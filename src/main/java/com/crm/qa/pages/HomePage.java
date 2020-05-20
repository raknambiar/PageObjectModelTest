package com.crm.qa.pages;

import org.openqa.selenium.By;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	By User = By.className("user-display");
	
	By ContactsLink = By.xpath("//span[contains(text(),'Contacts')]");
	By DealsLink = By.xpath("//span[contains(text(),'Deals')]");
	By TasksLink = By.xpath("//span[contains(text(),'Tasks')]");
	
	public String validateHomePageTitle() {
		 System.out.println("inside validateHomePageTitle");
		return driver.getTitle();
		
	}
	
	public boolean verifyCorrectUsername() {
		 System.out.println("inside verifyCorrectUsername");
		System.out.println(driver.findElement(User).getText());
		return driver.findElement(User).isDisplayed();
	}
	public void clickOnContactLink()  {
		 System.out.println("inside clickOnContactLink");
		driver.findElement(ContactsLink).click();
		
		
	  //  return new ContactsPage();
	}
	public void clickOnDealsLink() {
		 System.out.println("inside clickOnDealsLink");
		driver.findElement(DealsLink).click();
	//	return new DealsPage();
	}
	public void clickOnTasksLink() {
		 System.out.println("inside clickOnTasksLink");
		driver.findElement(TasksLink).click();
	//	return new TasksPage();
	}
	
}
