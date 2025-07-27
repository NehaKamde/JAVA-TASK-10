package seleniumpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Question3 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();

			// 1. Launch GUVI website
			driver.get("https://www.guvi.in/");

			// 2. Click on Signup
			WebElement signupButton = driver.findElement(By.linkText("Sign up"));
			signupButton.click();

			Thread.sleep(5000);

			// 3. Fill the signup form
			WebElement fullName = driver.findElement(By.id("name"));
			WebElement email = driver.findElement(By.id("email"));
			WebElement password = driver.findElement(By.id("password"));
			WebElement mobile = driver.findElement(By.id("mobileNumber"));

			// Dummy user info
			String dummyName = "Test User1";
			String dummyEmail = "testuser" + System.currentTimeMillis() + "@mailinator.com";
			String dummyPassword = "Test@1234";
			String dummyMobile = "1234567855";

			fullName.sendKeys(dummyName);
			email.sendKeys(dummyEmail);
			password.sendKeys(dummyPassword);
			mobile.sendKeys(dummyMobile);

			// 4. Click Signup button
			WebElement signupFormBtn = driver.findElement(By.id("signup-btn"));
			signupFormBtn.click();

			// 5. Wait and check if registration is successful
			Thread.sleep(5000);

			String expectedTitleAfterSignUp = "GUVI | Sign Up";
			String expectedTitleAfterLoginIn = "GUVI | Login";
			String titleAfterSignup = driver.getTitle();
			System.out.println("Page title after signup: " + titleAfterSignup);

			if (titleAfterSignup.equals(expectedTitleAfterSignUp)) {
				System.out.println("Signup successful!");
			} else {
				System.out.println("Signup may have failed.");
			}

			// 6. Logout if needed to test login (skip this if auto-logout)

			driver.get("https://www.guvi.in/"); // Go back to homepage

			// 7. Click on Login
			WebElement loginButton = driver.findElement(By.linkText("Login"));
			loginButton.click();

			// 8. Fill login form
			WebElement loginEmail = driver.findElement(By.id("email"));
			WebElement loginPassword = driver.findElement(By.id("password"));

			loginEmail.sendKeys(dummyEmail);
			loginPassword.sendKeys(dummyPassword);

			// 9. Click Login
			WebElement loginSubmitBtn = driver.findElement(By.id("login-btn"));
			loginSubmitBtn.click();

			// 10. Wait and verify login success
			Thread.sleep(5000);
			String titleAfterLogin = driver.getTitle();
			System.out.println("Page title after login: " + titleAfterLogin);

			if (titleAfterLogin.equals(expectedTitleAfterLoginIn)) {
				System.out.println("Login successful!");
			} else {
				System.out.println("Login failed.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 11. Close browser
			driver.quit();
		}
	}
}
