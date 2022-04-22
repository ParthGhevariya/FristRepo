package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase  {
	
	// Page Factory for contacts page 
	@FindBy(xpath = "//div[@id='main-content']//div[1]//div[1]//div[contains(text(), 'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath = "(//input[@name='id'])[2]")
	WebElement selectContact;
	
	@FindBy(xpath = "//button[text()='Create']")
	WebElement createBtn;
	
	@FindBy(name = "first_name")
	WebElement fristName;
	
	@FindBy(name = "last_name")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@placeholder='Email address']")
	WebElement emailAddress;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveBtn;
	
	
	//initializing page object
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	
	/*
	// we create this method because we need to change xpath for every contacts in list
	// by using this we won't need to give xpath everytime .
	
	public void selectContacts(String name) {
		
		driver.findElement(By.xpath("enter xpath here"));
		
	}
	*/
	
	public void selectContacts() {
		selectContact.click();
	}
	
	public void createNewContact(String ftName, String ltName, String email) {
		
		createBtn.click();
		fristName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		emailAddress.sendKeys(email);

		saveBtn.click();
		
	}
	
}
