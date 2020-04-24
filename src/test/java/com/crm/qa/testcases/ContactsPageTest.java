package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;

	String sheetName = "Contacts";

	public ContactsPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();

	}

	@Test(priority = 1)
	public void verifyContactLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	}

	@DataProvider
	public Object[][] getTestData() {
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 2, dataProvider = "getTestData")
	public void validateNewContact(String title, String firstname, String lastname, String company) throws IOException {
		homePage.clickOnNewContactLink();
		//contactsPage.verifyNewContact("Mrs.", "swetha", "ganta", "amazon");
		contactsPage.verifyNewContact(title, firstname, lastname, company);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
