package com.softwaretestingboard.magento;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Wishlist_Editing_and_Validation_Tests {
	
WebDriver driver = new ChromeDriver();

@Test(priority = 1)
public void signUpTest1() {

	System.out.println("Starting SignUp Test");
	
	// Create Web driver
	WebDriver driver = new ChromeDriver();
	// Move browser window to the left monitor
	driver.manage().window().setPosition(new Point(-1000, 200));
	// maximize browser window
	driver.manage().window().maximize();
	
	
	//open the test page
	String url = "https://magento.softwaretestingboard.com/customer/account/create/";
	driver.get(url);
	
	//signup for an account
	//creating new account for customer
	
	//enter first name
	WebElement firstname = driver.findElement(By.id("firstname"));
	firstname.sendKeys("roopam");
	sleep(1000);
	
	//enter lastname
	WebElement lastname  = driver.findElement(By.id("lastname"));
	lastname.sendKeys("chen");
	sleep(1000);
	
	//sign up for Newsletter checkbox
	WebElement is_subscribed  = driver.findElement(By.id("is_subscribed"));
	is_subscribed.click();
	sleep(1000);
	
	//Sign in information
	//enter email
	WebElement email = driver.findElement(By.id("email_address"));
	email.sendKeys("roopamchen@gmail.com");
	sleep(1000);
	
	//enter password
	WebElement password = driver.findElement(By.id("password"));
	password.sendKeys("AsdF!23$5");
	sleep(2000);
	
	//Again enter password to confirm
	WebElement password_confirmation = driver.findElement(By.id("password-confirmation"));
	password_confirmation.sendKeys("AsdF!23$5");
	sleep(2000);
	
	//click on create account button
	WebElement create_button = driver.findElement(By.xpath("//form[@id='form-validate']//button[@title='Create an Account']/span[.='Create an Account']"));
	create_button.click();
	
	//Verification
	//verify url
	String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/";
	String actualUrl = driver.getCurrentUrl();
	Assert.assertEquals(actualUrl,expectedUrl,"Actual url is not same as the expected url");
	
	WebElement successMessage = driver.findElement(By.xpath("//main[@id='maincontent']//div[@role='alert']/div/div[.='Thank you for registering with Fake Online Clothing Store.']"));
	String expectedMessage = "Thank you for registering with Fake Online Clothing Store.";
	String actualMessage = successMessage.getText();
	Assert.assertTrue(actualMessage.contains(expectedMessage),
			"Actual message does not contain expected message.\nActual Message: " + actualMessage
					+ "\nExpected Message: " + expectedMessage);
	sleep(1000);

}

@Test(priority=2)
public void LoginTest1() {
	System.out.println("Starting Login Test");
	
	// Create Web driver
			WebDriver driver = new ChromeDriver();
			// Move browser window to the left monitor
			driver.manage().window().setPosition(new Point(-1000, 200));
			// maximize browser window
			driver.manage().window().maximize();
			
			//open the test page
			String url = "https://magento.softwaretestingboard.com/customer/account/login/";
			driver.get(url);
			
			//enter user email
			WebElement email = driver.findElement(By.id("email"));
			email.sendKeys("roopamchen@gmail.com");
			sleep(1000);
			
			//enter the password
			WebElement password = driver.findElement(By.id("pass"));
			password.sendKeys("AsdF!23$5");
			
			//Click on sign in button
			WebElement SignIn_button = driver.findElement(By.xpath("/html//form[@id='login-form']/fieldset[@class='fieldset login']//button[@name='send']/span[.='Sign In']"));
			SignIn_button.click();
			
			//Verifying url
			String ExpectedUrl = "https://magento.softwaretestingboard.com/customer/account/";
			String ActualUrl = driver.getCurrentUrl();
			Assert.assertEquals(ActualUrl,ExpectedUrl,"Actual Url is not same as the expected url");
			sleep(1000);
			
			System.out.println("Successfully logged in to the online store");
	
			
}

	
	@Test(priority = 3)
	public void WishlistEditing() {
		
		System.out.println("Entering the Home page to select and add items to the wishlist");
		
		// Create Web driver
		WebDriver driver = new ChromeDriver();
		// Move browser window to the left monitor
		driver.manage().window().setPosition(new Point(-1000, 200));
		// maximize browser window
		driver.manage().window().maximize();
		
		//open the test page
		String url = "https://magento.softwaretestingboard.com/wishlist/" ;
		driver.get(url);
		
		
		 WebElement edit = driver.findElement(By.xpath("//form[@id='wishlist-view-form']//ol[@class='product-items']/li[@class='product-item']/div[@class='product-item-info']//a[@href='https://magento.softwaretestingboard.com/wishlist/index/configure/id/10895/product_id/1380/']"));
			edit.click();
			sleep(1000);
	 
	 
	 WebElement size= driver.findElement(By.xpath("//div[@id='product-options-wrapper']//div[@class='swatch-opt']/div[1]/div[@role='listbox']/div[3]"));
		size.click();
		sleep(1000);
		
	
		
		 WebElement color = driver.findElement(By.xpath("//div[@id='product-options-wrapper']//div[@class='swatch-opt']/div[2]/div[@role='listbox']/div[3]"));
			color.click();
			sleep(1000);
			
		

			 WebElement update_wishlist = driver.findElement(By.xpath("/html//main[@id='maincontent']//div[@class='product-addto-links']/a[1]/span[.='Update Wish List']"));
				update_wishlist.click();
				sleep(1000);
				

				String ExpectedUrl = "https://magento.softwaretestingboard.com/wishlist/index/index/wishlist_id/46260/";
				String ActualUrl = driver.getCurrentUrl();
				Assert.assertEquals(ActualUrl,ExpectedUrl,"Actual Url is not same as the expected url");
				sleep(1000);
				
				WebElement successMessage = driver.findElement(By.xpath("//main[@id='maincontent']//div[@role='alert']/div/div[.='Juno Jacket has been updated in your Wish List.']"));
				String expectedMessage = "Juno Jacket has been updated in your Wish List.";
				String actualMessage = successMessage.getText();
				Assert.assertTrue(actualMessage.contains(expectedMessage),
						"Actual message does not contain expected message.\nActual Message: " + actualMessage
								+ "\nExpected Message: " + expectedMessage);
				sleep(1000);
				
			}	
	
	@AfterMethod(alwaysRun = true)
	private void tearDown() {
		// Close browser
		driver.quit();
	}
		

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
