package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount_SelectClass {

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
		int index1 = (int) (Math.random() * 380); // math.random to make user name unique
		String accNAME1 = "Test_SEL_" + index1;
		String Description1 = "Selenium Automation Tester";
		String siteName1 = "LeafTaps";
		// Input field values for Account creation
		driver.findElement(By.id("accountName")).sendKeys(accNAME1);
		driver.findElement(By.name("description")).sendKeys(Description1);
		driver.findElement(By.id("numberEmployees")).sendKeys("2");
		driver.findElement(By.id("officeSiteName")).sendKeys(siteName1);
		// Dropdown using Select class
		WebElement IndustryDD = driver.findElement(By.name("industryEnumId")); // drop down selection - Industry
		Select industrySelection = new Select(IndustryDD);
		industrySelection.selectByValue("IND_SOFTWARE");
		WebElement OwnershipDD = driver.findElement(By.name("ownershipEnumId")); // drop down selection - Ownership
		Select ownershipSelection = new Select(OwnershipDD);
		ownershipSelection.selectByVisibleText("S-Corporation");
		WebElement SourceDD = driver.findElement(By.id("dataSourceId")); // drop down selection - Source
		Select sourceSelection = new Select(SourceDD);
		sourceSelection.selectByValue("LEAD_EMPLOYEE");
		WebElement MarketingcampaignDD = driver.findElement(By.id("marketingCampaignId"));
		Select campaignSelection = new Select(MarketingcampaignDD);// drop down selection - campaign
		campaignSelection.selectByIndex(5);
		WebElement StateDD = driver.findElement(By.id("generalStateProvinceGeoId")); // drop down selection - State
		Select stateSelection = new Select(StateDD);
		stateSelection.selectByValue("TX");
		// Submit form using button
		driver.findElement(By.xpath("//input[@type=\"submit\"][@value=\"Create Account\"]")).click();
		Thread.sleep(5000);
		// new user verification
		driver.findElement(By.xpath("//*[@id=\"left-content-column\"]/div/div/ul/li/a[text()=\"Find Accounts\"]"))
				.click();
		driver.findElement(By.xpath("//*[@id=\"findAccounts\"]//*[@name=\"accountName\"]")).sendKeys(accNAME1);
		driver.findElement(
				By.xpath("//*[@id=\"findAccounts\"]//../button[@class=\"x-btn-text\"][text()=\"Find Accounts\"]"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id=\"findAccounts\"]//tr/td[3]/div/a[@class=\"linktext\"]")).click();
		// Title validation and success message verification
		String TITLE2 = driver.getTitle();
		System.out.println("landed on screen: " + TITLE2);
		driver.findElement(By.xpath("//a[contains(text(),\"Logout\")]")).click();
		System.out.println("Account creation successful for :" + accNAME1);
		Thread.sleep(3000);
		driver.quit();
	}
}