package windowsAndTabHandling;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {
	static WebDriver driver;

	@BeforeTest
	public static void beforeTest() {

		ChromeOptions Options = new ChromeOptions();
		Options.setExperimentalOption("debuggerAddress", "localhost:2214");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

	}

	@Test

	public static void test() {

		driver.get("https://demoqa.com/browser-windows");

		WebElement WindowButton = driver.findElement(By.id("windowButton"));
		WindowButton.click();

		String parentwindow = driver.getWindowHandle();
		Set<String> Allwindows = driver.getWindowHandles();
		
		for (String windows:Allwindows ) {
			
			if(!windows.equals(parentwindow)) {
				driver.switchTo().window(windows);
				WebElement h1 = driver.findElement(By.cssSelector("#sampleHeading"));
				Assert.assertEquals(h1.getText(), "This is a sample page", "Message mismatch");
				driver.close();
			}
			
			driver.switchTo().window(parentwindow);
			
		}

	}

	@AfterTest
	public static void afterTest() {
//		driver.close();
//		driver.quit();

	}

}
