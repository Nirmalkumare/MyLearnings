package week2.day1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateAccount {

	public static void main(String[] args) throws InterruptedException {
// Initialize driver and Login action:
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String USER1 = "demosalesmanager";
		String PASS1 = "crmsfa";
		driver.findElement(By.id("username")).sendKeys(USER1);
		driver.findElement(By.id("password")).sendKeys(PASS1);
		driver.findElement(By.xpath(
				"//div/h2[contains(text(),'Leaftaps Login')]/following-sibling::form/p/input[contains(@value,'Login')]"))
				.click();
		Thread.sleep(3000);
// Landed on HomePage screen
		String TITLE1 = driver.getTitle();
		System.out.println("landed on screen: " + TITLE1);
		driver.findElement(By.xpath("//div/a[contains(text(),'CRM/SFA')]")).click();
		Thread.sleep(3000);
// Account creation steps in Leaf Tap application
		driver.findElement(By.xpath("//ul[@class=\"sectionTabBar\"]//*[contains(text(),'Accounts')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),\"Create Account\")]")).click();
		Thread.sleep(3000);
		int index1 = (int) (Math.random() * 280); // math.random to make user name unique
		String accNAME1 = "TestNK" + index1;
		String Description1 = "Selenium Automation Tester";
		String siteName1 = "LeafTaps";
		String ImportantNote1 = "Test Accounts";
// Input field values for Account creation
		driver.findElement(By.id("accountName")).sendKeys(accNAME1);
		driver.findElement(By.name("description")).sendKeys(Description1);
		driver.findElement(By.id("numberEmployees")).sendKeys("2");
		driver.findElement(By.id("officeSiteName")).sendKeys(siteName1);
		driver.findElement(By.xpath("//*[@name=\"importantNote\"][@class=\"inputBox\"]")).sendKeys(ImportantNote1);
		driver.findElement(By.xpath("//input[@type=\"submit\"][@value=\"Create Account\"]")).click();
		Thread.sleep(5000);
// Title validation and success message verification
		String TITLE2 = driver.getTitle();
		System.out.println("landed on screen: " + TITLE2);
		driver.findElement(By.xpath("//a[contains(text(),\"Logout\")]")).click();
		System.out.println("Account creation successful for :" + accNAME1);
		Thread.sleep(3000);
		driver.quit();
	}
}