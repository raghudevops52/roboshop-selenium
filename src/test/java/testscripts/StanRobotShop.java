package testscripts;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import framework.DriverFactory;


public class StanRobotShop extends DriverFactory {
	WebDriver driver;
	
	
	@BeforeTest
	public void beforeTest() throws Exception{
	
		
		driver=DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.get("http://52.36.51.176:8080/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void CreateAnOrder() throws InterruptedException {
		
		if(driver.findElement(By.xpath("//a[text()=\"Stan's Robot Shop\"]")).isDisplayed()) {
			
			driver.findElement(By.xpath("//span[.='Artificial Intelligence']")).click();
			
			driver.findElement(By.xpath("//a[.='HAL']")).click();
			
			driver.findElement(By.xpath("//button[.='Add to cart']")).click();
			
			driver.findElement(By.xpath("//a[.='Cart']")).click();
			
			driver.findElement(By.xpath("//button[.='Checkout']")).click();
			
			Select s=new Select(driver.findElement(By.xpath("//select[@ng-model='data.selectedCountry']")));
			s.selectByValue("in");;
			
			driver.findElement(By.id("location")).sendKeys("Hyderabad");
			Thread.sleep(10000);
			driver.findElement(By.id("location")).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(10000);
			driver.findElement(By.id("location")).sendKeys(Keys.ENTER);
			
			driver.findElement(By.xpath("//button[.='Calculate']")).click();
			
			driver.findElement(By.xpath("//button[.='Confirm']")).click();
			
			driver.findElement(By.xpath("//button[.='Pay Now']")).click();
			
			if(driver.findElement(By.xpath("//div[@class='message ng-binding']")).getText().contains("Order placed")) {
				
				System.out.println("order placed successfully");
				
			}
				
		}else {
			
			Assert.fail("Stan's Robot Shop home is not displayed");
		}
		
		
	}
	
	
	@AfterTest
	public void afterTest() throws Exception{
	driver.quit();
	}
}
	
	

