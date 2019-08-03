package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CruisesPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class CruisesPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	CruisesPage cruisespage;

	public CruisesPageTest() throws IOException {
		
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		cruisespage = homepage.clickonCruises();
	}

	@Test(priority=1)
	public void verifyCruisePageTitleTest()
	{
		String CruisesPage_Title = cruisespage.verifyCruisesPageTitle();
		Assert.assertEquals(CruisesPage_Title, "Cruises: Mercury Tours", "Cruise Page Title is not correct");
	}
	
	@Test(priority=2)
	public void verifyCruiseItineraryTest()
	{
		Assert.assertTrue(cruisespage.verifyCruiseItinerary(),"Cruise Itinerary is not Present");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
