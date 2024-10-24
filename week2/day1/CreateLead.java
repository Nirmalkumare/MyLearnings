package week2.day1;

import java.time.Duration;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateLead {

	public static void main(String[] args) throws InterruptedException {
		String URL1 = "http://leaftaps.com/opentaps/control/main";
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL1);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		String USER2 = "demosalesmanager";
		String PASS2 = "crmsfa";
		driver.findElement(By.id("username")).sendKeys(USER2);
		driver.findElement(By.id("password")).sendKeys(PASS2);
		driver.findElement(By.xpath(
				"//div/h2[contains(text(),'Leaftaps Login')]/following-sibling::form/p/input[contains(@value,'Login')]"))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		Alert A1 = driver.switchTo().alert();
//		A1.dismiss();	Thread.sleep(4000);
		// Landed on HomePage screen
		String TITLE2 = driver.getTitle();
		System.out.println("landed on screen: " + TITLE2);
		driver.findElement(By.xpath("//div/a[contains(text(),'CRM/SFA')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		// Lead creation steps in Leaf Tap app
		driver.findElement(By.xpath("//ul[@class='sectionTabBar']//../a[contains(text(),'Leads')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),\"Create Lead\")]")).click();
		Thread.sleep(3000);
		int index2 = (int) (Math.random() * 81);
		String name11 = "FN_LeadNK" + index2;
		String name12 = "LN" + index2;
		String cname = "CN" + index2;
		String tname = "Title" + index2;
		String Description1 = "Selenium Automation Tester";
		// Entering details for Lead creation
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(name11);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(name12);
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys(tname);
		driver.findElement(By.name("description")).sendKeys(Description1);
		driver.findElement(By.xpath("//input[@type=\"submit\"][@value=\"Create Lead\"]")).click();
		Thread.sleep(8000);
		// Title validation and success message
		String TITLE3 = driver.getTitle();
		System.out.println("landed on screen: " + TITLE3);
		driver.findElement(By.xpath("//a[contains(text(),\"Logout\")]")).click();
		System.out.println("Account creation successful for :" + name11 + " " + name12);
		Thread.sleep(3000);
		driver.quit();
	}
}