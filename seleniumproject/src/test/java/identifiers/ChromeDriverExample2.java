
package identifiers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverExample2 {

	WebDriver Driver;

	@BeforeMethod
	public void setup() {
		System.out.println("Befor Method");
		WebDriverManager.chromedriver().setup();
		Driver = new ChromeDriver();
		Driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}

	@Test
	public void testAddressBookSignIn() throws InterruptedException {
		System.out.println("In test");
		Driver.get("http://a.testaddressbook.com/");
		Driver.manage().window().maximize();

		Thread.sleep(3000);

		WebElement signIn = Driver.findElement(By.linkText("Sign in"));
		signIn.click();
		WebElement Email = Driver.findElement(By.name("session[email]"));
		Email.sendKeys("mansoorahmed2214@gmail.com");
		WebElement Password = Driver.findElement(By.id("session_password"));
		Password.sendKeys("Ma@1998.");
		
		WebElement SignInButton = Driver.findElement(By.name("commit"));
		SignInButton.click();
		
		WebElement Home = Driver.findElement(By.tagName("a"));
		Home.click();
		
		WebElement addresses = Driver.findElement(By.partialLinkText("Addresses"));
		addresses.click();
		Thread.sleep(5000);
		
		WebElement newaddresses = Driver.findElement(By.linkText("New Address"));
		newaddresses.click();
		Thread.sleep(5000);
	}

	/*
	 * @Test public void testAddressBookSignIn2() throws InterruptedException {
	 * System.out.println("In test");
	 * 
	 * Driver.get("http://a.testaddressbook.com/");
	 * Driver.manage().window().maximize();
	 * 
	 * Thread.sleep(3000);
	 * 
	 * WebElement signIn = Driver.findElement(By.id("sign-in")); signIn.click();
	 * 
	 * WebElement SignInButton = Driver.findElement(By.name("commit"));
	 * SignInButton.click();
	 * 
	 * Thread.sleep(5000); }
	 */

	@AfterMethod
	public void tearDown() {
		System.out.println("In after Method");
		Driver.close();
		Driver.quit();
	}

}
