package com.softwaretestingboard.magento;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SignInTests {
	
	WebDriver driver = new ChromeDriver();
	
	@Test(priority=1)
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
				email.sendKeys("roopamshas123@gmail.com");
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
			
				
				driver.quit();
				
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	
//Signing in with wrong email and right password
	@Test(priority=2 )
	public void LoginTest2() {
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
				email.sendKeys("Jin@gmail.com");
				sleep(1000);
				
				//enter the password
				WebElement password = driver.findElement(By.id("pass"));
				password.sendKeys("AsdF!23$5");
				
				//Click on sign in button
				WebElement SignIn_button = driver.findElement(By.xpath("/html//form[@id='login-form']/fieldset[@class='fieldset login']//button[@name='send']/span[.='Sign In']"));
				SignIn_button.click();
				
				//Verifying url
				String ExpectedUrl = "https://magento.softwaretestingboard.com/customer/account/login/";
				String ActualUrl = driver.getCurrentUrl();
				Assert.assertEquals(ActualUrl,ExpectedUrl,"Actual Url is not same as the expected url");
				sleep(1000);
				
				

				WebElement errorMessage = driver.findElement(By.xpath("//main[@id='maincontent']//div[@role='alert']/div/div"));
				String expectedMessage = "Incorrect CAPTCHA";
				String actualMessage = errorMessage.getText();
				Assert.assertTrue(actualMessage.contains(expectedMessage),
						"Actual message does not contain expected message.\nActual Message: " + actualMessage
								+ "\nExpected Message: " + expectedMessage);
				sleep(1000);
				
			
			
				
				driver.quit();
	
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	


	//Signing in with correct email and wrong password
		@Test(priority=3 )
		public void LoginTest3() {
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
					email.sendKeys("abc@hotmail.com");
					sleep(1000);
					
					//enter the password
					WebElement password = driver.findElement(By.id("pass"));
					password.sendKeys("abcdefg123");
					
					//Click on sign in button
					WebElement SignIn_button = driver.findElement(By.xpath("/html//form[@id='login-form']/fieldset[@class='fieldset login']//button[@name='send']/span[.='Sign In']"));
					SignIn_button.click();
					
					//Verifying url
					String ExpectedUrl = "https://magento.softwaretestingboard.com/customer/account/login/";
					String ActualUrl = driver.getCurrentUrl();
					Assert.assertEquals(ActualUrl,ExpectedUrl,"Actual Url is not same as the expected url");
					sleep(1000);
					

					WebElement errorMessage = driver.findElement(By.xpath("//main[@id='maincontent']//div[@role='alert']/div/div"));
					String expectedMessage = "Incorrect CAPTCHA";
					String actualMessage = errorMessage.getText();
					Assert.assertTrue(actualMessage.contains(expectedMessage),
							"Actual message does not contain expected message.\nActual Message: " + actualMessage
									+ "\nExpected Message: " + expectedMessage);
					sleep(1000);
					
				
					
					driver.quit();
		
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
