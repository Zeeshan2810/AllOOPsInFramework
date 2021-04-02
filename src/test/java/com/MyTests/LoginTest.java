/**
 * 
 */
package com.MyTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mypages.HomePage;
import com.mypages.LoginPage;

/**
 * @author GVHK9782
 *
 */
public class LoginTest extends BaseTest {
	
	@Test(priority=1, enabled=false)
	public void verifyLoginPageTitleTest() {	
		String title = page.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title,"HubSpot Login");
	}
	
	@Test(priority=2,enabled=false)
	public void verifyLoginPageHeaderTest() {
		String header = page.getInstance(LoginPage.class).getLoginPageHeader();
		System.out.println(header);
		Assert.assertEquals(header,"Don't have an account?");
	}
	
	@Test(priority=3)
	public void doLoginTest() throws InterruptedException {

		HomePage homePage = page.getInstance(LoginPage.class).doLogin("zeeshan2810ahmed@gmail.com", "Zunno@135");
		String headerHome = homePage.getHomePageHeader();
		System.out.println(headerHome);
		Assert.assertEquals(headerHome, "User Guide");
	}

}
