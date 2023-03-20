package com.softwaretestingboard.magento;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class WishlistCreationTests {

	WebDriver driver = new ChromeDriver();

	@Test(priority = 1)
	public void WishlistCreation() {

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

		// Creating wishlist

		System.out.println("Entering the Home page to select and add items to the wishlist");

		String url1 = "https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html?product_list_mode=list";
		driver.get(url1);

		// click on the link Learnmore
		WebElement link = driver.findElement(By.xpath(
				"/html//main[@id='maincontent']/div[@class='columns']/div[@class='column main']/div[3]/ol/li[1]/div[@class='product-item-info']//a[@title='Olivia 1/4 Zip Light Jacket']"));
		link.click();
		sleep(1000);

		String ExpectedUrl1 = "https://magento.softwaretestingboard.com/olivia-1-4-zip-light-jacket.html";
		String ActualUrl1 = driver.getCurrentUrl();
		Assert.assertEquals(ActualUrl1, ExpectedUrl1, "Actual Url is not same as the expected url");
		sleep(1000);

		// Adding products to wishlist
		WebElement product1 = driver.findElement(By.xpath(
				"/html//main[@id='maincontent']//div[@class='product-addto-links']/a[1]/span[.='Add to Wish List']"));
		product1.click();
		sleep(1000);

//		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html//main[@id='maincontent']//div[@class='product-addto-links']/a[1]/span[.='Add to Wish List']")));

		WebElement successMessage = driver
				.findElement(By.xpath("//main[@id='maincontent']//div[@role='alert']/div/div"));
		String expectedMessage = "Olivia 1/4 Zip Light Jacket has been added to your Wish List. Click here to continue shopping.";
		String actualMessage = successMessage.getText();
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"Actual message does not contain expected message.\nActual Message: " + actualMessage
						+ "\nExpected Message: " + expectedMessage);
		sleep(1000);

		WebElement goToWishlist = driver.findElement(By.xpath(
				"//main[@id='maincontent']//div[@class='block block-wishlist']//div[@class='actions-toolbar']//a[@title='Go to Wish List']/span[.='Go to Wish List']"));
		goToWishlist.click();
		sleep(1000);

		String ExpectedUrl2 = "https://magento.softwaretestingboard.com/wishlist/";
		String ActualUrl2 = driver.getCurrentUrl();
		Assert.assertEquals(ActualUrl2, ExpectedUrl2, "Actual Url is not same as the expected url");
		sleep(1000);

		System.out.println("Product is added to wishlist");

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
