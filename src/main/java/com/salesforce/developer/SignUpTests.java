package com.salesforce.developer;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class SignUpTests
{
    final String COUNTRY_CSS = "#country";

    private WebDriver initiateBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        final WebDriver driver = (WebDriver)new ChromeDriver();
        final String url = "https://developer.salesforce.com/signup";
        driver.get(url);
        System.out.println("Page is opened");
        return driver;
    }

    @Test
    public void signUpTest() {
        System.out.println("Starting SignupTest");
        final WebDriver driver = this.initiateBrowser();
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        driver.findElement(By.id("first_name")).sendKeys(new CharSequence[] { "test" });
        driver.findElement(By.id("last_name")).sendKeys(new CharSequence[] { "test" });
        driver.findElement(By.id("email")).sendKeys(new CharSequence[] { "test@gmail.com" });
        new Select(driver.findElement(By.cssSelector("#job_role"))).selectByVisibleText("Developer");
        driver.findElement(By.id("company")).sendKeys(new CharSequence[] { "ABC" });
        new Select(driver.findElement(By.cssSelector("#country"))).selectByVisibleText("Germany");
        driver.findElement(By.cssSelector("#postal_code")).sendKeys(new CharSequence[] { "232323" });
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(new CharSequence[] { RandomStringUtils.randomAlphanumeric(10) + "@gmail.com" });
        driver.findElement(By.id("optin")).click();
        driver.findElement(By.xpath("//div[@id='eula_container']/label[1]")).click();
        driver.findElement(By.id("submit_btn")).click();
        try {
            Thread.sleep(10000L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(driver.getCurrentUrl(), "https://developer.salesforce.com/signup/success");
        driver.quit();
    }

    @Test
    public void checkFirstNameTest() {
        System.out.println("Starting SignupTest");
        final WebDriver driver = this.initiateBrowser();
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        driver.findElement(By.id("last_name")).sendKeys(new CharSequence[] { "Nair" });
        driver.findElement(By.id("email")).sendKeys(new CharSequence[] { "mnair2489@gmail.com" });
        final Select job_role = new Select(driver.findElement(By.cssSelector("#job_role")));
        job_role.selectByVisibleText("Developer");
        driver.findElement(By.id("company")).sendKeys(new CharSequence[] { "ABC" });
        final Select country = new Select(driver.findElement(By.cssSelector("#country")));
        country.selectByVisibleText("Germany");
        driver.findElement(By.cssSelector("#postal_code")).sendKeys(new CharSequence[] { "80992" });
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(new CharSequence[] { "mnair@gmail.com" });
        driver.findElement(By.id("optin")).click();
        driver.findElement(By.xpath("//div[@id='eula_container']/label[1]")).click();
        final WebElement signup = driver.findElement(By.id("submit_btn"));
        signup.click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='errorContainer']")).getText(), "The First Name field is required");
        driver.quit();
    }

    @Test
    public void checkSecondNameTest() {
        System.out.println("Starting SignupTest");
        final WebDriver driver = this.initiateBrowser();
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        driver.findElement(By.id("first_name")).sendKeys(new CharSequence[] { "Medha" });
        driver.findElement(By.id("email")).sendKeys(new CharSequence[] { "mnair2489@gmail.com" });
        new Select(driver.findElement(By.cssSelector("#job_role"))).selectByVisibleText("Developer");
        driver.findElement(By.id("company")).sendKeys(new CharSequence[] { "ABC" });
        new Select(driver.findElement(By.cssSelector("#country"))).selectByVisibleText("Germany");
        driver.findElement(By.cssSelector("#postal_code")).sendKeys(new CharSequence[] { "80992" });
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(new CharSequence[] { "mnair@gmail.com" });
        driver.findElement(By.id("optin")).click();
        driver.findElement(By.xpath("//div[@id='eula_container']/label[1]")).click();
        final WebElement signup = driver.findElement(By.id("submit_btn"));
        signup.click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='errorContainer']")).getText(), "The Last Name field is required");
        driver.quit();
    }

    @Test
    public void checkEmailAddressTest() {
        System.out.println("Starting SignupTest");
        final WebDriver driver = this.initiateBrowser();
        driver.getCurrentUrl();
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        driver.findElement(By.id("first_name")).sendKeys(new CharSequence[] { "Medha" });
        driver.findElement(By.id("last_name")).sendKeys(new CharSequence[] { "Nair" });
        new Select(driver.findElement(By.cssSelector("#job_role"))).selectByVisibleText("Developer");
        driver.findElement(By.id("company")).sendKeys(new CharSequence[] { "ABC" });
        new Select(driver.findElement(By.cssSelector("#country"))).selectByVisibleText("Germany");
        driver.findElement(By.cssSelector("#postal_code")).sendKeys(new CharSequence[] { "80992" });
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(new CharSequence[] { "mnair@gmail.com" });
        driver.findElement(By.id("optin")).click();
        driver.findElement(By.xpath("//div[@id='eula_container']/label[1]")).click();
        final WebElement signup = driver.findElement(By.id("submit_btn"));
        signup.click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='errorContainer']")).getText(), "The Email field is required");
        driver.quit();
    }

    @Test
    public void checkEmalidFormatTest() {
        System.out.println("Starting SignupTest");
        final WebDriver driver = this.initiateBrowser();
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        driver.findElement(By.id("first_name")).sendKeys(new CharSequence[] { "Medha" });
        driver.findElement(By.id("last_name")).sendKeys(new CharSequence[] { "Nair" });
        driver.findElement(By.id("email")).sendKeys(new CharSequence[] { "mnair2489gmail.com" });
        new Select(driver.findElement(By.cssSelector("#job_role"))).selectByVisibleText("Developer");
        driver.findElement(By.id("company")).sendKeys(new CharSequence[] { "ABC" });
        new Select(driver.findElement(By.cssSelector("#country"))).selectByVisibleText("Germany");
        driver.findElement(By.cssSelector("#postal_code")).sendKeys(new CharSequence[] { "80992" });
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(new CharSequence[] { "mnair@gmail.com" });
        driver.findElement(By.id("optin")).click();
        driver.findElement(By.xpath("//div[@id='eula_container']/label[1]")).click();
        driver.findElement(By.id("submit_btn")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='errorContainer']")).getText(), "Please enter a valid email address");
        driver.quit();
    }

    @Test
    public void checkRoleTest() {
        System.out.println("Starting SignupTest");
        final WebDriver driver = this.initiateBrowser();
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        driver.findElement(By.id("first_name")).sendKeys(new CharSequence[] { "Medha" });
        driver.findElement(By.id("last_name")).sendKeys(new CharSequence[] { "Nair" });
        driver.findElement(By.id("email")).sendKeys(new CharSequence[] { "mnair2489@gmail.com" });
        driver.findElement(By.id("company")).sendKeys(new CharSequence[] { "ABC" });
        new Select(driver.findElement(By.cssSelector("#country"))).selectByVisibleText("Germany");
        driver.findElement(By.cssSelector("#postal_code")).sendKeys(new CharSequence[] { "80992" });
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(new CharSequence[] { "mnair@gmail.com" });
        driver.findElement(By.id("optin")).click();
        driver.findElement(By.xpath("//div[@id='eula_container']/label[1]")).click();
        driver.findElement(By.id("submit_btn")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='errorContainer']")).getText(), "The Role field is required");
        driver.quit();
    }

    @Test
    public void checkPostalcodeTest() {
        System.out.println("Starting SignupTest");
        final WebDriver driver = this.initiateBrowser();
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        driver.findElement(By.id("first_name")).sendKeys(new CharSequence[] { "Medha" });
        driver.findElement(By.id("last_name")).sendKeys(new CharSequence[] { "Nair" });
        driver.findElement(By.id("email")).sendKeys(new CharSequence[] { "mnair@2489gmail.com" });
        new Select(driver.findElement(By.cssSelector("#job_role"))).selectByVisibleText("Developer");
        driver.findElement(By.id("company")).sendKeys(new CharSequence[] { "ABC" });
        new Select(driver.findElement(By.cssSelector("#country"))).selectByVisibleText("Germany");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(new CharSequence[] { "mnair@gmail.com" });
        driver.findElement(By.id("optin")).click();
        driver.findElement(By.xpath("//div[@id='eula_container']/label[1]")).click();
        driver.findElement(By.id("submit_btn")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='errorContainer']")).getText(), "The Postal Code field is required");
        driver.quit();
    }

    @Test
    public void checkCompanyTest() {
        System.out.println("Starting SignupTest");
        final WebDriver driver = this.initiateBrowser();
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        driver.findElement(By.id("first_name")).sendKeys(new CharSequence[] { "Medha" });
        driver.findElement(By.id("last_name")).sendKeys(new CharSequence[] { "Nair" });
        driver.findElement(By.id("email")).sendKeys(new CharSequence[] { "mnair2489@gmail.com" });
        new Select(driver.findElement(By.cssSelector("#job_role"))).selectByVisibleText("Developer");
        new Select(driver.findElement(By.cssSelector("#country"))).selectByVisibleText("Germany");
        driver.findElement(By.cssSelector("#postal_code")).sendKeys(new CharSequence[] { "80992" });
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(new CharSequence[] { "mnair@gmail.com" });
        driver.findElement(By.id("optin")).click();
        driver.findElement(By.xpath("//div[@id='eula_container']/label[1]")).click();
        driver.findElement(By.id("submit_btn")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='errorContainer']")).getText(), "The Company field is required");
        driver.quit();
    }

    @Test
    public void checkUsernameTest() {
        System.out.println("Starting SignupTest");
        final WebDriver driver = this.initiateBrowser();
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        driver.findElement(By.id("first_name")).sendKeys(new CharSequence[] { "Medha" });
        driver.findElement(By.id("last_name")).sendKeys(new CharSequence[] { "Nair" });
        driver.findElement(By.id("email")).sendKeys(new CharSequence[] { "mnair2489@gmail.com" });
        new Select(driver.findElement(By.cssSelector("#job_role"))).selectByVisibleText("Developer");
        driver.findElement(By.id("company")).sendKeys(new CharSequence[] { "ABC" });
        new Select(driver.findElement(By.cssSelector("#country"))).selectByVisibleText("Germany");
        driver.findElement(By.cssSelector("#postal_code")).sendKeys(new CharSequence[] { "80992" });
        driver.findElement(By.id("optin")).click();
        driver.findElement(By.xpath("//div[@id='eula_container']/label[1]")).click();
        driver.findElement(By.id("submit_btn")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='errorContainer']")).getText(), "The Username field is required");
        driver.quit();
    }
}