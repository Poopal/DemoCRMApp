package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	
	@FindBy(xpath ="//td[contains(text(),'Contacts')]")
	WebElement contactLabel;
	
	@FindBy(xpath ="//a[title='New Contact']")
	WebElement newContact;
	
	@FindBy(name="title")
	WebElement titleValue;
	
	
	@FindBy(name ="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement companyName;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement saveButton;
	
	
	public ContactsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLabel() {
		return contactLabel.isDisplayed();
	}
	
	
	public void verifyNewContact(String title, String fname, String lname, String company) {
		Select dropdown = new Select(titleValue);
		dropdown.selectByVisibleText(title);
		
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		companyName.sendKeys(company);
		saveButton.click();
		
	}
}
