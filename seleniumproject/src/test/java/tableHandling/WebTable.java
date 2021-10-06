package tableHandling;

import java.util.LinkedList;
import java.util.List;
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

public class WebTable {
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

//		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		List<WebElement> AllElements = new LinkedList<WebElement>();
		
		AllElements =  driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		
		System.out.println(AllElements.size());
		
		for(WebElement Item : AllElements) {
			
		String name = 	Item.getText();
		System.out.println(name);
	
		}
		

	/*	
		String Xpath1 = "//*[@id=\"customers\"]/tbody/tr[";
		String Xpath2 = "]/td[";
		String Xpath3 = "]";

		for (int i = 2; i <= 7; i++) {

			for (int j = 1; j <= 3; j++) {

				String ActualXpath = Xpath1 + i + Xpath2 + j + Xpath3;

				WebElement element = driver.findElement(By.xpath(ActualXpath));
				System.out.printf(element.getText()+"      ");

			}

			System.out.println("");

		}
*/
	}

	

	@AfterTest
	public void afterTest() {
//		driver.close();
//		driver.quit();

	}
}
