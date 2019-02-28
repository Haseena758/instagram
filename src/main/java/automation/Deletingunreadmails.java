package automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Deletingunreadmails {
	private WebDriver w = null;

	public Deletingunreadmails(WebDriver w) {
		this.w = w;

	}

	public void delete() {
		System.out.println("deleting unread mails");
		List<WebElement> lst = w.findElements(By.xpath("//tr[@class='zA zE']"));
		for (int j = 1; j <= lst.size(); j++) {
			List<WebElement> lt = w.findElements(By.xpath("//*[@role='checkbox']"));
			for (int i = j; i <= lt.size(); i++) {

				{
						lt.get(j).click();
					w.findElement(By.xpath("//div[@data-tooltip='Delete']")).click();
				}
			}
		}
		System.out.println("delete operation is also performed");

	}

}
