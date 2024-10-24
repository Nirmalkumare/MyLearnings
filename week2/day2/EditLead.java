package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
// Lead Creation & edit lead
		// #1 URL and login details:
		String URL1 = "http://leaftaps.com/opentaps/control/main";
		String USER2 = "demosalesmanager";
		String PASS2 = "crmsfa";
		// #2 Lead details - field values:
		int index2 = (int) (Math.random() * 171);
		String name11 = "LeadNK" + index2;
		String name12 = "LN2" + index2;
		String cname = "CN2" + index2;
		String locname = "MyLocalName";
		String depart = "DepartTest";
		String email = "test11_22a5@gmail.com";
		String usstate = "New York";
		String tname = "Title2" + index2;
		String Description1 = "Selenium Automation Tester" + index2;

		// #3 Driver initialization, login and navigate to CRM/SFA screen
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.manage().window().maximize();
		driver.get(URL1);
		driver.findElement(By.id("username")).sendKeys(USER2);
		driver.findElement(By.id("password")).sendKeys(PASS2);
		driver.findElement(By.xpath(
				"//div/h2[contains(text(),'Leaftaps Login')]/following-sibling::form/p/input[contains(@value,'Login')]"))
				.click();
		driver.findElement(By.xpath("//div/a[contains(text(),'CRM/SFA')]")).click();
		Thread.sleep(2000);

		// #4 New Lead creation in Leaf tap application
		driver.findElement(By.xpath("//ul[@class='sectionTabBar']//../a[contains(text(),'Leads')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.findElement(By.xpath("//a[contains(text(),\"Create Lead\")]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(name11);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(name12);
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.xpath("//*[@id='createLeadForm_firstNameLocal']")).sendKeys(locname);
		driver.findElement(By.xpath("//*[@id='createLeadForm_departmentName']")).sendKeys(depart);
		driver.findElement(By.xpath("//*[@id='createLeadForm_primaryEmail']")).sendKeys(email);
		WebElement state1 = driver.findElement(By.xpath("//*[@id='createLeadForm_generalStateProvinceGeoId']"));
		Select NY = new Select(state1);
		NY.selectByVisibleText(usstate);
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys(tname);
		driver.findElement(By.name("description")).sendKeys(Description1);
		driver.findElement(By.xpath("//input[@type=\"submit\"][@value=\"Create Lead\"]")).click();
		Thread.sleep(3000);
		System.out.println("Lead creation successful for :" + name11 + " " + name12);

		// #5 Edit Lead - for above created lead
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//div[@id='findLeads']//label[text()='First name:']/parent::div/div/input"))
				.sendKeys(name11);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@id='findLeads']//table/tbody/tr/td/div)[3]/a")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		Thread.sleep(4000);
		driver.findElement(By.name("description")).clear();
		driver.findElement(By.xpath("//*[@id='updateLeadForm_importantNote']")).sendKeys(Description1);
		driver.findElement(By.xpath("//*[@type='submit'][@value='Update']")).click();
		Thread.sleep(4000);
		System.out.println("Page Titile for Update: " + driver.getTitle());
		System.out.println("Lead edit done for :" + name11 + " " + name12);

		// #6 Verify if the Edit values are displayed Lead
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='findLeads']//label[text()='First name:']/parent::div/div/input"))
				.sendKeys(name11);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@id='findLeads']//table/tbody/tr/td/div)[3]/a")).click();
		Thread.sleep(2000);
		String test1 = driver.findElement(By.id("viewLead_importantNote_sp")).getText();

		if (test1.equals(Description1))
			System.out.println("validation passed : " + Description1 + " displayed in Important note");
		else
			System.out.println("edit validation failed");

		// #7 Logout from application and close browser driver
		driver.findElement(By.xpath("//a[contains(text(),\"Logout\")]")).click();
		Thread.sleep(3000);
		driver.close();
	}
}