/**
 * 
 */
package com.MyTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.mypages.BasePage;
import com.mypages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author GVHK9782
 *
 */
public class BaseTest {
	
	WebDriver driver;
	public Page page;
	
	@BeforeMethod
	@Parameters(value = {"browser"})
	public void setUpTest(String browser) throws InterruptedException {
		
		if(browser.equals("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "//drivers/chromedriver.exe");
			//driver = new ChromeDriver();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equals("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("No browser is defined in xml files");
		}
		
		driver.get("https://app.hubspot.com/login");
		Thread.sleep(15000);
		page = new BasePage(driver);  // This is used to supply this driver to all the classes
	}
	
	@AfterMethod
	public void tearDownTest() {
		
		driver.quit();
	}
	

}
