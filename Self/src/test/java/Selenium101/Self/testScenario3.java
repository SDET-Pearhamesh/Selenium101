package Selenium101.Self;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;


public class testScenario3 {
	
	RemoteWebDriver driver ;
	
	@SuppressWarnings("deprecation")
	@Test
	public void formFilling() throws InterruptedException, MalformedURLException {
		
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("126");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "prathamesh.d.ingale");
		ltOptions.put("accessKey", "A6WJ2KJHcJCdvhf0mWuI5tBzt5lr5ygmrRMjFqkW610VRt95nu");
		ltOptions.put("visual", true);
		ltOptions.put("video", true);
		ltOptions.put("network", true);
		ltOptions.put("build", "3 Scenarios");
		ltOptions.put("project", "Selenium 101");
		ltOptions.put("selenium_version", "4.0.0");
		ltOptions.put("w3c", true);
		browserOptions.setCapability("LT:Options", ltOptions);
		
		driver = new RemoteWebDriver (new URL("https://prathamesh.d.ingale:A6WJ2KJHcJCdvhf0mWuI5tBzt5lr5ygmrRMjFqkW610VRt95nu@hub.lambdatest.com/wd/hub"), browserOptions);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.lambdatest.com/selenium-playground"); 
		
		driver.findElement(By.xpath("//a[text()='Input Form Submit']")).click();

		driver.findElement(By.xpath("//button [text()='Submit']")).click(); 
		
		WebElement name = driver.findElement(By.id("name"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", name); 
		
		System.out.println(validationMessage);
		
		driver.findElement(By.id("name")).sendKeys("Rahul"); 
		
		driver.findElement(By.id("inputEmail4")).sendKeys("rahul@gmail.com"); 
		
		driver.findElement(By.id("inputPassword4")).sendKeys("lambda@Test"); 
	
		driver.findElement(By.id("company")).sendKeys("Lambda"); 
		
		driver.findElement(By.id("websitename")).sendKeys("www.LambadaTest.com"); 
		
		WebElement country = driver.findElement(By.name("country"));
		 
		Select selectCountry = new Select(country);
	
		selectCountry.selectByVisibleText("United States");
		
		driver.findElement(By.id("inputCity")).sendKeys ("New York City");
		
		driver.findElement(By.id("inputAddress1")).sendKeys("Liberty Island in New York Harbor"); 
		
		driver.findElement(By.id("inputAddress2")).sendKeys ("NY 10004"); 
		
		driver.findElement(By.id("inputState")).sendKeys ("New York"); 
		
		driver.findElement(By.id("inputZip")).sendKeys("10004");
		
		driver.findElement(By.xpath("//button [text()='Submit']")).click(); 
		
		
		String path = driver.findElement(By.cssSelector(".success-msg.hidden")).getText();
		
		String value = "Thanks for contacting us, we will get back to you shortly.";
		
		AssertJUnit.assertEquals(path, value); System.out.println(value);

		driver.quit();

    }
		

}
