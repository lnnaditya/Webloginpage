package webbuildpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebSetupClass {
	
protected WebDriver driver;
	
	public void launchApplication(String browser, String url) {
		
		try {
			//To launch firefox BROWSER
			if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",".\\src\\test\\resources\\Driver\\geckodriver.exe");
				//driver = new FirefoxDriver();
			
			
			}
			// TO launch Chrome Browser
			else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",".\\src\\test\\resources\\Driver\\chromedriver.exe");
				driver=new ChromeDriver();

			}
       //to maximize the window
			driver.manage().window().maximize(); 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url);
		
		} catch (WebDriverException e) {
			System.out.println(" browser could not be launched");
		}
	
	}
	//To close the browser
   public void quit(){
		
		driver.close();
   }
  

}
