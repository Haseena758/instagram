package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GmailLogin {

	private WebDriver w;

	public GmailLogin(WebDriver w) {
		this.w = w;
	}

	public void verifyGmailTitle() {
		String actualtitle = w.getTitle();
		String expectedtitle = "Gmail";
		Assert.assertEquals(expectedtitle, actualtitle);
		System.out.println("Title is Gmail");
	}

	public void login(String uname, String pwd) throws Exception {
		if (isGmailAlreadyOpened()) {
			Thread.sleep(1000);
			this.w.findElement(By.xpath("//span[@class='gb_cb gbii']")).click();
			Thread.sleep(1000);
			this.w.findElement(By.xpath("//a[text()='Sign out']")).click();
		} else // if login credential is asked
		{
			Thread.sleep(2000);
			this.w.findElement(By.name("identifier")).sendKeys(uname);
			this.w.findElement(By.id("identifierNext")).click();
			Thread.sleep(2000);
			this.w.findElement(By.name("password")).sendKeys(pwd);
			this.w.findElement(By.id("passwordNext")).click();
		}

	}

	private boolean isGmailAlreadyOpened() {
		try {
			WebElement element = w.findElement(By.xpath("//span[@class='gb_cb gbii']"));
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}

	}

}
