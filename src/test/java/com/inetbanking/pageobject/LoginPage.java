package com.inetbanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	//object repository
	@FindBy(name = "uid")
	WebElement txt_uname;
	
	
	@FindBy(name = "password")
	WebElement txt_pass;
	
	@FindBy(name = "btnLogin")
	WebElement loginBtn;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setUserId(String username) {
		
		txt_uname.sendKeys(username);
		
	}
	
	public void setPassword(String password) {
		
		txt_pass.sendKeys(password);
		
		
	}
	
	public void clickOnLoginButton() {
		loginBtn.click();
		
	}
}
