package automation;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchingforMail {
	private WebDriver w = null;

	public SearchingforMail(WebDriver w) {
		this.w = w;
	}

	public void search() throws Exception {
		w.navigate().refresh();
		WebElement search = w.findElement(By.xpath("//input[@aria-label='Search mail']"));
		search.sendKeys("testing compose mail ");
		Thread.sleep(1000);
		search.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		try {
			List<WebElement> list = w.findElements(By.xpath("//*[@role='checkbox']"));
			for (int i = 1; i <= list.size() - 1; i++) {
				Thread.sleep(1000);
				list.get(i).click();
			w.findElement(By.xpath("//div[@data-tooltip='Delete']")).click();
			System.out.println("loop search completed");}
			
		} 
	
		catch (NoSuchElementException ex) {
			System.out.println("no elements found");
		}
		System.out.println("search completed");
	}
}
