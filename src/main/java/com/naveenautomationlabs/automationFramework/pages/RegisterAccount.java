package com.naveenautomationlabs.automationFramework.pages;

import java.util.UUID;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.naveenautomationlabs.automationFramework.base.TestBase;

public class RegisterAccount extends TestBase {
	public RegisterAccount() {
		PageFactory.initElements(wd, this);
	}

	@BeforeMethod
	public void setUp() {
		intialisation();

	}

	public static String randomEmail = UUID.randomUUID().toString() + "@email.com"; // To generate unique random emailId.
	public static  String randomPassword = UUID.randomUUID().toString().substring(0, 8); // To generate unique random password.
	
	
	@FindBy(css = "#input-firstname")
	private WebElement firstNameField;

	@FindBy(css = "#input-lastname")
	private WebElement lastNameField;

	@FindBy(css = "#input-email")
	private WebElement email;

	@FindBy(css = "#input-telephone")
	private WebElement telephone;

	@FindBy(css = "#input-password")
	private WebElement password;

	@FindBy(css = "#input-confirm")
	private WebElement confirmPassword;

	@FindBy(xpath  = "(//input[@name='newsletter']) [1]")
	private WebElement subscribeYesRadioBtn;

	@FindBy(css = "input[type='checkbox']")
	private WebElement privacyPolicyCheckBox;

	@FindBy(css = "input[type='submit']")
	private WebElement continueBtn;
	
	@FindBy(css = "div.alert")
	private WebElement emailAlreadyExitsMessage;

	private void enetrFirstName() {
		firstNameField.sendKeys("Manpreetsaini");
	}

	private void enetrLastName() {
		lastNameField.sendKeys("Kaur");
	}

	private void enetrEmail() {
		email.sendKeys(randomEmail);
	}

	private void enetrTelephone() {
		telephone.sendKeys("123456789");
	}

	private void enetrPassword() {
		password.sendKeys(randomPassword);
	}

	private void enetrConfirmPassword() {
		confirmPassword.sendKeys(randomPassword);
	}

	private void selectSubscribeYesRadioBtn() {
		subscribeYesRadioBtn.isSelected();
	}

	private void selectPrivacyPolicyCheckBox() {
		privacyPolicyCheckBox.click();
	}

	public AccountHasBeenCreated enterValidDetailsToRegisterUser() {
		enetrFirstName();
		enetrLastName();
		enetrEmail();
		enetrTelephone();
		enetrPassword();
		enetrConfirmPassword();
		selectSubscribeYesRadioBtn();
		selectPrivacyPolicyCheckBox();
		continueBtn.submit();
		return new AccountHasBeenCreated();
	}

	
	
	public RegisterAccount enterDetailsWithAlreadyRegisteredEmail() {
		enetrFirstName();
		enetrLastName();
		enetrEmail();
		enetrTelephone();
		enetrPassword();
		enetrConfirmPassword();
		selectSubscribeYesRadioBtn();
		selectPrivacyPolicyCheckBox();
		continueBtn.submit();
		return new RegisterAccount();
	}

	
	
	public String getEmailAlreadyEixtsMessage() {
		return emailAlreadyExitsMessage.getText();
		
	}
	@AfterMethod
	public void quit() {
		tearDown();
	}

}
