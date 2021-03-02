package com.sysdig.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sysdig.qa.base.TestBase;

public class RegistrationPage extends TestBase {


	//PageFactory
	@FindBy(xpath="//a[@id='CybotCookiebotDialogBodyButtonAccept']")
	WebElement cookieBtn;

	@FindBy(xpath="//*[@id='site-nav-desktop-primary-inner']/a/img")
	WebElement logo;

	@FindBy(name="FirstName")
	WebElement firstName;

	@FindBy(name="LastName")
	WebElement lastName;

	@FindBy(name="Email")
	WebElement email;

	@FindBy(name="Company")
	WebElement companyName;

	@FindBy(name="Country")
	WebElement countryName;

	@FindBy(name="Trial_Type__c")
	WebElement trialType;

	//intializing the page objects
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}

	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateSysdigLogo() {
		return logo.isDisplayed();
	}

	public void cookieBar() {
		cookieBtn.click();
	}

	public void login(String fname, String lname, String cemail, String cname) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		email.sendKeys(cemail);
		companyName.sendKeys(cname);
	}

	public void countrylist(String countryn) {
		Select select = new Select(countryName);
		select.selectByVisibleText(countryn);
	}

	public void trailType(String trailName) {
		Select select = new Select(trialType);
		select.selectByVisibleText(trailName);
	}

}
