package testpack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import datapack.ExcelClass;
import loginpagepack.WebLoginPage;
import webbuildpack.WebSetupClass;

public class LoginTest extends WebSetupClass {
	
	//WebDriver driver;
	//ExcelClass data=new ExcelClass();
	//WebSetupClass setup=new WebSetupClass() ;
	@BeforeSuite
	public void registerWebDriver() {
		
		launchApplication("chrome", "https://petstore.octoperf.com/actions/Catalog.action");
		
	}


	
	@Test(dataProvider = "user_credentails")
	public void login(String username, String password) throws IOException {
		WebLoginPage loginpage=new WebLoginPage(driver);
		loginpage.click_signin();
		loginpage.send_User1(username, password);
		loginpage.click_login();
	}
	
	
	@DataProvider(name = "user_credentails")
	public Object[][] getData() {
		ExcelClass data=new ExcelClass();
		// data-source : .xlsx
		 return data.getXLSXFile("logindetails.xlsx");
		
		}

	
	

	@AfterTest
	public void closeBrowser() {
		//setup.quit();
	}

		

}
