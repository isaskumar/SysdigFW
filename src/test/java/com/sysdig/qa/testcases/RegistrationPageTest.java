package com.sysdig.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sysdig.qa.base.TestBase;
import com.sysdig.qa.pages.RegistrationPage;
import com.sysdig.qa.util.TestUtil;

public class RegistrationPageTest extends TestBase{

	RegistrationPage registrationPage;


	public RegistrationPageTest() {
		super();
	}

	@BeforeTest
	public void setup() {
		initialization();
		registrationPage = new RegistrationPage();
	}

	@Test
	public void loginPageTitleTest() {

		// Accept cookies
		registrationPage.cookieBar();

		// Verifying the page title
		String title = registrationPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free Trial Sign-Up (no credit card required) | Sysdig Secure");

		// Verifying the header brand logo
		boolean flag = registrationPage.validateSysdigLogo();
		Assert.assertTrue(flag);

		// Customer registration
		registrationPage.login(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("email"), prop.getProperty("company"));

		//Select country from dropdown
		registrationPage.countrylist(prop.getProperty("countryName"));

		//Select trail type from dropdown
		registrationPage.trailType(prop.getProperty("trailName"));
	}


	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
