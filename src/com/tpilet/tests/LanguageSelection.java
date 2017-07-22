package com.tpilet.tests;

import java.util.List;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LanguageSelection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver TPilot;
		File file = new File("driver//chromedriver.exe");
 		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
 		TPilot = new ChromeDriver();
 		TPilot.manage().window().maximize();
 		
 		TPilot.get("https://www.tpilet.ee/en");
 		
 		WebElement Language = TPilot.findElement(By.id("langSelMenu"));
  	  
 		Select LanguageList = new Select(Language);
 	  
 		LanguageList.selectByVisibleText("est");
 	   
 		String PageTitle = "Piletid sinu teekonnale";
 		
 		String RuntimeTitle = TPilot.getTitle();
 		
 		if(RuntimeTitle.equalsIgnoreCase(PageTitle)){
 			
 			System.out.println("Success, We are in right page");
 			
 		} else {
 			
 			System.out.println("Failed, We are NOT in right page");
 		}
 		
  		TPilot.close();
		
	}
}
