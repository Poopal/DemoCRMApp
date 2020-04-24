	package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(name="username")
	WebElement username;
	
	
	//PageFactory =OR
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath= "//input[@type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath= "//input[contains(text(),'Sign Up')]")
	WebElement SignUp;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement CRMlogo;
	
	//Initializing the Page Objects
	public LoginPage() throws IOException {
	     PageFactory.initElements(driver, this);
		}
	
	//Actions
	public String validateLoginPage() {
		return driver.getTitle();
	}
	
	public boolean  CRMImage() {
		return CRMlogo.isDisplayed();
	}
	
	public HomePage Login(String un, String pwd) throws IOException {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		
		return new HomePage();
		
	}
	
	
}
