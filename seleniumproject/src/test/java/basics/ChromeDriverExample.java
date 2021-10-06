package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverExample {
	WebDriver Driver;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		Driver = new ChromeDriver();

	}

	@Test
	public void testAddressBookSignIn() throws InterruptedException {
		System.out.println("In test");
		Driver.get("http://a.testaddressbook.com/");
		Driver.manage().window().maximize();

		Thread.sleep(3000);

		WebElement signIn = Driver.findElement(By.id("sign-in"));
		signIn.click();

		Thread.sleep(5000);
	}

	@Test
	public void testAddressBookSignIn2() throws InterruptedException {
		System.out.println("In test");

		Driver.get("http://a.testaddressbook.com/");
		Driver.manage().window().maximize();

		Thread.sleep(3000);

		WebElement signIn = Driver.findElement(By.id("sign-in"));
		signIn.click();

		Thread.sleep(5000);
	}

	@AfterClass
	public void tearDown() {
		Driver.close();
		Driver.quit();
	}

}
