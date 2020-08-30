package com.rahulshettyacademy;

import com.sun.org.apache.xerces.internal.xs.StringList;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Key;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class AutomationPractice1 {
    @Test
    public void placeOrder() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.findElement(By.xpath("//div[@id='root']/div[@class='container']/div[@class='products-wrapper']/div/div[1]/div[@class='stepper-input']/a[2]")).click();
        driver.findElement(By.xpath("//div[@id='root']/div[@class='container']/div[@class='products-wrapper']/div/div[1]/div[@class='product-action']/button")).click();
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//div[@id='root']/div[@class='container']/header/div[@class='container']//button[@type='button']")).click();
        driver.findElement(By.xpath("//div[@class='products-wrapper']/div/div/button")).click();
        Select country = new Select(driver.findElement(By.xpath("//div[@class='products-wrapper']/div/div/div/select")));
        country.selectByVisibleText("Germany");
        driver.findElement(By.xpath("//div[@class='products-wrapper']/div/div//input[@class = 'chkAgree']")).click();
        driver.findElement(By.xpath("//div[@class='products-wrapper']/div/div/button")).click();
    }

    @Test
    public void assignment1() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait w = new WebDriverWait(driver, 10);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
       w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'checkBoxOption1']")));
        for (int i = 1; i < 3; i++) {
            driver.findElement(By.xpath("//input[@id = 'checkBoxOption1']")).click();
            System.out.println(driver.findElement(By.xpath("//input[@id = 'checkBoxOption1']")).isSelected());
        }

        System.out.println(driver.findElements(By.xpath("//input[@type = 'checkbox']")).size());

    }


    @Test
    public void assignment2() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://cleartrip.com");

        new Select(driver.findElement(By.xpath("//select[@id = 'Adults']"))).selectByIndex(1);
        new Select(driver.findElement(By.xpath("//select[@id = 'Childrens']"))).selectByIndex(1);

        driver.findElement(By.xpath("//i[@class = 'icon ir datePicker']")).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight ui-state-active ']")).click();
        driver.findElement(By.xpath("//i[@class = 'rArrow blue']")).click();
        driver.findElement(By.xpath("//input[@id = 'AirlineAutocomplete']")).sendKeys("Indi");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> options = driver.findElements(By.cssSelector("ul[id = 'ui-id-3'] li"));
        for (WebElement option : options) {
            if (option.getText().contains("IndiGo")) {
                option.click();
                break;
            }
        }
        driver.findElement(By.id("SearchBtn")).click();
        System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
    }
@Test
    public void greenCartArray() {
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
    WebDriver driver = new ChromeDriver();
    int j = 0;
    driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

    String[] itemsNeeded = {"Brocolli", "Cucumber", "Beetroot"};
    try {
        Thread.sleep(10000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    //List all the products
    List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
    List<WebElement> orderButtons =  driver.findElements(By.xpath("//div[@class = 'product-action']/button"));
    List<String> itemsNeededList = Arrays.asList(itemsNeeded);
    products.forEach(product -> {
        String formattedName = product.getText().split("-")[0].trim();
        if (itemsNeededList.contains(formattedName)) {
            orderButtons.get(products.indexOf(product)).click();
        }
    });

/*    for(int i = 0; i < products.size() ; i++){

            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();

            List itemsNeededList = Arrays.asList(itemsNeeded);
            if (itemsNeededList.contains(formattedName)) {
                j++ ;
                //click on Add to Cart
                driver.findElements(By.xpath("//div[@class = 'product-action']/button")).get(i).click();
                if (j==3){
                    break;
                }
            }

        }*/

}

@Test
    public void assignment3(){
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
    WebDriver driver = new ChromeDriver();
    WebDriverWait w = new WebDriverWait(driver, 10);
    driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
    driver.findElement(By.xpath("//a[@href='javascript: void(0);loadAjax();']")).click();
    //Why cant we use textToBePresentInElementLocated?
    String actual = driver.findElement(By.xpath("//div[@id='results']")).getText().trim();
   w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='results']"),actual));
    driver.findElement(By.xpath("//a[@href='javascript: void(0);loadAjax();']")).click();
   //w.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='results']")));
    //System.out.println(driver.findElement(By.xpath("//div[@id='results']")).getText());
}
@Test
public void assignment4() {
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
    WebDriver driver = new ChromeDriver();
    driver.get("http://the-internet.herokuapp.com/");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //driver.findElement(By.linkText("Multiple Windows")).click();
  driver.findElement(By.xpath("//div[@id='content']/ul//a[@href='/windows']")).click();
  driver.findElement(By.linkText("Click Here")).click();
    Set<String> ids = driver.getWindowHandles();
    Iterator<String>  it = ids.iterator();
    String parentId = it.next();
    String childId1 = it.next();
    driver.switchTo().window(childId1);
    System.out.println(driver.getTitle());
    driver.switchTo().window(parentId);
    System.out.println(driver.findElement(By.tagName("h3")).getText());

}
    @Test
    public void assignment5() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Nested Frames")).click();
        //System.out.println(driver.findElements(By.tagName("frame")).size());
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name ='frame-top']")));
        //System.out.println(driver.findElements(By.tagName("frame")).size());
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name ='frame-middle']")));
        System.out.println(driver.findElement(By.xpath("//div[@id = 'content']")).getText());

    }
    @Test
    public void assignment6() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id = 'checkBoxOption2']")).click();
        String TextFromCheckbox = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]")).getText();
        List<WebElement> listOfOptions = driver.findElements(By.tagName("option"));
        for (WebElement options : listOfOptions){
            if (options.getText().equalsIgnoreCase(TextFromCheckbox)) {
                options.click();
                break;
            }
        }
        driver.findElement(By.id("name")).sendKeys(TextFromCheckbox);
        driver.findElement(By.id("alertbtn")).click();
        System.out.println(driver.switchTo().alert().getText().contains(TextFromCheckbox));
    }

    @Test
    public void tableGridExercises() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.cricbuzz.com/live-cricket-scorecard/18970/pak-vs-sl-2nd-t20i-pakistan-v-sri-lanka-in-uae-2017");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement table=driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
        int rowcount= table.findElements(By.cssSelector("cb-col cb-col-100 cb-scrd-itms")).size();
        int count=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();
        int sum =0;
        for(int i = 0; i<count-2; i++)
        {
            String value=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
            int valueinteger=  Integer.parseInt(value);
            sum=sum+valueinteger;//103
        }
//System.out.println(sum);
        String Extras=driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
        int extrasValue=Integer.parseInt(Extras);
        int TotalSumValue=sum+extrasValue;
        System.out.println(TotalSumValue);
        String ActualTotal=driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
        int ActualTotalVAlue=Integer.parseInt(ActualTotal);
        if(ActualTotalVAlue==TotalSumValue)
        {
            System.out.println("Count Matches");
        }
        else
        {
            System.out.println("count fails");
        }
    }
    @Test
    public void assignment7() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        WebElement Table = driver.findElement(By.id("product"));
        System.out.println ("Row count: "+ Table.findElements(By.tagName("tr")).size()) ;
        System.out.println("Column count: " + Table.findElements(By.xpath("//table[@id='product']/tbody/tr/th")).size());
        int columnCount = Table.findElements(By.xpath("//table[@id='product']/tbody/tr[2]/td")).size();
        for(int i = 0; i < columnCount; i++){
            System.out.println(Table.findElements(By.xpath("//table[@id='product']/tbody/tr[2]/td")).get(i).getText());
        }
    }
    @Test
    public void Assignment8() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        driver.findElement(By.xpath("//input[@id ='autocomplete']")).sendKeys("Uni");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id ='autocomplete']")).sendKeys(Keys.DOWN);
        System.out.println( driver.findElement(By.id("autocomplete")).getText());
        //by using Java script executer
        JavascriptExecutor js = (JavascriptExecutor)driver;
       String script = " return document.getElementById(\"autocomplete\").value;";
       String text = (String) js.executeScript(script);
       System.out.println(text);
       int i = 0;
 while (!text.equalsIgnoreCase("Tunisia")){
     i++;
     driver.findElement(By.xpath("//input[@id = 'autocomplete']")).sendKeys(Keys.DOWN);
     text = (String) js.executeScript(script);
     System.out.println(text);
        if (i>10){
           break;
        }
        }
        driver.findElement(By.xpath("//input[@id = 'autocomplete']")).sendKeys(Keys.ENTER);
    }
    @Test
    public void coloumnSorting()

    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

List<WebElement> listOfFruits = driver.findElements(By.xpath("//table[@id ='sortableTable']/tbody/tr/td[2]"));
        ArrayList<String> originalList = new  ArrayList<String>();
for (int i =0 ; i < listOfFruits.size(); i++){

    originalList.add(listOfFruits.get(i).getText());
}
System.out.println(originalList);
System.out.println("*****************copiedList************************");
ArrayList<String> copiedList = new ArrayList<String>();

for (int i = 0; i < originalList.size(); i++){
    copiedList.add(originalList.get(i));

}
        Collections.sort(copiedList);
        System.out.println(copiedList);
        Assert.assertEquals(originalList,copiedList);
    }
    @Test
    public void crossBrowserTest() throws MalformedURLException {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(Platform.LINUX);
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.50.1:4444/wd/hub"),capabilities);
        driver.get("http://qaclickacademy.com/practice.php");
        WebElement Table = driver.findElement(By.id("product"));
        System.out.println ("Row count: "+ Table.findElements(By.tagName("tr")).size()) ;
        System.out.println("Column count: " + Table.findElements(By.xpath("//table[@id='product']/tbody/tr/th")).size());
        int columnCount = Table.findElements(By.xpath("//table[@id='product']/tbody/tr[2]/td")).size();
        for(int i = 0; i < columnCount; i++){
            System.out.println(Table.findElements(By.xpath("//table[@id='product']/tbody/tr[2]/td")).get(i).getText());
        }
    }
}
