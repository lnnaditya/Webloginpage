package testpack;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import datapack.ExcelClass;
import loginpagepack.WebLoginPage;
import webbuildpack.WebSetupClass;

public class LoginTest {
	
	//WebDriver driver;
	ExcelClass data=new ExcelClass();
	WebSetupClass setup=new WebSetupClass() ;
	@BeforeSuite
	public void registerWebDriver() {
		
		setup.launchApplication("chrome", "https://petstore.octoperf.com/actions/Catalog.action");
		
	}


	@DataProvider(name = "user_credentails")
	public Object[][] getData() {

		// data-source : .xlsx
		 return data.getXLSXFile("user_credentials.xlsx");
	}

	@Test(dataProvider = "user_credentails")
	public void login(String username, String password) throws IOException {
		WebLoginPage loginpage=new WebLoginPage();
		loginpage.send_User1("username", "password");
		
		
		

	}

	@AfterTest
	public void closeBrowser() {
		setup.quit();
	}

		

}
