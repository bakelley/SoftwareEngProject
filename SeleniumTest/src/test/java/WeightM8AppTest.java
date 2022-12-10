import static org.junit.jupiter.api.Assertions.*;

import java.awt.RenderingHints.Key;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

/*
 * Screen capture 
 * video -> https://use.vg/CIHnhl
 */

class WeightM8AppTest {
	WebDriver driver;
	 final String URL =  "http://34.229.76.26:8080/WeightM8/";
	 final String DRIVER_PATH="C:\\Users\\dejan\\OneDrive - University of Nebraska at Omaha\\school\\CSCI-4830_INTRODUCTN_SOFTWARE_ENGINEERNG\\week12- Auotmated Test\\chromiumDriver\\"
				+ "107.0.5304.62\\chromedriver.exe";
	

	@Test
	@DisplayName("Post Workout 1")
	void _01_postWorkout() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				DRIVER_PATH);
		driver = new ChromeDriver();
		driver.get(URL);
		
		WebElement postWorkoutButton = new WebDriverWait(driver, 10)
				.until(  ExpectedConditions.elementToBeClickable( By.xpath("//button[contains(@id,'post')]")   ));
		
		postWorkoutButton.click();
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("testUser");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("4025314022");
		driver.findElement(By.xpath("//input[@id='zip']")).sendKeys("68199");
		driver.findElement(By.xpath("//select[@id='Gym']")).sendKeys("Anytime");
		WebElement activity= driver.findElement(By.xpath("//select[@id='MuscleGroup']"));
		activity.sendKeys("Yoga");
		activity.sendKeys(Keys.TAB, "01022023", Keys.TAB,	"0700A");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='submit']")).click();
		String bodyTest= driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue( bodyTest.contains("Activity Posted!")  );
		driver.close();
	}
	
	@Test
	@DisplayName("Find Workout1")
	void _02_findWorkout() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",DRIVER_PATH				);
		driver = new ChromeDriver();
		driver.get(URL);
		
		WebElement findWorkout = new WebDriverWait(driver, 10)
				.until(  ExpectedConditions.elementToBeClickable( By.xpath("//button[@id='findWorkout']")   ));
		
		findWorkout.click();
		

		driver.findElement(By.xpath("//select[@id='Gym']")).sendKeys("Anytime");
		WebElement activity= driver.findElement(By.xpath("//select[@id='Activity']"));
		activity.sendKeys("Yoga");
		activity.sendKeys(Keys.TAB, "01022023", Keys.TAB,	"0700A");

		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[contains(@value,'Search')]")).click();
		String bodyTest= driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue( bodyTest.contains("testUser") && bodyTest.contains("4025314022") &&
				bodyTest.contains("Anytime Fitness") && bodyTest.contains("2023-01-02") &&
				bodyTest.contains("07:00") && bodyTest.contains("Yoga")  );
		driver.close();
	}
	
	
	@Test
	@DisplayName("Post Workout 2")
	void _03_postWorkout() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				DRIVER_PATH);
		driver = new ChromeDriver();
		driver.get(URL);
		
		WebElement postWorkoutButton = new WebDriverWait(driver, 10)
				.until(  ExpectedConditions.elementToBeClickable( By.xpath("//button[contains(@id,'post')]")   ));
		
		postWorkoutButton.click();
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("testUser2");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("4025314023");
		driver.findElement(By.xpath("//input[@id='zip']")).sendKeys("68199");
		driver.findElement(By.xpath("//select[@id='Gym']")).sendKeys("YMCA");
		WebElement activity= driver.findElement(By.xpath("//select[@id='MuscleGroup']"));
		activity.sendKeys("Legs");
		activity.sendKeys(Keys.TAB, "01032023", Keys.TAB,	"0800A");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='submit']")).click();
		String bodyTest= driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue( bodyTest.contains("Activity Posted!")  );
		driver.close();
	}
	
	@Test
	@DisplayName("Find Workout 2")
	void _04_findWorkout() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",DRIVER_PATH				);
		driver = new ChromeDriver();
		driver.get(URL);
		
		WebElement findWorkout = new WebDriverWait(driver, 10)
				.until(  ExpectedConditions.elementToBeClickable( By.xpath("//button[@id='findWorkout']")   ));
		
		findWorkout.click();
		

		driver.findElement(By.xpath("//select[@id='Gym']")).sendKeys("YMCA");
		WebElement activity= driver.findElement(By.xpath("//select[@id='Activity']"));
		activity.sendKeys("Legs");
		activity.sendKeys(Keys.TAB, "01032023", Keys.TAB,	"0800A");

		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[contains(@value,'Search')]")).click();
		String bodyTest= driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue( bodyTest.contains("testUser2") && bodyTest.contains("4025314023") &&
				bodyTest.contains("YMCA") && bodyTest.contains("2023-01-03") &&
				bodyTest.contains("08:00") && bodyTest.contains("Legs")  );
		driver.close();
	}
	
	@Test
	@DisplayName("Post Workout 3")
	void _05_postWorkout() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				DRIVER_PATH);
		driver = new ChromeDriver();
		driver.get(URL);
		
		WebElement postWorkoutButton = new WebDriverWait(driver, 10)
				.until(  ExpectedConditions.elementToBeClickable( By.xpath("//button[contains(@id,'post')]")   ));
		
		postWorkoutButton.click();
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("testUser3");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("4025314025");
		driver.findElement(By.xpath("//input[@id='zip']")).sendKeys("68199");
		driver.findElement(By.xpath("//select[@id='Gym']")).sendKeys("24 Hour Fitness");
		WebElement activity= driver.findElement(By.xpath("//select[@id='MuscleGroup']"));
		activity.sendKeys("Yoga");
		activity.sendKeys(Keys.TAB, "01042023", Keys.TAB,	"0700A");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='submit']")).click();
		String bodyTest= driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue( bodyTest.contains("Activity Posted!")  );
		driver.close();
	}
	
	@Test
	@DisplayName("Find Workout 3")
	void _06_findWorkout() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",DRIVER_PATH				);
		driver = new ChromeDriver();
		driver.get(URL);
		
		WebElement findWorkout = new WebDriverWait(driver, 10)
				.until(  ExpectedConditions.elementToBeClickable( By.xpath("//button[@id='findWorkout']")   ));
		
		findWorkout.click();
		

		driver.findElement(By.xpath("//select[@id='Gym']")).sendKeys("24 Hour Fitness");
		WebElement activity= driver.findElement(By.xpath("//select[@id='Activity']"));
		activity.sendKeys("Yoga");
		activity.sendKeys(Keys.TAB, "01042023", Keys.TAB,	"0700A");

		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[contains(@value,'Search')]")).click();
		String bodyTest= driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue( bodyTest.contains("testUser3") && bodyTest.contains("4025314025") &&
				bodyTest.contains("24 Hour Fitness") && bodyTest.contains("2023-01-04") &&
				bodyTest.contains("07:00") && bodyTest.contains("Yoga")  );
		driver.close();
	}
	
	
	
	
}
