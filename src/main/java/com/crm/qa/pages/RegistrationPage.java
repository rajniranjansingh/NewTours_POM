package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class RegistrationPage extends TestBase{

	//Page Factory - OR
	@FindBy(xpath="//font[contains(text(),'Contact')]")
	WebElement ContactInformation_Tag;
	
	@FindBy(name="firstName")
	WebElement firstname;
	
	@FindBy(name="lastName")
	WebElement lastname;
	
	@FindBy(name="phone")
	WebElement phone;
	
	@FindBy(name="userName")
	WebElement email;
	
	@FindBy(name="address1")
	WebElement address1;
	
	@FindBy(name="address2")
	WebElement address2;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="postalCode")
	WebElement postalCode;
	
	@FindBy(name="country")
	WebElement country;
	
	@FindBy(name="email")
	WebElement UserName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="confirmPassword")
	WebElement confirmPassword;
	
	@FindBy(name="register")
	WebElement submitButton;
	
	@FindBy(xpath="//font[contains(text(),' Thank you for registering.')]")
	WebElement RegistrationConfirm;
	
	public RegistrationPage() throws IOException {
		
		super();
		System.out.println("You landed on Regitration Page");
		PageFactory.initElements(driver, this);
	}
	
	public String RegistrationPageTitle()
	{
		String RegistrationPage_Title = driver.getTitle();
		return RegistrationPage_Title;
	}
	
	public boolean ContactInformationTag()
	{
		boolean ContactInformationTagPresent = ContactInformation_Tag.isDisplayed();
		return ContactInformationTagPresent;
	}
	
	public boolean FillRegistrationForm(String fn, String ln, String pho, String em, String add1, String add2, String ct, String st, 
			String pc, String ctry, String Uname, String pwd, String cpwd)
	{
		
		firstname.sendKeys(fn);
		lastname.sendKeys(ln);
		phone.sendKeys(pho);
		email.sendKeys(em);
		address1.sendKeys(add1);
		address2.sendKeys(add2);
		city.sendKeys(ct);
		state.sendKeys(st);
		postalCode.sendKeys(pc);
		Select select = new Select(country);
		select.selectByVisibleText(ctry);
		UserName.sendKeys(Uname);
		password.sendKeys(pwd);
		confirmPassword.sendKeys(cpwd);
		submitButton.click();
		return RegistrationConfirm.isDisplayed();
	}

}
