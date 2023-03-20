package com.softwaretestingboard.magento;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Validate_orders {
	
	WebDriver driver = new ChromeDriver();

	@Test(priority = 1)
	public void addTocart() {

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
		email.sendKeys("devtom@gmail.com");
		sleep(1000);

		// enter the password
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys("AsdF!23$5");
		sleep(1000);

		// Click on sign in button
		WebElement SignIn_button = driver.findElement(By.xpath("//button[@id='send2']/span"));
		SignIn_button.click();
		
		// Verifying url
				String ExpectedUrl1 = "https://magento.softwaretestingboard.com/customer/account/";
				String ActualUrl1 = driver.getCurrentUrl();
				Assert.assertEquals(ActualUrl1, ExpectedUrl1, "Actual Url is not same as the expected url");
				sleep(1000);
		
				//Go to my order section
				WebElement my_order = driver.findElement(By.xpath("//div[@id='block-collapsible-nav']/ul//a[@href='https://magento.softwaretestingboard.com/sales/order/history/']"));
				my_order.click();
				sleep(1000);
				
				// Verifying url
				String ExpectedUrl2 = "https://magento.softwaretestingboard.com/sales/order/history/";
				String ActualUrl2 = driver.getCurrentUrl();
				Assert.assertEquals(ActualUrl2, ExpectedUrl2, "Actual Url is not same as the expected url");
				sleep(1000);
				
				//click on view order button
				WebElement view_order = driver.findElement(By.xpath("//table[@id='my-orders-table']/tbody/tr/td[6]/a[@href='https://magento.softwaretestingboard.com/sales/order/view/order_id/940/']/span[.='View Order']"));
				view_order.click();
				sleep(1000);
				
				//expected page
				String ExpectedUrl3 = "https://magento.softwaretestingboard.com/sales/order/view/order_id/940/";
				String ActualUrl3 = driver.getCurrentUrl();
				Assert.assertEquals(ActualUrl3, ExpectedUrl3, "Actual Url is not same as the expected url");
				sleep(1000);
				
				//validation
				//checking order number
				WebElement order_no = driver.findElement(By.xpath("/html//main[@id='maincontent']/div[@class='columns']//span[.='Order # 000000940']"));
				String expected_orderNo = "Order # 000000940";
				String actual_orderNo = order_no.getText();
				Assert.assertTrue(actual_orderNo.contains(expected_orderNo),
						"Actual message does not contain expected message.\nActual Message: " + actual_orderNo
								+ "\nExpected Message: " + expected_orderNo);
				System.out.println("Order number is correct");
				
				//click on print order
				WebElement print= driver.findElement(By.xpath("/html//main[@id='maincontent']/div[@class='columns']//a[@href='https://magento.softwaretestingboard.com/sales/order/print/order_id/940/']/span[.='Print Order']"));
				print.click();
				sleep(1000);
				
				//expected page
				String ExpectedUrl5 = "https://magento.softwaretestingboard.com/sales/order/view/order_id/940/";
				String ActualUrl5 = driver.getCurrentUrl();
				Assert.assertEquals(ActualUrl5, ExpectedUrl5, "Actual Url is not same as the expected url");
				sleep(1000);
				
				System.out.println("Validation Successful.");
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
