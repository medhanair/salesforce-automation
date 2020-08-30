package com.rahulshettyacademy;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.java2d.pipe.SolidTextRenderer;

import java.io.File;


import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

public class NewSeleniumFeatuers {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
       WebElement name = driver.findElement(By.xpath("//input[@name = 'name']"));
       name.sendKeys("medha");
       File file = name.getScreenshotAs(OutputType.FILE);
     //  FileUtils.copyFile(file, newFile("logo.png"));


        //System.out.println(driver.findElement(By.xpath("//input[@name = 'name']")).getRect().getHeight());
        //System.out.println(driver.findElement(By.xpath("//input[@name = 'name']")).getRect().getWidth());
       // String Text = driver.findElement(withTagName("label").above(driver.findElement(By.xpath("//input[@name = 'name']")))).getText();
       // driver.switchTo().newWindow(WindowType.WINDOW);

    }

}
