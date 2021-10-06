package popUpAndAlertHandling;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsHandling {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {

		ChromeOptions Options = new ChromeOptions();
		Options.setExperimentalOption("debuggerAddress", "localhost:2214");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(Options);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void test() throws InterruptedException, IOException {

		driver.get("https://demoqa.com/alerts");
		
//	Simple Alert
		WebElement alertButton = driver.findElement(By.id("alertButton"));
		alertButton.click();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		String alertmessage = alert.getText();
		alert.accept();
		System.out.println(alertmessage);
//	promptAlert
		WebElement promptAlertButton = driver.findElement(By.id("promtButton"));
		promptAlertButton.click();
		Thread.sleep(5000);
		Alert promptAlert = driver.switchTo().alert();
		Thread.sleep(5000);
		promptAlert.sendKeys("Mansoor");
		Thread.sleep(5000);
		promptAlert.accept();

//		ConfirmAlerts
        WebElement ConfirmAlertButton = driver.findElement(By.id("confirmButton"));
        ConfirmAlertButton.click();
		Alert Confirmalert = driver.switchTo().alert();
		Thread.sleep(5000);
		Confirmalert.accept();
		
		
		
	
	}

	@AfterTest
	public void afterTest() {
//	driver.close();
//	driver.quit();

	}
}
