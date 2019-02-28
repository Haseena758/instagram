package SmokeTest;

import java.io.File;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.google.common.io.Resources;

import automation.ComposeMail;
import automation.Deletingunreadmails;
import automation.GmailLogin;
import automation.GmailLogout;
import automation.SearchingforMail;
@Listeners(automation.listenersinTesng.class)
public class GmailLoginSmoke {
	private WebDriver w ;
	
	@BeforeMethod
	public void Browserlaunch(ITestContext testContext) throws URISyntaxException {

		String path = null;
		String browser = testContext.getCurrentXmlTest().getParameter("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			path = new File(Resources.getResource("chromedriver.exe").getFile()).getAbsolutePath();
			System.setProperty("webdriver.chrome.driver", path);
			w = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			path = new File(Resources.getResource("geckodriver.exe").getFile()).getAbsolutePath();
			System.setProperty("webdriver.gecko.driver", path);
			w = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			path = new File(Resources.getResource("IEDriverServer.exe").getFile()).getAbsolutePath();
			System.setProperty("webdriver.ie.driver", path);
			w = new InternetExplorerDriver();
		}
		System.out.println(path);
		w.get("https://mail.google.com");
		w.manage().window().maximize();// maximizing
		w.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void alogin() throws Exception {
		GmailLogin G = new GmailLogin(this.w);
		G.verifyGmailTitle();
		G.login("pathanhaseena758", "hello@1234");
		ComposeMail C = new ComposeMail(this.w);
		
		C.Compose("pathanhaseena758@gmail.com");
		C.takingScreenshot();
        //SearchingforMail S=new SearchingforMail(w);
	
		//S.search();
		//Deletingunreadmails D=new Deletingunreadmails(this.w);
		//D.delete();
		GmailLogout L = new GmailLogout(this.w);
		L.Logout();
	}

	@AfterMethod
	public void Browserclose() throws Exception {
		this.w.close();
		//this.w.quit();


	}

}
