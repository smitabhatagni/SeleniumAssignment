package com.softwaretestingboard.magento;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTests{

	WebDriver driver = new ChromeDriver();

	//Signing up with all right credentials
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
		firstname.sendKeys("Tom");
		sleep(1000);
		
		//enter lastname
		WebElement lastname  = driver.findElement(By.id("lastname"));
		lastname.sendKeys("Dev");
		sleep(1000);
		
		//sign up for Newsletter checkbox
		WebElement is_subscribed  = driver.findElement(By.id("is_subscribed"));
		is_subscribed.click();
		sleep(1000);
		
		//Sign in information
		//enter email
		WebElement email = driver.findElement(By.id("email_address"));
		email.sendKeys("devtom@gmail.com");
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
		
		WebElement successMessage = driver.findElement(By.xpath("//main[@id='maincontent']//div[@role='alert']/div/div[.='Thank you for registering with Main Website Store.']"));
		String expectedMessage = "Thank you for registering with Main Website Store.";
		String actualMessage = successMessage.getText();
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"Actual message does not contain expected message.\nActual Message: " + actualMessage
						+ "\nExpected Message: " + expectedMessage);
		sleep(1000);
		
		//close browser
		driver.quit();
		
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	//signing up with wrong password in confirmation field
	@Test(priority = 2 , enabled=false)
	
	public void signUpTest2() {

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
		firstname.sendKeys("roopa");
		sleep(1000);
		
		//enter lastname
		WebElement lastname  = driver.findElement(By.id("lastname"));
		lastname.sendKeys("shastri");
		sleep(1000);
		
		//sign up for Newsletter checkbox
		WebElement is_subscribed  = driver.findElement(By.id("is_subscribed"));
		is_subscribed.click();
		sleep(1000);
		
		//Sign in information
		//enter email
		WebElement email = driver.findElement(By.id("email_address"));
		email.sendKeys("roopamshas123@gmail.com");
		sleep(1000);
		
		//enter password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("AsdF!23$5");
		sleep(2000);
		
		//Again enter password to confirm
		WebElement password_confirmation = driver.findElement(By.id("password-confirmation"));
		password_confirmation.sendKeys("Abcd!23456");
		sleep(2000);
			
		//click on create account button
		WebElement create_button = driver.findElement(By.xpath("//form[@id='form-validate']//button[@title='Create an Account']/span[.='Create an Account']"));
		create_button.click();
		
		//Verification
		//verify url
		String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/create/";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl,expectedUrl,"Actual url is not same as the expected url");
		
		WebElement errormessage = driver.findElement(By.xpath("/html//div[@id='password-confirmation-error']"));
		String expectedmessage = "password-confirmation-error";
		String actualmessage = errormessage.getText();
		Assert.assertTrue(actualmessage.contains(expectedmessage),
				"Actual message does not contain expected message.\nActual Message: " + actualmessage
						+ "\nExpected Message: " + expectedmessage);
		sleep(1000);
		
		
		
		//close browser
		driver.quit();
		
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	//Trying to create account with email address which is already registered
	
	@Test(priority = 3 , enabled = false)
	public void signUpTest3() {

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
		lastname.sendKeys("shastri");
		sleep(1000);
		
		//sign up for Newsletter checkbox
		WebElement is_subscribed  = driver.findElement(By.id("is_subscribed"));
		is_subscribed.click();
		sleep(1000);
		
		//Sign in information
		//enter email
		WebElement email = driver.findElement(By.id("email_address"));
		email.sendKeys("roopamshas123@gmail.com");
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
		String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/create/";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl,expectedUrl,"Actual url is not same as the expected url");
		
		WebElement errorMessage = driver.findElement(By.xpath("//main[@id='maincontent']//div[@role='alert']/div/div"));
		String expectedMessage = "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.";
		String actualMessage = errorMessage.getText();
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"Actual message does not contain expected message.\nActual Message: " + actualMessage
						+ "\nExpected Message: " + expectedMessage);
		sleep(1000);
		
		//close browser
		driver.quit();
		driver.close();
		
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
