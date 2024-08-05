package Selenium101.Self;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;


public class testScenario1 {
	
	
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
		driver.findElement(By.xpath("//a[text()='Simple Form Demo']")).click();
		
		// Get the page title
        String url = driver.getCurrentUrl();
        
        System.out.println(url);
        

        // Verify if the title contains "simple-form-demo"
        if (url.contains("simple-form-demo")) {
            System.out.println("Page title contains 'simple-form-demo': " + url);
            
        } else {
            System.out.println("Page title does not contain 'simple-form-demo': " + url);
        }
		
		
		String var = "Welcome to LambdaTest"; 
		
		driver.findElement(By.id("user-message")).sendKeys(var);
		
		driver.findElement(By.id("showInput")).click();
		
		
		String message = driver.findElement(By.id("message")).getText();
		
		AssertJUnit.assertEquals(var, message);
		
		driver.quit();
		
	}

}
