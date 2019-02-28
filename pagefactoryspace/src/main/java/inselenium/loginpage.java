package inselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class loginpage {
	WebDriver driver;
	public loginpage(WebDriver driver)
	{
		this.driver=driver;
	}
	//instagram
	@CacheLookup
		@FindBy(name="username") //username
		WebElement username;
	@CacheLookup
		@FindBy(how=How.NAME,using="password")
		WebElement pwd;
	@CacheLookup
		@FindBy(xpath="//*[@id='react-root']/section/main/div/article/div/div[1]/div/form/div[3]/button")
		WebElement loginbutton;
	@CacheLookup
	    @FindBy(how=How.LINK_TEXT,using="Forgot password?")
	    WebElement forgotpassword;
	    public void loginaccount(String uname,String pswd)
	    {
	    	username.sendKeys(uname);
	    	pwd.sendKeys(pswd);
	    }

}
