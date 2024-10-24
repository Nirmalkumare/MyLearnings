package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
// Lead Creation & deletion of lead
		// #1 URL and login details:
		String URL1 = "http://leaftaps.com/opentaps/control/main";
		String USER2 = "demosalesmanager";
		String PASS2 = "crmsfa";
		// #2 Lead details - field values:
		int index2 = (int) (Math.random() * 81);
		String name11 = "FN_LeadNK" + index2;
		String name12 = "LN" + index2;
		String cname = "CN" + index2;
		String tname = "Title" + index2;
		String Description1 = "Selenium Automation Tester";

		// #3 Driver initialization, login and navigate to CRM/SFA screen
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL1);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.findElement(By.id("username")).sendKeys(USER2);
		driver.findElement(By.id("password")).sendKeys(PASS2);
		driver.findElement(By.xpath(
				"//div/h2[contains(text(),'Leaftaps Login')]/following-sibling::form/p/input[contains(@value,'Login')]"))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.findElement(By.xpath("//div/a[contains(text(),'CRM/SFA')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

		// #4 New Lead creation in Leaf tap application
		driver.findElement(By.xpath("//ul[@class='sectionTabBar']//../a[contains(text(),'Leads')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.findElement(By.xpath("//a[contains(text(),\"Create Lead\")]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(name11);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(name12);
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys(tname);
		driver.findElement(By.name("description")).sendKeys(Description1);
		driver.findElement(By.xpath("//input[@type=\"submit\"][@value=\"Create Lead\"]")).click();
		Thread.sleep(3000);
		System.out.println("Lead creation successful for :" + name11 + " " + name12);

		// #5 Deletion of Lead - finding above created lead and deleting
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//div[@id='findLeads']//label[text()='First name:']/parent::div/div/input"))
				.sendKeys(name11);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@id='findLeads']//table/tbody/tr/td/div)[3]/a")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		Thread.sleep(4000);
		// #6 Verify if the deleted Lead is not listed in Find Lead search
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='findLeads']//label[text()='First name:']/parent::div/div/input"))
				.sendKeys(name11);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1500);
		String compare1 = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		System.out.println("Message Validated -->> " + compare1);
		System.out.println("Lead deletion successful for :" + name11 + " " + name12);

		// #7 Logout from application and close browser driver
		driver.findElement(By.xpath("//a[contains(text(),\"Logout\")]")).click();
		Thread.sleep(3000);
		driver.close();
	}
}