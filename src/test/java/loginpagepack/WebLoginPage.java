package loginpagepack;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import datapack.ExcelClass;

public class WebLoginPage {
	WebDriver driver;
	ExcelClass data;
	@FindBy(name = "username")//path for username
	WebElement username;
	@FindBy(name = "password")//path for password
	WebElement password;
	@FindBy(name = "signon")//path for signon
	WebElement login;
	@FindBy(linkText ="Register Now!")//path for register
	WebElement register;

	public void SigninPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void send_User1(String usernamedata, String passworddata) throws IOException {
		username.clear();//clear the userid box 
		password.clear();//clear the password box

		

		username.sendKeys(usernamedata);//taking username1 from excel sheet
		password.sendKeys(passworddata);//taking password1 from excel sheet
	}

	

	public void click_register() {
		register.click();
	}

	public void click_login() {
		// TODO Auto-generated method stub
		login.click();

	}


}
