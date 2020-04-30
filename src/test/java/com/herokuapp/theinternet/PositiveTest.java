package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTest {
@Test	
public void loginTest() {
System.out.println("Starting loginTest");
		
		//	Create driver
	
System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
WebDriver driver = new ChromeDriver();	


//	open test page
String url = "http://the-internet.herokuapp.com/login";
driver.get(url);
System.out.println("Page is opened");

//maximize browser window

driver.manage()
	  .window()
	  .maximize();

//	enter username
WebElement username = driver.findElement(By.id("username"));
username.sendKeys("tomsmith");

//	enter password

WebElement password = driver.findElement(By.id("password"));
password.sendKeys("SuperSecretPassword!");

//	click login button


WebElement logInButton = driver.findElement(By.tagName("Button"));

logInButton.click();



//Verifications
//new URL
String expectedUrl = "http://the-internet.herokuapp.com/secure";
String actualUrl = driver.getCurrentUrl();
Assert.assertEquals(expectedUrl, actualUrl, "Actual page url is not the same as the expected one");

//logout button is visible
WebElement logOutButton = driver.findElement(By.xpath("//a[@class = 'button secondary radius']"));
Assert.assertTrue(logOutButton.isDisplayed(), "Logout button not found");

//successful login message
WebElement successMessage = driver.findElement(By.cssSelector("#flash"));
String expectedMessage = "You logged into a secure area!";
String actualMessage = successMessage.getText();
Assert.assertTrue(actualMessage.contains(expectedMessage),"Actual message does not contain the expected message.\nActual Message" + actualMessage + "\nExpected Message " + expectedMessage);


//Close Browser
driver.quit();
	}

}
