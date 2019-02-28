package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLogout {
	private WebDriver w;

	public GmailLogout(WebDriver w) {
		this.w = w;
	}
	public void Logout() throws Exception {
		
		/*  WebDriverWait wait = new WebDriverWait(this.w, 10);
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 "//a[@href='https://accounts.google.com/SignOutOptions?hl=en&continue=https://mail.google.com/mail&service=mail']"
		 ))) .click();
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='gb_71']"))) .click();*/
		 		
		 
		this.w.findElement(By.xpath(
				"//a[@href='https://accounts.google.com/SignOutOptions?hl=en&continue=https://mail.google.com/mail&service=mail']"))
				.click();

		this.w.findElement(By.xpath("//*[@id='gb_71']")).click();

	}

}
