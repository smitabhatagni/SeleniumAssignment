package com.softwaretestingboard.magento;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CompareListTests {
	
	WebDriver driver = new ChromeDriver();
	
	@Test(priority = 1)
	public void compareitemslist() {
		

		// Create Web driver
		WebDriver driver = new ChromeDriver();
		// Move browser window to the left monitor
		driver.manage().window().setPosition(new Point(-1000, 200));
		// maximize browser window
		driver.manage().window().maximize();

		// open the login page
		String url = "https://magento.softwaretestingboard.com/customer/account/login/";
		driver.get(url);

		// enter user email
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("roopamshas123@gmail.com");
		sleep(1000);

		// enter the password
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys("AsdF!23$5");

		// Click on sign in button
		WebElement SignIn_button = driver.findElement(By.xpath(
				"/html//form[@id='login-form']/fieldset[@class='fieldset login']//button[@name='send']/span[.='Sign In']"));
		SignIn_button.click();

		// Verifying url
		String ExpectedUrl = "https://magento.softwaretestingboard.com/customer/account/";
		String ActualUrl = driver.getCurrentUrl();
		Assert.assertEquals(ActualUrl, ExpectedUrl, "Actual Url is not same as the expected url");
		sleep(1000);

		//Creating comparision list
		//1st product
		driver.get("https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html?product_list_mode=list");
		
		WebElement compare_btn1 = driver.findElement(By.xpath("/html//main[@id='maincontent']/div[@class='columns']/div[@class='column main']/div[3]/ol/li[1]/div[@class='product-item-info']//div[@class='actions-secondary']/a[2]"));
		compare_btn1.click();
		sleep(1000);
		

		WebElement successMessage1 = driver.findElement(By.xpath("//main[@id='maincontent']//div[@role='alert']/div/div"));
		String expectedMessage1 = "You added product Olivia 1/4 Zip Light Jacket to the comparison list.";
		String actualMessage1 = successMessage1.getText();
		Assert.assertTrue(actualMessage1.contains(expectedMessage1),
				"Actual message does not contain expected message.\nActual Message: " + actualMessage1
						+ "\nExpected Message: " + expectedMessage1);
		sleep(1000);
		
		
		//2nd product
		driver.get("https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html?product_list_mode=list");
		

		WebElement compare_btn2 = driver.findElement(By.xpath("/html//main[@id='maincontent']/div[@class='columns']/div[@class='column main']/div[3]/ol/li[2]/div[@class='product-item-info']//div[@class='actions-secondary']/a[2]"));
		compare_btn2.click();
		sleep(1000);
		

		WebElement successMessage2 = driver.findElement(By.xpath("//main[@id='maincontent']//div[@role='alert']/div/div"));
		String expectedMessage2 = "You added product Juno Jacket to the comparison list.";
		String actualMessage2 = successMessage2.getText();
		Assert.assertTrue(actualMessage2.contains(expectedMessage2),
				"Actual message does not contain expected message.\nActual Message: " + actualMessage2
						+ "\nExpected Message: " + expectedMessage2);
		sleep(1000);
		
        
		//3rd product
		
		driver.get("https://magento.softwaretestingboard.com/women/tops-women/hoodies-and-sweatshirts-women.html?product_list_mode=list");
		

		WebElement compare_btn3 = driver.findElement(By.xpath("/html//main[@id='maincontent']/div[@class='columns']/div[@class='column main']/div[3]/ol/li[1]/div[@class='product-item-info']//div[@class='actions-secondary']/a[2]"));
		compare_btn3.click();
		sleep(1000);
		

		WebElement successMessage3 = driver.findElement(By.xpath("//main[@id='maincontent']//div[@role='alert']/div/div"));
		String expectedMessage3 = "You added product Circe Hooded Ice Fleece to the comparison list.";
		String actualMessage3 = successMessage3.getText();
		Assert.assertTrue(actualMessage3.contains(expectedMessage3),
				"Actual message does not contain expected message.\nActual Message: " + actualMessage3
						+ "\nExpected Message: " + expectedMessage3);
		sleep(1000);
		
		
		//Add products to comparision list
		WebElement compare = driver.findElement(By.xpath("//main[@id='maincontent']//div[@role='alert']/div//a[@href='https://magento.softwaretestingboard.com/catalog/product_compare/']"));
		compare.click();
		sleep(1000);
		
		String ExpectedUrl2 = "https://magento.softwaretestingboard.com/catalog/product_compare/";
		String ActualUrl2 = driver.getCurrentUrl();
		Assert.assertEquals(ActualUrl2,ExpectedUrl2,"Actual Url is not same as the expected url");
		sleep(1000);


		WebElement successpage = driver.findElement(By.xpath("/html//main[@id='maincontent']//span[.='Compare Products']"));
		String expectedpage = "Compare Products";
		String actualpage = successpage.getText();
		Assert.assertTrue(actualpage.contains(expectedpage),
				"Actual message does not contain expected message.\nActual Message: " + actualpage
						+ "\nExpected Message: " + expectedpage);
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
