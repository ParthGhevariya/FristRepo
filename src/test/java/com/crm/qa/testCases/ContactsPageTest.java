package com.crm.qa.testCases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.login();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel() {
		
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contact label is missing.");
	}
	
	@Test(priority=2)
	public void verifySelectContact() {
		contactsPage.selectContacts();
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException {
		
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=3, dataProvider="getCRMTestData")
	public void verifyCreateNewContact(String fristName, String lastName, String email){
		//homePage.clickOnContactsLink();
		//contactsPage.createNewContact("mr.", "patel", "mr.patel@gmail.com");
		
		contactsPage.createNewContact(fristName, lastName, email);
		
		
	}
	
	
	
	@AfterMethod
	public void tearDowm() {
		driver.quit();
	}

}
