package Selenium101.Self;

import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;


public class testScenario2 {
	
	
	RemoteWebDriver driver ;
	
	@SuppressWarnings("deprecation")
	@Test
	public void Verifyform() throws InterruptedException, MalformedURLException {
		
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
	
		driver.get("https://www.lambdatest.com/selenium-playground/");
		
		driver.findElement(By.xpath("//a[text()='Drag & Drop Sliders']")).click();
		
        Actions builder = new Actions (driver); 
        
        WebElement sourceEle = driver.findElement(By.xpath("//input[@value='15']"));
       
       builder.dragAndDropBy(sourceEle, 215, 95).build().perform();
       
        driver.quit();
       
    }
		

}
