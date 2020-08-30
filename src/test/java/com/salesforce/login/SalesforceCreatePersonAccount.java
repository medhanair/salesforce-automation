package com.salesforce.login;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class SalesforceCreatePersonAccount {

    @Test
    public void dataReset() throws InterruptedException {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver-new");
        FirefoxDriver driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        String url = "https://login.salesforce.com/";
        driver.get(url);
        System.out.println("login page is opened");
        driver.findElement(By.id("username")).sendKeys("mnair2489@na.com");
        driver.findElement(By.id("password")).sendKeys("PrepaidTel@890");
        driver.findElement(By.id("Login")).click();
        driver.findElement(By.xpath("//li[@data-node-id = 'Users']//div[@title ='Users']//button[@class = 'slds-button slds-button_icon slds-m-right_x-small  slds-button_icon-bare']")).click();
        driver.findElement(By.xpath("//a[@href = '/one/one.app#/setup/ManageUsers/home']")).click();
        Thread.sleep(10000);
        driver.switchTo().frame(0);
        WebElement userTable = driver.findElement(By.xpath("//table [@class = 'list']/tbody"));
        int rowCount = userTable.findElements(By.xpath("//tr[@onblur='if (window.hiOff){hiOff(this);}']/td[5]")).size();
        for(int i =0 ; i <rowCount; i++) {
            if (userTable.findElements(By.xpath("//tr[@onblur='if (window.hiOff){hiOff(this);}']/td[5]")).get(i).getText().equalsIgnoreCase("Marketing Team")
                    && userTable.findElements(By.xpath("//tr[@onblur='if (window.hiOff){hiOff(this);}']/td[6]/img"))
                    .get(i).getAttribute("src").contains("checkbox_checked")) {
              userTable.findElements(By.xpath("//tr[@onblur='if (window.hiOff){hiOff(this);}']/td//a[@class='actionLink']")).get(i).click();
              driver.switchTo().defaultContent();
              driver.switchTo().frame(0);
              driver.findElement(By.xpath("//input[@id='active']")).click();
              driver.switchTo().alert().accept();
              driver.findElement(By.xpath("//input[@name = 'save']")).click();
              driver.quit();
              break;
            }
        }
    }

    @Test(dependsOnMethods = {"dataReset"})
    public void createPersonAccount() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String url = "https://login.salesforce.com/";
        driver.get(url);
        driver.findElement(By.id("username")).sendKeys("mnair2489@na.com");
        driver.findElement(By.id("password")).sendKeys("PrepaidTel@890");
        driver.findElement(By.id("Login")).click();
        driver.findElement(By.xpath("//div[@id='setupComponent']/div[1]/div//div[@class='onesetupCreateMenu uiMenu']/div[@class='uiPopupTrigger']//a[@role='button']")).click();
        driver.findElement(By.xpath("//li[@id='userCreateMenuItem']/a[@role='menuitem']//div[@class='slds-col slds-size_10-of-12']")).click();
        Thread.sleep(10000);
        driver.switchTo().frame(0);
        driver.findElement(By.id("name_lastName")).sendKeys("Nair");
        driver.findElement(By.id("Alias")).sendKeys(RandomStringUtils.randomAlphabetic(5));
        driver.findElement(By.id("Email")).sendKeys("mnair2489@gmail.com");
        driver.findElement(By.id("Username")).sendKeys(RandomStringUtils.randomAlphanumeric(7) + "@gmail.com");
        driver.findElement(By.id("CommunityNickname")).sendKeys("TEST");
        new Select(driver.findElement(By.id("role"))).selectByVisibleText("Marketing Team");
        new Select(driver.findElement(By.id("user_license_id"))).selectByVisibleText("Salesforce");
        new Select(driver.findElement(By.id("Profile"))).selectByVisibleText("Marketing User");
        driver.findElement(By.xpath("//td[@id='bottomButtonRow']/input[@name='save']")).click();
    }

    @Test

        public void innerOuterloop(){
        int k =1 ;
        for(int i = 1; i <4; i++){
            System.out.println("outerloop started");
            for (int j = 1; j<=i ; j++){
                System.out.println("innerloop started");
                int product = k*3;
                System.out.println(product);
                k++;
            }

        }

        }
   @Test
   public void arrayPractice(){
    int a [] [] = {{2, 3,4},{5,1,2},{3,3,0}};
    int minvalue = a[0][0];

    for (int i = 0;i<3;i++){

        for(int j = 0; j<3; j++){
if (a[i][j]<minvalue){
    minvalue = a[i][j];

}

        }


    }

   }
}
