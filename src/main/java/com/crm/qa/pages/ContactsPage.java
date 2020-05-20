package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends TestBase{
	By contactsLabel = By.xpath("//*[@id=\"dashboard-toolbar\"]/div[1]");
	
	By checkBox = By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[1]/div/input");
	By NewContactsBtn = By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/a/button");
	By FirstName = By.name("first_name");
	By LastName = By.name("last_name");
	By SaveBtn = By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]");
	//table[contains(@class,'ui celled sortable')]/tbody/tr[1]/td[1]
	//*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]
	
	//table[contains(@class,'ui celled sortable')]/tbody/tr[2]/td[1]
	//*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[2]/td[2]
	
	
	
	
	
	/*
	 * public ContactsPage() { PageFactory.initElements(driver, this); //
	 * this.driver =driver; // TODO Auto-generated constructor stub }
	 */
	 

	public boolean verifyContactLable() {
		System.out.println("inside verifyContactLable");
		System.out.println(driver.findElement(contactsLabel).getText());
		return driver.findElement(contactsLabel).isDisplayed();
	}
	public boolean verifyContactLable1() {
		System.out.println("inside verifyContactLable1");
		System.out.println(driver.findElement(contactsLabel).getText());
		return driver.findElement(contactsLabel).isDisplayed();
	}
	
	public void selectContactByName(String name)  {
		//https://www.youtube.com/watch?v=ea0P7MBQmiM   (57.23)
		System.out.println("selectContactByName");
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println("checkboxes="+checkboxes.size());
		System.out.println("name1="+driver.findElement(By.xpath("//table[contains(@class,'ui celled sortable')]/tbody/tr[1]/td[2]")).getText());
		System.out.println("name2="+driver.findElement(By.xpath("//table[contains(@class,'ui celled sortable')]/tbody/tr[2]/td[2]")).getText());

		for(int i=1;i<checkboxes.size();i++) {
			for(int j=2;j<3;j++) {
				if (name.equalsIgnoreCase(driver.findElement(By.xpath("//table[contains(@class,'ui celled sortable')]/tbody/tr["+i+"]/td["+j+"]")).getText())){
					driver.findElement(By.xpath("//table[contains(@class,'ui celled sortable')]/tbody/tr["+i+"]/td["+j+"]")).click();
					System.out.println("name="+driver.findElement(By.xpath("//table[contains(@class,'ui celled sortable')]/tbody/tr["+i+"]/td["+j+"]")).getText());
					break;
				}
			}
		}
		
	}
	public void CreateNewContact(String firstName, String lastName) {
		System.out.println("CreateNewContact");
		driver.findElement(NewContactsBtn).click();
		driver.findElement(FirstName).sendKeys(firstName);
		driver.findElement(LastName).sendKeys(lastName);
		driver.findElement(SaveBtn).click();
	}
}
