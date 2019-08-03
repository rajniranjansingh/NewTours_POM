package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	//Page Factory - OR
	@FindBy(xpath="//a[contains(text(),'SIGN-OFF')]")
	WebElement SignOffButton;
	
	@FindBy(xpath="//a[contains(text(),'Flights')]")
	WebElement FlightsButton;
	
	@FindBy(xpath="//a[contains(text(),'Hotels')]")
	WebElement HotelsButton;
	
	@FindBy(xpath="//a[contains(text(),'Cruises')]")
	WebElement CruisesButton;
	
	public HomePage() throws IOException {

		super();
		System.out.println("You landed on Home Page");
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle()
	{
		String HomePage_Title = driver.getTitle();
		return HomePage_Title;
	}
	
	public boolean verifySignOffButton()
	{
		boolean SignOffButtonPresent = SignOffButton.isDisplayed();
		return SignOffButtonPresent;
	}
	
	public HotelsPage clickonHotels() throws IOException
	{
		HotelsButton.click();
		return new HotelsPage();
	}
	
	public CruisesPage clickonCruises() throws IOException
	{
		CruisesButton.click();
		return new CruisesPage();
	}
}
