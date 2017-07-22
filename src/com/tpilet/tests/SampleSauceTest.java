package com.tpilet.tests;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.gargoylesoftware.htmlunit.javascript.configuration.BrowserName;
 
public class SampleSauceTest {
 
  public static final String USERNAME = "karthiktesting05";
  public static final String ACCESS_KEY = "84434fb6-5a56-42c2-93d6-17692d0e56f9";
  public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
 
  public static void main(String[] args) throws Exception {
 
    DesiredCapabilities caps = DesiredCapabilities.chrome();
    caps.setCapability("platform", "Windows XP");
    caps.setCapability("version", "43.0");
 
    WebDriver TPilot = new RemoteWebDriver(new URL(URL), caps);
 
    TPilot.get("https://www.tpilet.ee/en");
		
		String PageTitle = "Tickets for your journeys";
		
		String RuntimeTitle = TPilot.getTitle();
		
		if(RuntimeTitle.equalsIgnoreCase(PageTitle)){
			
			System.out.println("Success, We are in right page");
			
		} else {
			
			System.out.println("Failed, We are NOT in right page");
		}
		
		TPilot.findElement(By.xpath(".//*[@id='trip-search']/form/div[1]")).click();
		
		WebElement Departure = TPilot.findElement(By.id("Departure"));
		Departure.sendKeys("Tallinn");
	
	
	TPilot.findElement(By.xpath(".//*[@id='trip-search']/form/div[2]")).click();
		
		WebElement Destination = TPilot.findElement(By.id("Destination"));
		Destination.sendKeys("Jõhvi");
	
		WebElement SearchButton = TPilot.findElement(By.xpath(".//*[@id='trip-search']/form/div[3]/input[2]"));
		SearchButton.click();
	
		WebElement ViewButton = TPilot.findElement(By.xpath(".//*[@id='all-trips']/tbody[1]/tr[1]/td[2]/input"));
		ViewButton.click(); 
  }
}