package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.crm.qa.base.TestBase;

public class HomePage extends TestBase  {
	
		LoginPage loginPage;
			
	// Page Factory for HomePAge -  OR(object repo.) 
	
		@FindBy(linkText = "Sign Up")
		WebElement signup;
		
		@FindBy(xpath = "//span[@class='user-display']")
		WebElement userNameLabel;
		
		@FindBy(xpath = "//i[@class='users icon']//parent::a[@class='item']")
		@CacheLookup
		WebElement contactsLink;

		@FindBy(xpath = "//div[@id='main-nav']/div[5]/a")
		WebElement dealsLink;
		
		@FindBy(xpath = "//span[contains(text(),'Tasks')]")
		WebElement tasksLink;
		
		@FindBy(xpath = "//input[@placeholder='Password']")
		WebElement pass;
		
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		
		public String verifyHomePageTitle() {
			
			return driver.getTitle();
		}
		
		public SignUpPage login() throws InterruptedException{
			loginPage = new LoginPage();
			loginPage.signUp.click();
			loginPage.email.sendKeys("parthghevariyakobdi@gmail.com");
			pass.sendKeys("Login@123");
			loginPage.login.click();
			//Thread.sleep(3000);
			return new SignUpPage();
		}
		public boolean verifyCorrectUserName() {
			
			loginPage = new LoginPage();
			return userNameLabel.isDisplayed();
			
		}
		
		public ContactsPage clickOnContactsLink() {
			Actions action = new Actions(driver);
			action.moveToElement(contactsLink).build().perform();
			contactsLink.click();
			return new ContactsPage();
		}
		
		
		public DealsPage clickOnDealsLink() {
			dealsLink.click();
			return new DealsPage();
		}
		
		public TasksPage clickOnTasksLink() {
			tasksLink.click();
			return new TasksPage();
		}

		
}
