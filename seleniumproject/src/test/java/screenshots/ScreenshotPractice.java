package screenshots;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotPractice {
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
	public void Screenshot() throws IOException {
//		driver.get("https://demoqa.com");

//		Screenshot of Screensize page

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("C://Users//MANSOOR...KHAN//eclipse-workspace//seleniumproject//src//test//resources//screenshots//Toolqa.jpg"));

//		Screenshot of Full Page

//		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);

//		ImageIO.write(screenshot.getImage(), "jpg", new File("C://Users//MANSOOR...KHAN//eclipse-workspace//seleniumproject//src//test//resources//screenshots//ToolqaFullPage.jpg"));
	}

	@AfterTest
	public void afterTest() {

//		driver.close();
//		driver.quit();

	}
}
