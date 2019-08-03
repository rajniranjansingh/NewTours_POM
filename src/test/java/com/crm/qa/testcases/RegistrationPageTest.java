package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.RegistrationPage;
import com.crm.qa.util.TestUtil;

public class RegistrationPageTest extends TestBase{

	LoginPage loginpage;
	RegistrationPage registrationpage;
	
	public RegistrationPageTest() throws IOException {
		
		super();
	}

	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		loginpage = new LoginPage();
		registrationpage = loginpage.ClickOnRegister();
	}
	
	@Test(priority=1)
	public void RegistrationPage_TitleTest()
	{
		String RegistrationPage_Title = registrationpage.RegistrationPageTitle();
		Assert.assertEquals(RegistrationPage_Title, "Register: Mercury Tours", "Registration Page Title is not correct");
	}
	
	@Test(priority=2)
	public void ContactInformationTagTest()
	{
		Assert.assertTrue(registrationpage.ContactInformationTag(), "Contact Information tag is not present");
	}
	
	@DataProvider
	public Object[][] getRegistrationFormData() throws EncryptedDocumentException, IOException
	{
		Object data[][] = TestUtil.getTestData(prop.getProperty("sheetname"));
		return data;
	}
	
	@Test(priority=3, dataProvider="getRegistrationFormData")
	public void FillRegistrationFormTest(String fn, String ln, String pho, String em, String add1, String add2, String ct, String st, 
			String pc, String ctry, String Uname, String pwd, String cpwd)
	{
		Assert.assertTrue(registrationpage.FillRegistrationForm(fn, ln, pho, em, add1, add2, ct, st, pc, ctry, Uname, pwd, cpwd), "Registration Page "
				+ "is not filled properly");
		
//		Assert.assertTrue(registrationpage.FillRegistrationForm("a", "a", "a", "a", "a", "a", "a", "a", "a", "INDIA", "a", "a", "a"), "Registration Page "
//				+ "is not filled properly");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
