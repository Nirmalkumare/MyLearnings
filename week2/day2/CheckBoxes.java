package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxes {

	public static void main(String[] args) throws InterruptedException {
		// Leaf Ground application to learn the check boxes
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/checkbox.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
		WebElement basic1 = driver.findElement(By.xpath("//*[text()='Basic Checkbox']/parent::div//div[2]"));
		basic1.click();
		Thread.sleep(2000);
		System.out.println("Test");
		WebElement notification1 = driver.findElement(By.xpath("//*[text()='Notification']/parent::div//div[2]"));
		notification1.click();
		Thread.sleep(2000);
		// multiple check boxes selection
		WebElement lang1 = driver.findElement(By.xpath(
				"//*[contains(text(),'favorite language')]/following-sibling::div//label[text()='Java']/parent::td//div[2]"));
		lang1.click();
		WebElement lang2 = driver.findElement(By.xpath(
				"//*[contains(text(),'favorite language')]/following-sibling::div//label[text()='Python']/parent::td//div[2]"));
		lang2.click();
		Thread.sleep(2000);
		WebElement lang3 = driver.findElement(By.xpath(
				"//*[contains(text(),'favorite language')]/following-sibling::div//label[text()='Others']/parent::td//div[2]"));
		lang3.click();
		Thread.sleep(2000);
		// Tri-check box checking:
		WebElement tricheck1 = driver
				.findElement(By.xpath("//*[text()='Tri State Checkbox']/following-sibling::div//div[2]"));
		System.out.println("Tri check Box is Selected : " + tricheck1.isSelected());
		tricheck1.click();
		Thread.sleep(2000);
		System.out.println("Tri check Box is Displayed : " + tricheck1.isDisplayed());
		System.out.println("Tri check Box is Enabled : " + tricheck1.isEnabled());
		System.out.println("Tri check Box is Selected : " + tricheck1.isSelected());

		WebElement toggle1 = driver.findElement(By.xpath("//*[text()='Toggle Switch']/following-sibling::div//div[2]"));
		if (toggle1.isEnabled() == true) {
			if (toggle1.isSelected() == true) {
				System.out.println("Toggle already selected");
			} else {
				toggle1.click();
				System.out.println("Toggle now selected");
			}
		} else {
			System.out.println("Toggle not enabled");
		}
		WebElement disable1 = driver
				.findElement(By.xpath("//*[contains(text(),'check box is disabled')]/following-sibling::div//div[2]"));
		if (disable1.isEnabled() == false)
			System.out.println("Disable check is Disabled");
		else
			System.out.println("Disable check is Enabled");
		Thread.sleep(2000);
		// to correct below
		WebElement multipleDD = driver
				.findElement(By.xpath("//*[contains(text(),'Select Multiple')]/following-sibling::div//ul"));
		multipleDD.click();// to click the drop down - to see the options in given DD
		Thread.sleep(2000);
		WebElement mainCBox = driver.findElement(By.xpath("//*[contains(@id,'multiple_panel')]/div[1]/div[1]/div[2]"));
		mainCBox.click(); // to enable main check box and to get list of all values
		Thread.sleep(2000);
		List<WebElement> CBox = multipleDD.findElements(By.tagName("li"));
		for (WebElement j : CBox) {
			System.out.println(j.getText());
		}
		Thread.sleep(2000);
		driver.close();

	}

}
