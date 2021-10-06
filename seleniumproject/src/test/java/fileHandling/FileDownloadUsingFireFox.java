package fileHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownloadUsingFireFox {

	WebDriver driver;

	@BeforeTest
	public void beforeTest() {

		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain,application/pdf");
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("pdfjs.disabled", true);

		FirefoxOptions Options = new FirefoxOptions();
		Options.setProfile(profile);
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(Options);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();

	}

	@Test
	public void test() {

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
