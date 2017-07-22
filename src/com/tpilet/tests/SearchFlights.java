package com.tpilet.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchFlights {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver TPilot;
		File file = new File("driver//chromedriver.exe");
 		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
 		TPilot = new ChromeDriver();
 		TPilot.manage().window().maximize();
 		
 		TPilot.get("https://www.tpilet.ee/en");
 		
 		String PageTitle = "Tickets for your journeys";
 		
 		String RuntimeTitle = TPilot.getTitle();
 		
 		if(RuntimeTitle.equalsIgnoreCase(PageTitle)){
 			
 			System.out.println("Right Page");
 			
 		} else {
 			
 			System.out.println("Wrong page");
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
