package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookDropdown {

	public static void main(String[] args) throws InterruptedException {
		// Initialize driver and Login action:
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//div/a[text()=\"Create new account\"]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		String firstname = "F1_user";
		String lastname = "LN_user";
		driver.findElement(By.name("firstname")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		WebElement day1 = driver.findElement(By.id("day")); // Drop down
		Select dayDD = new Select(day1);
		dayDD.selectByValue("11");
		WebElement month1 = driver.findElement(By.id("month"));
		Select monthDD = new Select(month1);
		monthDD.selectByValue("11");
		WebElement year1 = driver.findElement(By.id("year"));
		Select yearDD = new Select(year1);
		yearDD.selectByValue("2011");
		WebElement Gender = driver.findElement(By.xpath("//*/label[text()=\"Male\"]"));
		Gender.click(); // radio button
		Thread.sleep(4000);
		System.out.println("Is male selected: " + Gender.isDisplayed());
		driver.close();
	}
}