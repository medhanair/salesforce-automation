package com.salesforce.developer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.commons.lang3.RandomStringUtils;


public class PositiveSignupTest {
	
	private static final String COUNTRY_CSS="#country";
	
	private WebDriver initiateBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		String url = "https://developer.salesforce.com/signup";
		driver.get(url);
		System.out.println("Page is opened");
		return driver;

	}

	@Test
	public void signUpTest() {
		System.out.println("Starting SignupTest");
		WebDriver driver = initiateBrowser();
		// maximize browser window
		driver.manage().window().maximize();
		// Accept cookies
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		// Enter FirstName WebElement
		driver.findElement(By.id("first_name")).sendKeys("test");
		//Enter Last Name	
		driver.findElement(By.id("last_name")).sendKeys("test");
		// Enter email address
		driver.findElement(By.id("email")).sendKeys("test@gmail.com");
		// Select Role from the dropdown
		new Select(driver.findElement(By.cssSelector("#job_role"))).selectByVisibleText("Developer");
		// Enter Company Name
		driver.findElement(By.id("company")).sendKeys("ABC");
		// Select Country from dropdown
		new Select(driver.findElement(By.cssSelector(COUNTRY_CSS))).selectByVisibleText("Germany");
		//8. Enter Postal Code
		driver.findElement(By.cssSelector("#postal_code")).sendKeys("232323");
		// Enter Username and generate a randmon string for email id.
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(RandomStringUtils.randomAlphanumeric(10) + "@gmail.com");
		// select the checkbox to agree to receive communications regarding marketing
		driver.findElement(By.id("optin")).click();
		// select the check box to agree to the terms and conditions
		driver.findElement(By.xpath("//div[@id='eula_container']/label[1]")).click();
		// Click on Sign me up
		driver.findElement(By.id("submit_btn")).click();
		//forcefully waiting for the sign up to complete
		try {
		    Thread.sleep(10000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		Assert.assertEquals(driver.getCurrentUrl(), "https://developer.salesforce.com/signup/success");
	}


	// Negative Tests to check that first name is mandatory
	@Test
	public void checkFirstNameTest() {

		System.out.println("Starting SignupTest");
		WebDriver driver = initiateBrowser();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		driver.findElement(By.id("last_name")).sendKeys("Nair");
		driver.findElement(By.id("email")).sendKeys("mnair2489@gmail.com");
		Select job_role = new Select(driver.findElement(By.cssSelector("#job_role")));
		job_role.selectByVisibleText("Developer");
		driver.findElement(By.id("company")).sendKeys("ABC");
		Select country = new Select(driver.findElement(By.cssSelector(COUNTRY_CSS)));
		country.selectByVisibleText("Germany");
		driver.findElement(By.cssSelector("#postal_code")).sendKeys("80992");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("mnair@gmail.com");
		driver.findElement(By.id("optin")).click();
		driver.findElement(By.xpath("//div[@id='eula_container']/label[1]")).click();
		WebElement signup = driver.findElement(By.id("submit_btn"));
		signup.click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='errorContainer']")).getText(),
				"The First Name field is required");
		driver.quit();
	}
	
	// Negative Tests to check that second name is mandatory
	@Test
	public void checkSecondNameTest() {

		System.out.println("Starting SignupTest");
		WebDriver driver = initiateBrowser();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		driver.findElement(By.id("first_name")).sendKeys("Medha");
		driver.findElement(By.id("email")).sendKeys("mnair2489@gmail.com");
		new Select(driver.findElement(By.cssSelector("#job_role"))).selectByVisibleText("Developer");
		driver.findElement(By.id("company")).sendKeys("ABC");
		new Select(driver.findElement(By.cssSelector(COUNTRY_CSS))).selectByVisibleText("Germany");
		driver.findElement(By.cssSelector("#postal_code")).sendKeys("80992");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("mnair@gmail.com");
		driver.findElement(By.id("optin")).click();
		driver.findElement(By.xpath("//div[@id='eula_container']/label[1]")).click();
		WebElement signup = driver.findElement(By.id("submit_btn"));
		signup.click();
		Assert.assertEquals(
				driver.findElement(By.xpath("//form[@id='deorg_form']/div[@class='horizontal_fields']/div[2]/div[@class='fieldError']/div[@class='errorContainer']")).getText(),
				"The Last Name field is required");
		driver.quit();
	}
	
	//email id mandatory
	@Test
	public void checkEmailAddressTest() {

		System.out.println("Starting SignupTest");
		WebDriver driver = initiateBrowser();
		driver.getCurrentUrl();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		driver.findElement(By.id("first_name")).sendKeys("Medha");
		driver.findElement(By.id("last_name")).sendKeys("Nair");
		new Select(driver.findElement(By.cssSelector("#job_role"))).selectByVisibleText("Developer");
		driver.findElement(By.id("company")).sendKeys("ABC");
		new Select(driver.findElement(By.cssSelector(COUNTRY_CSS))).selectByVisibleText("Germany");
		driver.findElement(By.cssSelector("#postal_code")).sendKeys("80992");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("mnair@gmail.com");
		driver.findElement(By.id("optin")).click();
		driver.findElement(By.xpath("//div[@id='eula_container']/label[1]")).click();
		WebElement signup = driver.findElement(By.id("submit_btn"));
		signup.click();

		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@class='errorContainer']")).getText(),
				"The Email field is required");

		driver.quit();
	}
	
//email id format check	
	@Test
	public void checkEmalidFormatTest() {

		System.out.println("Starting SignupTest");
		WebDriver driver = initiateBrowser();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		driver.findElement(By.id("first_name")).sendKeys("Medha");
		driver.findElement(By.id("last_name")).sendKeys("Nair");
		driver.findElement(By.id("email")).sendKeys("mnair2489gmail.com");
		new Select(driver.findElement(By.cssSelector("#job_role"))).selectByVisibleText("Developer");
		driver.findElement(By.id("company")).sendKeys("ABC");
		new Select(driver.findElement(By.cssSelector(COUNTRY_CSS))).selectByVisibleText("Germany");
		driver.findElement(By.cssSelector("#postal_code")).sendKeys("80992");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("mnair@gmail.com");
		driver.findElement(By.id("optin")).click();
		driver.findElement(By.xpath("//div[@id='eula_container']/label[1]")).click();
		driver.findElement(By.id("submit_btn")).click();

		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@class='errorContainer']")).getText(),
				"Please enter a valid email address");
		driver.quit();
	}

	
	
	//role is mandatory
	@Test
	public void checkRoleTest() {

		System.out.println("Starting SignupTest");
		WebDriver driver = initiateBrowser();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		driver.findElement(By.id("first_name")).sendKeys("Medha");
		driver.findElement(By.id("last_name")).sendKeys("Nair");
		driver.findElement(By.id("email")).sendKeys("mnair2489@gmail.com");
		driver.findElement(By.id("company")).sendKeys("ABC");
		new Select(driver.findElement(By.cssSelector(COUNTRY_CSS))).selectByVisibleText("Germany");
		driver.findElement(By.cssSelector("#postal_code")).sendKeys("80992");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("mnair@gmail.com");
		driver.findElement(By.id("optin")).click();
		driver.findElement(By.xpath("//div[@id='eula_container']/label[1]")).click();
		driver.findElement(By.id("submit_btn")).click();

		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@class='errorContainer']")).getText(),
				"The Role field is required");
		driver.quit();
	}
	
	@Test
	public void checkPostalcodeTest() {

		System.out.println("Starting SignupTest");
		WebDriver driver = initiateBrowser();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		driver.findElement(By.id("first_name")).sendKeys("Medha");
		driver.findElement(By.id("last_name")).sendKeys("Nair");
		driver.findElement(By.id("email")).sendKeys("mnair@2489gmail.com");	
		new Select(driver.findElement(By.cssSelector("#job_role"))).selectByVisibleText("Developer");
		driver.findElement(By.id("company")).sendKeys("ABC");
		new Select(driver.findElement(By.cssSelector(COUNTRY_CSS))).selectByVisibleText("Germany");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("mnair@gmail.com");
		driver.findElement(By.id("optin")).click();
		driver.findElement(By.xpath("//div[@id='eula_container']/label[1]")).click();
		driver.findElement(By.id("submit_btn")).click();

		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@class='errorContainer']")).getText(),
				"The Postal Code field is required");
		driver.quit();
	}	
	
	
	
	@Test
	public void checkCompanyTest() {

		System.out.println("Starting SignupTest");
		WebDriver driver = initiateBrowser();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		driver.findElement(By.id("first_name")).sendKeys("Medha");
		driver.findElement(By.id("last_name")).sendKeys("Nair");
		driver.findElement(By.id("email")).sendKeys("mnair2489@gmail.com");
		new Select(driver.findElement(By.cssSelector("#job_role"))).selectByVisibleText("Developer");
		new Select(driver.findElement(By.cssSelector(COUNTRY_CSS))).selectByVisibleText("Germany");
		driver.findElement(By.cssSelector("#postal_code")).sendKeys("80992");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("mnair@gmail.com");
		driver.findElement(By.id("optin")).click();
		driver.findElement(By.xpath("//div[@id='eula_container']/label[1]")).click();
		driver.findElement(By.id("submit_btn")).click();
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@class='errorContainer']")).getText(),
				"The Company field is required");
		driver.quit();
	}
	
	
	
	@Test
	public void checkUsernameTest() {

		System.out.println("Starting SignupTest");
		WebDriver driver = initiateBrowser();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		driver.findElement(By.id("first_name")).sendKeys("Medha");
		driver.findElement(By.id("last_name")).sendKeys("Nair");
		driver.findElement(By.id("email")).sendKeys("mnair2489@gmail.com");	
		new Select(driver.findElement(By.cssSelector("#job_role"))).selectByVisibleText("Developer");
		driver.findElement(By.id("company")).sendKeys("ABC");
		new Select(driver.findElement(By.cssSelector(COUNTRY_CSS))).selectByVisibleText("Germany");
		driver.findElement(By.cssSelector("#postal_code")).sendKeys("80992");		 
		driver.findElement(By.id("optin")).click();
		driver.findElement(By.xpath("//div[@id='eula_container']/label[1]")).click();
		driver.findElement(By.id("submit_btn")).click();

		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@class='errorContainer']")).getText(),
				"The Username field is required");

		driver.quit();
	}

}
