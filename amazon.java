package Mindtree.Assignment_1;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class amazon {
        //edit2
        //edit11

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        
        WebElement driverElement = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        driverElement.sendKeys("refrigerator");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        
        driver.findElement(By.xpath("//span[contains(text(),'Samsung 192 L 2')]")).click();
        
        WebElement a = driver.findElement(By.xpath("//div[@data-asin='B08SC2ZTDP']//span[@class='a-price-whole']"));
        String pr = a.getText();
        System.out.println("Price on parent window : "+pr);
        
        Set <String> ids=driver.getWindowHandles();
        Iterator <String> it=ids.iterator();
		String parentid=it.next();
        String childid=it.next();
        driver.switchTo().window(childid);
        
        String pr2=driver.findElement(By.xpath("//div[@id='apex_desktop']//span[@class='a-price-whole']")).getText();
        System.out.println("Price on child window : "+pr2);
        if(pr.equalsIgnoreCase(pr2))
        {
        	System.out.println("Equal Price");
        }
        else
        {
        	System.out.println("Unequal Price");
        }
        
        String st="Item Weight";
        List <WebElement> li = driver.findElements(By.xpath("//tr[@class='comparison_other_attribute_row']/th//span[@class='a-size-base a-color-base']"));
        int count = driver.findElements(By.xpath("//tr[@class='comparison_other_attribute_row']/th//span[@class='a-size-base a-color-base']")).size();
        int c=0;
        for(WebElement a1 : li)
        {
        	String st1 = a1.getText();
        	c++;
        	if(st1.equals(st))
        	{
        		break;
        	}
        }
        int k=c+7;
        String st3=Integer.toString(k);
        WebElement a2 = driver.findElement(By.xpath("//table[@id='HLCXComparisonTable']//tr["+st3+"]/td[4]//span[@class='a-size-base a-color-base']"));
		String st2 = a2.getText();
		System.out.println("Item weight for Samsung 3 star refrigerator : "+k); 
		
		//compare item list is missing now.
	}
        
}


