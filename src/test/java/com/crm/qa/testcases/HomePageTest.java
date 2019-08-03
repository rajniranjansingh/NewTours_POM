package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CruisesPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.RegistrationPage;

public class HomePageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	CruisesPage cruisespage;
	RegistrationPage registerpage;
	
	public HomePageTest() throws IOException {
		
		super();
	}

	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void HomePageTitleTest()
	{
		String HomePage_Title = homepage.validateHomePageTitle();
		Assert.assertEquals(HomePage_Title, "Find a Flight: Mercury Tours:", "Home Page Title is not correct");
	}
	
	@Test(priority=2)
	public void SignOffButtonTest()
	{
		Assert.assertTrue(homepage.verifySignOffButton(), "SignOff Button not present");
	}
	
	@Test(priority=3)
	public void ClickOnCruisesPageButtonTest() throws IOException
	{
		cruisespage = homepage.clickonCruises();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
