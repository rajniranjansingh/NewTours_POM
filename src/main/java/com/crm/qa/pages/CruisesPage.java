package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CruisesPage extends TestBase{

	//Page Factory - OR
	@FindBy(xpath = "//span[contains(text(),'Cruise Itinerary ')]")
	WebElement CruiseItinerary;
	
	
	public CruisesPage() throws IOException {
		
		super();
		System.out.println("You landed on Cruises Page");
		PageFactory.initElements(driver, this);
	}

	public String verifyCruisesPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyCruiseItinerary()
	{
		return CruiseItinerary.isDisplayed();
	}
}
