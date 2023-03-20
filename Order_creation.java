package com.softwaretestingboard.magento;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Order_creation {

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

		// Click on sign in button
		WebElement SignIn_button = driver.findElement(By.xpath("//button[@id='send2']/span"));
		SignIn_button.click();

		// Verifying url
		String ExpectedUrl = "https://magento.softwaretestingboard.com/customer/account/";
		String ActualUrl = driver.getCurrentUrl();
		Assert.assertEquals(ActualUrl, ExpectedUrl, "Actual Url is not same as the expected url");
		sleep(1000);

		// open the test page
		driver.get(
				"https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html?product_list_mode=list");

		// click on learn more link on a particular product
		WebElement link = driver.findElement(By.xpath(
				"/html//main[@id='maincontent']/div[@class='columns']/div[@class='column main']/div[3]/ol/li[2]/div[@class='product-item-info']//a[@title='Juno Jacket']"));
		link.click();
		sleep(1000);

		String Expected_Url = "https://magento.softwaretestingboard.com/juno-jacket.html";
		String Actual_Url = driver.getCurrentUrl();
		Assert.assertEquals(Actual_Url, Expected_Url, "Actual Url is not same as the expected url");
		sleep(1000);

		WebElement size = driver.findElement(By.id("option-label-size-143-item-168"));
		size.click();

		WebElement color = driver.findElement(By.xpath(
				"//div[@id='product-options-wrapper']//div[@class='swatch-opt']/div[2]/div[@role='listbox']/div[3]"));
		color.click();
//		
//		WebElement quantity = driver.findElement(By.id("qty"));
//		quantity.sendKeys("1");
//		sleep(1000);

		WebElement clickButtonAdd = driver
				.findElement(By.xpath("//button[@id='product-addtocart-button']/span[.='Add to Cart']"));
		clickButtonAdd.click();
		sleep(1000);

	

//		//click on shopping cart link
//		WebElement shoppingcart_link = driver.findElement(By.xpath("//main[@id='maincontent']//div[@role='alert']/div//a[@href='https://magento.softwaretestingboard.com/checkout/cart/']"));
//		shoppingcart_link.click();
//		 sleep(1000);

//		// click on cart icon
//		WebElement cartIcon = driver.findElement(By.xpath(
//				"/html/body[@class='checkout-cart-index page-layout-1column']//div[@class='minicart-wrapper']/a[@href='https://magento.softwaretestingboard.com/checkout/cart/']"));
//		cartIcon.click();
//		sleep(1000);
//
//		// view and edit cart
//		WebElement checkout = driver.findElement(By.xpath(
//				"/html//div[@id='minicart-content-wrapper']//a[@href='https://magento.softwaretestingboard.com/checkout/cart/']/span[.='View and Edit Cart']"));
//		checkout.click();
//		sleep(1000);

//		String ExpectedUrl2 = "https://magento.softwaretestingboard.com/checkout/cart/";
//		String ActualUrl2 = driver.getCurrentUrl();
//		Assert.assertEquals(ActualUrl2, ExpectedUrl2, "Actual Url is not same as the expected url");
//		sleep(1000);

		driver.get("https://magento.softwaretestingboard.com/checkout/cart/");

		// click on proceed to checkout button
		WebElement proceed_to_checkout = driver.findElement(By.xpath(
				"//main[@id='maincontent']//div[@class='cart-summary']/ul//button[@title='Proceed to Checkout']/span[.='Proceed to Checkout']"));
		proceed_to_checkout.click();
		sleep(1000);

//		String ExpectedUrl3 = "https://magento.softwaretestingboard.com/checkout/cart/";
//		String ActualUrl3 = driver.getCurrentUrl();
//		Assert.assertEquals(ActualUrl3, ExpectedUrl3, "Actual Url is not same as the expected url");
//		sleep(1000);

//		 WebElement checkout2= driver.findElement(By.xpath("//main[@id='maincontent']//div[@class='cart-summary']/ul//button[@title='Proceed to Checkout']/span[.='Proceed to Checkout']"));
//		 checkout2.click();
//		 sleep(1000);

		String ExpectedUrl4 = "https://magento.softwaretestingboard.com/checkout/";
		String ActualUrl4 = driver.getCurrentUrl();
		Assert.assertEquals(ActualUrl4, ExpectedUrl4, "Actual Url is not same as the expected url");
		sleep(3000);

		WebElement company = driver.findElement(By.xpath(
				"//div[@id='shipping-new-address-form']/div[@name='shippingAddress.company']//input[@name='company']"));
		company.sendKeys("Abc");
		sleep(4000);

//		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
//				"//div[@class='control']/div[@name='shippingAddress.company']//input[@name='company']")));

//		// enter street address
		WebElement street_address = driver.findElement(By.xpath("//div[@id='shipping-new-address-form']/fieldset//div[@name='shippingAddress.street.0']//input[@name='street[0]']"));
		street_address.sendKeys("Malleshwaram");
    	sleep(5000);
//		WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(50));
//		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='shipping-new-address-form']/fieldset//div[@name='shippingAddress.street.0']//input[@name='street[0]']")));

//		WebElement street_address2 = driver.findElement(By.xpath("/html//input[@id='N05GXCA']"));
//		street_address2.sendKeys("abcdesgu");
//		//sleep(3000);
//		WebDriverWait wait3 = new WebDriverWait(driver,Duration.ofSeconds(30));
//		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html//input[@id='N05GXCA']")));
//
//		WebElement street_address3 = driver.findElement(By.xpath("/html//input[@id='LNGE4WS']"));
//		street_address3.sendKeys("qwert");
//		 sleep(3000);
//
//		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html//input[@id='LNGE4WS']")));

		// Enter city
		WebElement city = driver.findElement(By.xpath("//div[@id='shipping-new-address-form']/div[@name='shippingAddress.city']//input[@name='city']"));
		city.sendKeys("Banglore");
		sleep(4000);
//		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html//input[@id='PLT6NQI']")));

        //dropdown country
		Select dropCountry = new Select (driver.findElement(By.name("country_id")));
		dropCountry.selectByVisibleText("India");
		sleep(4000);
//		WebDriverWait wait_to_select = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait_to_select.until(ExpectedConditions.visibilityOfElementLocated(By.name("country_id")));

		//dropdown state
		Select dropState= new Select (driver.findElement(By.name("region_id")));
		dropState.selectByVisibleText("Karnataka");
		sleep(4000);
//		WebDriverWait wait_select = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait_select.until(ExpectedConditions.visibilityOfElementLocated(By.name("region_id")));
		
		//postal/zip code
		WebElement post_code = driver.findElement(By.xpath("/html//input[@name='postcode']"));
		post_code.sendKeys("560055");
		sleep(4000);
//		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(50));
//		wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html//input[@id='NFRWGRD']")));
		
		//phone number
		WebElement phone_no = driver.findElement(By.xpath("/html//input[@name='telephone']"));
		phone_no.sendKeys("9876543210");
		sleep(3000);

//		WebDriverWait wait7 = new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html//input[@id='IOGO7JB']")));

		// click on next button
		WebElement next = driver.findElement(
				By.xpath("//div[@id='shipping-method-buttons-container']//button[@type='submit']/span[.='Next']"));
		next.click();
		sleep(2000);

//expected page 
		String ExpectedUrl5 = "https://magento.softwaretestingboard.com/checkout/#payment";
		String ActualUrl5 = driver.getCurrentUrl();
		Assert.assertEquals(ActualUrl5, ExpectedUrl5, "Actual Url is not same as the expected url");
		sleep(2000);

		WebElement placeOrder_btn = driver.findElement(By.xpath(
				"//div[@id='checkout-payment-method-load']//div[@class='payment-group']/div[2]//button[@title='Place Order']/span[.='Place Order']"));
		placeOrder_btn.click();
		sleep(3000);

		//expected page 
		String ExpectedUrl6 = "https://magento.softwaretestingboard.com/checkout/onepage/success/";
		String ActualUrl6 = driver.getCurrentUrl();
		Assert.assertEquals(ActualUrl6, ExpectedUrl6, "Actual Url is not same as the expected url");
		sleep(1000);

		// Success Message
		WebElement successMessage = driver
				.findElement(By.xpath("/html//main[@id='maincontent']//span[.='Thank you for your purchase!']"));
		String expectedMessage = "Thank you for your purchase!";
		String actualMessage = successMessage.getText();
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"Actual message does not contain expected message.\nActual Message: " + actualMessage
						+ "\nExpected Message: " + expectedMessage);
		sleep(1000);

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
