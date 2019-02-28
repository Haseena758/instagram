package inselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import browserlaunch.browser;


public class verifyvalidlogin {
	@Test
	public void checklogin()
	{
		//this will launch browser
		WebDriver driver=browser.startBrowser("chrome","https://www.instagram.com/accounts/login/");//driver which is returned can catch this
		//this will create object to pagefactory
	loginpage log=PageFactory.initElements(driver,loginpage.class);	
	log.loginaccount("pathanhaseena3@gmail.com", "hello@1234");
	System.out.println("login sucessful");
}

}
