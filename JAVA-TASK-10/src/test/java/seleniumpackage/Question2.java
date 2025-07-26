package seleniumpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question2 {

	public static void main(String[] args) {
		// Setup WebDriver

		WebDriver driver = new ChromeDriver();

		try {
			// 1. Open the browser and navigate
			driver.get("https://jqueryui.com/droppable/");
			driver.manage().window().maximize();

			driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));

			WebElement source = driver.findElement(By.id("draggable"));
			WebElement target = driver.findElement(By.id("droppable"));

			Actions actions = new Actions(driver);
			actions.dragAndDrop(source, target).perform();

			String dropText = target.getText();
			System.out.println("Drop Text: " + dropText);
			if (dropText.equals("Dropped!")) {
				System.out.println("Drag and Drop text verification passed.");
			} else {
				System.out.println("Drag and Drop text verification failed.");
			}

			String bgColor = target.getCssValue("background-color");
			System.out.println("Background color after drop: " + bgColor);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			driver.quit();
		}
	}
}
