package fileHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownload {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
	/*	ChromeOptions Options = new ChromeOptions();
		Options.setExperimentalOption("debuggerAddress", "localhost:2214");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(Options);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		
*/
		
		ChromeOptions Options = new ChromeOptions();
		Options.setExperimentalOption("debuggerAddress", "localhost:2214");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(Options);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
	}

	@Test
	public void test() {
//		driver.get("http://a.testaddressbook.com/addresses/new");
		
	    driver.get("http://demo.automationtesting.in/FileDownload.html");
		
		WebElement textbox = driver.findElement(By.id("textbox"));
		textbox.sendKeys("Hello World");
		
		WebElement createText = driver.findElement(By.id("createTxt"));
		createText.click();
		
		WebElement download = driver.findElement(By.id("link-to-download"));
		download.click();

	}

	@AfterTest
	public void afterTest() {
		
//		driver.close();
//		driver.quit();

	}
}
