package automation;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComposeMail {
	private WebDriver w = null;

	public ComposeMail(WebDriver w) {
		this.w = w;
	}

	public void Compose(String to) throws Exception {
		w.findElement(By.xpath("//div[text()='Compose']")).click();// click on compose
		Thread.sleep(2000);
		w.findElement(By.name("to")).sendKeys(to);
		Thread.sleep(1000);
		w.findElement(By.name("subjectbox")).sendKeys("testing compose mail");
		Thread.sleep(2000);
		WebElement el = w.findElement(By.xpath("//div[@aria-label='Attach files']"));// attching file
		el.click();
		try {

			Thread.sleep(1000);
			Robot r = new Robot();
			Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_1);
			Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
			w.findElement(By.xpath("//div[text()='Send']")).click();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("interruption occured");

			Alert a = w.switchTo().alert();
			a.accept();
			Thread.sleep(1000);
			w.findElement(
					By.xpath("//div[text()='Send']")).click();
		}
	}

	public void takingScreenshot() throws Exception {
		File screenshotFile = ((TakesScreenshot) this.w).getScreenshotAs(OutputType.FILE);// taking screenshot of
																							// compose mail
		FileUtils.copyFile(screenshotFile, new File("C:\\MavenWorkspace\\composemail.png"));
		System.out.println("screenshot taken");

	}
}
