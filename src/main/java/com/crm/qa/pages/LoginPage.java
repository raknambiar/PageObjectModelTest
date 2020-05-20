package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	/*
	 * public LoginPage() { 
	 * PageFactory.initElements(driver, this); 
	 * // this.driver =driver; // TODO Auto-generated constructor stub }
	 */
	/*
	 * @FindBy (name = "email") 
	 * WebElement Username;
	 * 
	 * @FindBy (name = "password") 
	 * WebElement Password;
	 * 
	 * @FindBy (className = "ui fluid large blue submit button") 
	 * WebElement
	 * loginBtn;
	 */
	
	By User = By.name("email");
	By Pass = By.name("password");
	By Btn = By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]");
	
	
	
	public void login(String uname, String pwd) {
		System.out.println("in login");
		System.out.println(uname);
//		driver.findElement(By.name("email")).sendKeys(uname);
//		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(User).sendKeys(uname);
		driver.findElement(Pass).sendKeys(pwd);
		driver.findElement(Btn).click();
//		Username.sendKeys(uname);
//		Password.sendKeys(pwd);
//		loginBtn.click();

	}
	public String validateLoginPageTitle() {
		System.out.println("in validateLoginPageTitle");
		return driver.getTitle();
		
	}
	
	

}
