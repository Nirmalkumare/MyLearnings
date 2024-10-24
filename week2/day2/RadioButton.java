package week2.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class RadioButton {

	public static void main(String[] args) throws InterruptedException {
		String url1 = "https://www.leafground.com/radio.xhtml";
		// driver initialization
		EdgeDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.manage().window().maximize();
		driver.get(url1);
		Thread.sleep(2000);

// test 1
		WebElement selEdgeSpan = driver.findElement(By.xpath("//*[text()='Your most favorite browser']//following-sibling::div//tr/td/label[text()='Edge']/preceding-sibling::div/div[2]/span"));
		WebElement selEdgeInput = driver.findElement(By.xpath("//*[text()='Your most favorite browser']//following-sibling::div//tr/td/label[text()='Edge']/preceding-sibling::div/div[1]/input"));
		if (selEdgeInput.isSelected()) {
			System.out.println("Edge already selected as favourite browser");
		} else {
			selEdgeSpan.click();
			System.out.println("Edge selected as favourite browser now");
		}
		Thread.sleep(2000);

// test 2
		selEdgeSpan.click();
		if (selEdgeSpan.isEnabled()) {
			System.out.println("selection is still enabled after second click");
		} else {
			System.out.println("selection is disabled after second click");
		}
		Thread.sleep(2000);

// test 3
		WebElement br1 = driver.findElement(By.xpath(
				"(//*[text()='Find the default select radio button']//following-sibling::div//tr/td/label/preceding-sibling::div/div[1]/input)[1]"));
		WebElement br2 = driver.findElement(By.xpath(
				"(//*[text()='Find the default select radio button']//following-sibling::div//tr/td/label/preceding-sibling::div/div[1]/input)[2]"));
		WebElement br3 = driver.findElement(By.xpath(
				"(//*[text()='Find the default select radio button']//following-sibling::div//tr/td/label/preceding-sibling::div/div[1]/input)[3]"));
		WebElement br4 = driver.findElement(By.xpath(
				"(//*[text()='Find the default select radio button']//following-sibling::div//tr/td/label/preceding-sibling::div/div[1]/input)[4]"));
		if (br1.isSelected()) {
			System.out.println("Default selected browser is Chrome");
		} else if (br2.isSelected()) {
			System.out.println("Default selected browser is Firefox");
		} else if (br3.isSelected()) {
			System.out.println("Default selected browser is Safari");
		} else if (br4.isSelected()) {
			System.out.println("Default selected browser is Edge");
		} else {
			System.out.println("No Browser selected by default");
		}
		Thread.sleep(2000);

// test 4
		WebElement ageSetInput = driver.findElement(By.xpath("(//*[contains(text(),'Select the age group')]/following-sibling::div//div[1]/input)[2]"));
		WebElement ageSetSpan = driver.findElement(By.xpath("(//*[contains(text(),'Select the age group')]/following-sibling::div//div[2]/span)[2]"));
		if (ageSetInput.isSelected()) {
			System.out.println("Age 21-40 Years already selected");
		} else {
			ageSetSpan.click();
			System.out.println(" Age 21-40 Years selected now");
		}
		Thread.sleep(2000);
		driver.quit();
		Thread.sleep(2000);
	}
}