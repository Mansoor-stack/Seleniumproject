package fileHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {

		ChromeOptions Options = new ChromeOptions();
		Options.setExperimentalOption("debuggerAddress", "localhost:2214");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(Options);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();

	}

	@Test
	public void test() {

		driver.get("http://a.testaddressbook.com/addresses/new");

		WebElement uploadelement = driver.findElement(By.name("address[picture]"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", uploadelement);
		uploadelement.sendKeys("C:\\Users\\MANSOOR...KHAN\\Desktop\\HelloWorld.txt");

	}

	@AfterTest
	public void afterTest() {

		// driver.close();
//		driver.quit();
	}
}
