package seleniumpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question1 {

	public static void main(String[] args) {

		// Initialize ChromeDriver
		WebDriver driver = new ChromeDriver();

		try {
			// Maximize browser window
			driver.manage().window().maximize();

			// Navigate to the URL
			driver.get("https://jqueryui.com/datepicker/");

			WebElement iframe = driver.findElement(By.className("demo-frame"));
			driver.switchTo().frame(iframe);

			WebElement dateInput = driver.findElement(By.id("datepicker"));
			dateInput.click();

			WebElement nextButton = driver.findElement(By.className("ui-datepicker-next"));
			nextButton.click();

			WebElement dateToSelect = driver.findElement(By.xpath("//a[text()='22']"));
			dateToSelect.click();

			String selectedDate = dateInput.getAttribute("value");

			System.out.println("Selected Date: " + selectedDate);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			driver.quit();
		}
	}
}
