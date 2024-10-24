package week2.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class RadioButtontemp {

	public static void main(String[] args) throws InterruptedException {
		String url1 = "https://www.leafground.com/radio.xhtml";
		// driver initialization
		EdgeDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.manage().window().maximize();
		driver.get(url1);
		Thread.sleep(4000);

		WebElement selEdgeSpan = driver.findElement(By.xpath("//*[text()='Your most favorite browser']//following-sibling::div//tr/td/label[text()='Edge']/preceding-sibling::div/div[2]/span"));
		WebElement selEdgeInput = driver.findElement(By.xpath("//*[text()='Your most favorite browser']//following-sibling::div//tr/td/label[text()='Edge']/preceding-sibling::div/div[1]/input"));
		if (selEdgeInput.isSelected()) {
			System.out.println("Edge already selected as favourite browser");
		} else {
			selEdgeSpan.click();
			System.out.println("Edge selected as favourite browser now");
		}
		Thread.sleep(2000);
	}
}