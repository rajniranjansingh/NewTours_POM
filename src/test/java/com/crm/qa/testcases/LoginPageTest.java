package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() throws IOException {
		
		super();
	}

	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest()
	{
		String LoginPage_Title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(LoginPage_Title, "Welcome: Mercury Tours", "Login Page Title is not correct");
	}
	
	@Test(priority=2)
	public void LoginPageImageTest()
	{
		Assert.assertTrue(loginpage.validteLoginPageImage(), "Correct Image is not present");
	}
	
	@Test(priority=3)
	public void LoginTest() throws IOException
	{
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
