package demoTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {
	
	 @Test
	    public void verifyInvalidLogin()
	    {

	      WebDriverManager.chromedriver().setup();
	      WebDriver driver = new ChromeDriver();

	        String url="https://www.saucedemo.com/";
	        driver.get(url);
	        System.out.println("Browser launched & navigated to "+url);
	        driver.manage().window().maximize();
	        System.out.println("Browser window is maximized");
	        driver.findElement(By.id("user-name")).sendKeys("admin");
	        System.out.println("User name is entered successfully");
	        driver.findElement(By.id("password")).sendKeys("admin");
	        System.out.println("Password is entered successfully");
	        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	        System.out.println("Successfully clicked on login button");
	        String errorMsg= driver.findElement(By.xpath("//*[@data-test='error']")).getText();
	        Assert.assertEquals(errorMsg,"Epic sadface: Username and password do not match any user in this service");
	        driver.quit();
	        System.out.println("Browser closed successfully");
	    }
}
