package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.Color;

public class LeafgroundButton {

	public static void main(String[] args) throws InterruptedException {
		String url1 = "https://leafground.com/button.xhtml";
// driver initialization
		EdgeDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.manage().window().maximize();
		driver.get(url1);
// test 1
		WebElement test1 = driver
				.findElement(By.xpath("//*[text()='Click and Confirm title.']/following-sibling::button"));
		test1.click();
		Thread.sleep(5000);
		System.out.println("Page title is :" + driver.getTitle());
// navigate back to main screen
		driver.navigate().back();
		Thread.sleep(5000);
// test 2
		WebElement test2 = driver
				.findElement(By.xpath("//*[text()='Confirm if the button is disabled.']/following-sibling::button"));
		if (test2.isEnabled()) {
			System.out.println("Is Button disabled = Fail");
		} else {
			System.out.println("Is Button disabled = Pass");
		}
// test 3
		WebElement test3 = driver.findElement(
				By.xpath("//*[contains(text(),'Find the position')]/following-sibling::button/span[text()='Submit']"));
		System.out.println("Location for " + test3.getText() + "is" + test3.getLocation());
// test 4
		WebElement test4 = driver.findElement(
				By.xpath("//*[contains(text(),'Find the Save')]/following-sibling::button/span[text()='Save']"));
		String valueColor = test4.getCssValue("color");
		String valueHex = Color.fromString(test4.getCssValue("color")).asHex();
		System.out.println("Button colot in RGB :" + valueColor + " & in Hex Values :" + valueHex);
// test 5
		WebElement test5 = driver.findElement(
				By.xpath("//*[contains(text(),'Find the height')]/following-sibling::button/span[text()='Submit']"));
		System.out.println("Button dimention are Height : " + test5.getSize().getHeight() + " and Width is : "
				+ test5.getSize().getWidth());
// close driver
		driver.quit();

	}

}
