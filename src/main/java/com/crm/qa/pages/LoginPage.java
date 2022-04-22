package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	
	// Page Factory -  OR(object repo.) 
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[@class='navbar-brand']/img")
	WebElement crmLogo;
	
	@FindBy(linkText = "Sign Up")
	WebElement signUp;
	
	//password and login button for sign in into account to verify user 
	@FindBy(name = "password")
	WebElement pass;
	
	@FindBy(xpath = "//body/div[@id='ui']/div[1]/div[1]/form[1]/div[1]/div[3]")
	WebElement login;
	
	
	
	//initializing the page objects 
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	//Actionns:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys("un");
		password.sendKeys("pwd");
		loginBtn.click();
		
		return new HomePage();
	}
	
}
