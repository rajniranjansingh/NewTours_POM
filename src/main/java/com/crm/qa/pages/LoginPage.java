package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory - OR
	@FindBy(name="userName")
	WebElement Username;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(name="login")
	WebElement SubmitButton;
	
	@FindBy(xpath="//a[contains(text(),'REGISTER')]")
	WebElement RegisterButton;
	
	@FindBy(xpath="//img[@alt='Featured Destination: Aruba']")
	WebElement LoginPageImage;
	
	public LoginPage() throws IOException{

		super();
		System.out.println("You landed on Login Page");
		PageFactory.initElements(driver, this); //This is to initialize all current class variables with driver
	}

	public String validateLoginPageTitle()
	{
		String LoginPage_Title = driver.getTitle();
		return LoginPage_Title;
	}
	
	public boolean validteLoginPageImage() 
	{
		boolean LoginPageImagePresent = LoginPageImage.isDisplayed();
		return LoginPageImagePresent;
	}
	
	public HomePage login(String un,String pwd) throws IOException
	{
		Username.sendKeys(un);
		Password.sendKeys(pwd);
		SubmitButton.click();
		return new HomePage();
	}
	
	public RegistrationPage ClickOnRegister() throws IOException
	{
		RegisterButton.click();
		return new RegistrationPage();
	}
}
