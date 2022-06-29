package Mindtree.Assignment_1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App 
{
    public static void main( String[] args )
    {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        WebElement driverElement = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        driverElement.sendKeys("Mindtree");
        driverElement.sendKeys(Keys.ENTER);
        
        //driver.findElement(By.xpath("//input[@class='gNO89b']")).click();
    }
}
