package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{

	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//homePage.login();
		
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
	
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Free CRM - CRM software for customer relationship management, sales, and support.");;
		
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() throws InterruptedException {
		homePage.login();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() throws InterruptedException {
		homePage.login();
		contactsPage = homePage.clickOnContactsLink();
		
	}
	
	@Test(priority=4)
	public void verifyDealsLinkTest() throws InterruptedException {
		homePage.login();
		dealsPage = homePage.clickOnDealsLink();
		
	}
	
	@AfterMethod
	public void tearDowm() {
		driver.quit();
	}
	
	
}
