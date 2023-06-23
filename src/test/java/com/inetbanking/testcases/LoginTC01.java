package com.inetbanking.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobject.LoginPage;
import com.inetbanking.testbase.TestBase;

public class LoginTC01 extends TestBase{

	

	@Test
	public void verifyLoginFunctionality() 
	{
		//mngr484330
		//syzyjYd
		
		
		LoginPage login = new LoginPage(driver);
		
//		login.setUserId("mngr484330");
//		login.setPassword("syzyjYd@@");
		
		
		login.setUserId(configDataProvider.getUserName());
		login.setPassword(configDataProvider.getUserPassword());
		login.clickOnLoginButton();
	
	
	//GTPL Bank  Home Page
	
	String expectedTitle=   "GTPL Bank  Home Page";                              //"GTPL Bank Manager HomePage";
	
	
	if(driver.getTitle().equals(expectedTitle))
	{
		Assert.assertTrue(true);
		System.out.println("Login successfully!!!");
	}
	else
	{
		System.out.println("Login failed, Invalid Username and Password !!!");
		Assert.assertTrue(false);
		
	}
}
}
