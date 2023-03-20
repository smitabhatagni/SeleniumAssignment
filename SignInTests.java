package com.softwaretestingboard.magento;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
				String expectedMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
				String actualMessage = errorMessage.getText();
				Assert.assertTrue(actualMessage.contains(expectedMessage),
						"Actual message does not contain expected message.\nActual Message: " + actualMessage
								+ "\nExpected Message: " + expectedMessage);
				sleep(1000);
				
			
			
				
				driver.quit();
	
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	


	//Signing in with correct email and wrong password
		@Test(priority=3)
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
					String expectedMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
					String actualMessage = errorMessage.getText();
					Assert.assertTrue(actualMessage.contains(expectedMessage),
							"Actual message does not contain expected message.\nActual Message: " + actualMessage
									+ "\nExpected Message: " + expectedMessage);
					sleep(1000);
					
				
					
					driver.quit();
		
		}
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

		//click on forgot password
			@Test(priority=4)
			public void LoginTest4() {
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
						
						//click on forgot password
						WebElement forgot_password = driver.findElement(By.xpath("/html//form[@id='login-form']/fieldset[@class='fieldset login']//a[@href='https://magento.softwaretestingboard.com/customer/account/forgotpassword/']/span[.='Forgot Your Password?']"));
						//WebElement forgot_password = driver.findElement(By.xpath("//div[@class='action remind']//a[@href='https://magento.softwaretestingboard.com/customer/account/forgotpassword/'"));
						forgot_password.click();
						
						//expected page
						String ExpectedUrl1 = "https://magento.softwaretestingboard.com/customer/account/forgotpassword/";
						String ActualUrl1 = driver.getCurrentUrl();
						Assert.assertEquals(ActualUrl1,ExpectedUrl1,"Actual Url is not same as the expected url");
						sleep(1000);
						
						//enter email
						WebElement email = driver.findElement(By.id("email_address"));
						email.sendKeys("abc@hotmail.com");
						sleep(1000);
						
						//enter captcha
						WebElement captcha = driver.findElement(By.id("captcha_user_forgotpassword"));
						captcha.sendKeys("     ");
						sleep(10000);
						
						//click on reset my password button
						WebElement reset= driver.findElement(By.xpath("//form[@id='form-validate']//button[@type='submit']/span[.='Reset My Password']"));
						reset.click();
						
						//expected page
						String ExpectedUrl2 = "https://magento.softwaretestingboard.com/customer/account/login/";
						String ActualUrl2 = driver.getCurrentUrl();
						Assert.assertEquals(ActualUrl2,ExpectedUrl2,"Actual Url is not same as the expected url");
						sleep(1000);
						
						//message

						WebElement successMessage = driver.findElement(By.xpath("//main[@id='maincontent']//div[@role='alert']/div/div"));
						String expectedMessage = "If there is an account associated with abc@hotmail.com you will receive an email with a link to reset your password.";
						String actualMessage = successMessage.getText();
						Assert.assertTrue(actualMessage.contains(expectedMessage),
								"Actual message does not contain expected message.\nActual Message: " + actualMessage
										+ "\nExpected Message: " + expectedMessage);
						sleep(1000);
						
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
