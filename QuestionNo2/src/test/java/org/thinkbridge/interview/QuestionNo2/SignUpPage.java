package org.thinkbridge.interview.QuestionNo2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpPage {
	
	WebDriver driver=null;
	String Name="Himmatrao Bochare";
	String Email="himmatraobochare1234@gmail.com";
	String ActualString="A welcome email has been sent. Please check your email.";
	
	@BeforeMethod
	public void launchBrowser()
	{
		
		System.setProperty("webdriver.gecko.driver","D:\\geckodriver\\geckodriver.exe");
		
		// initialize a driver object of Firefox class by using reference of WebDriver and launch the browser.
		driver=new FirefoxDriver();
		
		// Maximize the browser. 
	    driver.manage().window().maximize(); 
		
	    // Declare a variable URL of type String and store the URL. 
	    String URL="https://jt-dev.azurewebsites.net/#/SignUp";
	    
	    // Call get() method to open the web page URL and pass URL as a parameter. 
		driver.get(URL);
		
		// Wait for some time to load the whole web page.
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void signUp() throws InterruptedException
	{
		
		//Locate the element and check bydefault english lang is selected or not.
	
		String byDefaultSelectedLang=driver.findElement(By.xpath("//body[1]/div[1]/div[2]/section[1]/div[1]/div[2]/section[1]/div[1]/div[1]")).getText();
		
		System.out.println("byDefault Selected Lang is :" +byDefaultSelectedLang);
 
		// Locate dropdown element on web page by By.xpath. 
		WebElement element=driver.findElement(By.xpath("//body[1]/div[1]/div[2]/section[1]/div[1]/div[2]/section[1]/div[1]/div[1]/span[1]/i[1]"));
		//click on element it will give you two options as english and dutch.
		element.click();
		   Thread.sleep(1000);
		//select english as lang.
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/section[1]/div[1]/div[2]/section[1]/div[1]/ul[1]/li[1]/div[3]/a[1]/div[1]")).click();
		Thread.sleep(1000);
		
		//Now find whether english lang is selected or not.
		String CheckSelectedLang=driver.findElement(By.xpath("//body[1]/div[1]/div[2]/section[1]/div[1]/div[2]/section[1]/div[1]/div[1]")).getText();
		
		System.out.println("Selected Lang is :" +CheckSelectedLang);
		
	
		//Find FullNameField and Entered your Name.
		driver.findElement(By.xpath("//body[1]/div[1]/div[2]/section[1]/div[1]/div[3]/div[1]/section[1]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/input[1]")).sendKeys(Name);
		
		
		//wait for some time
		Thread.sleep(1000);
		
		//Now Find Organization Input field and entered your name as a input.
		
		driver.findElement(By.xpath("//body[1]/div[1]/div[2]/section[1]/div[1]/div[3]/div[1]/section[1]/div[1]/form[1]/fieldset[1]/div[2]/div[1]/input[1]")).sendKeys(Name);
		
		Thread.sleep(1000);
		
		//Find Email input field and entered email id in it.
		driver.findElement(By.xpath("//body[1]/div[1]/div[2]/section[1]/div[1]/div[3]/div[1]/section[1]/div[1]/form[1]/fieldset[1]/div[3]/div[1]/input[1]")).sendKeys(Email);
		
		Thread.sleep(1000);
		
		
		//find checkbox for I agree to the Terms And Conditions and click on it.
		driver.findElement(By.xpath("//body[1]/div[1]/div[2]/section[1]/div[1]/div[3]/div[1]/section[1]/div[1]/form[1]/fieldset[1]/div[4]/label[1]/span[1]")).click();
		
		Thread.sleep(1000);
		 //Now click on getstarted button.
		driver.findElement(By.xpath("//body[1]/div[1]/div[2]/section[1]/div[1]/div[3]/div[1]/section[1]/div[1]/form[1]/fieldset[1]/div[5]")).click();
	
		Thread.sleep(5000);
		//Validate mail on mail message alert
		String Message=driver.findElement(By.xpath("//body[1]/div[1]/div[2]/section[1]/div[1]/div[3]/div[1]/section[1]/div[1]/form[1]/div[1]")).getText();
	
		
		System.out.println(Message);
		
		if(ActualString.equals(Message))
		{
			System.out.println("Mail Successfully Send");
		}else
		{
			System.out.println("someting went wrong");
		}
		
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		 driver.close(); 
	}
	}
	


