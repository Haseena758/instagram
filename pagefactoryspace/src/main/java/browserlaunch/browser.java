package browserlaunch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class browser {
	
	 static WebDriver driver;
	public static WebDriver startBrowser(String browser,String url) {

		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("WebDriver.chromedriver", "C:\\MavenWorkspace\\pagefactoryspace\\src\\test\\resources\\chromedriver.exe");
			
			driver=new ChromeDriver();
			
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			//System.setProperty("WebDriver.firefoxdriver", "C:\\MavenWorkspace\\pagefactoryspace\\src\\test\\resources\\firefoxdriver.exe");
		}

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
		

}
}
