package users;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class uiPanelTest {
	@Test
	public void postSomething() {
		System.out.println("Something");
	}

	@Test
	public void ui() throws InterruptedException {
		// TODO Auto-generated method stub

		// Create a driver object
		System.setProperty("webdriver.chrome.driver", "node_modules/chromedriver/bin/chromedriver");
		WebDriver driver = new ChromeDriver();

		// WebDriverWait wait = new WebDriverWait(webDriver, timeoutInSeconds);
		WebDriverWait wait = new WebDriverWait(driver, 300);

		// Open the web page
		driver.get("https://stage-admin.tfg.cloud/login");
		// wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

		// Login as Super admin
		driver.findElement(By.id("username")).sendKeys("pjo@futureuniverse.com");
		driver.findElement(By.id("password")).sendKeys("DJDAaTlVchc0I4l5yQ9MnA==");
		driver.findElement(By.id("login-button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/user/']//div[@class='block']")));
		driver.findElement(By.xpath("//a[@href='/user/']//div[@class='block']")).click();

		// Create new user with limited access
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[(text()='Add user')]")));
		driver.findElement(By.xpath("//*[(text()='Add user')]")).click();
		driver.findElement(By.id("firstName")).sendKeys("XXXxxx");
		driver.findElement(By.id("lastName")).sendKeys("YYYyyy");
		driver.findElement(By.id("email")).sendKeys("abcd@cba.com");
		driver.findElement(By.id("phone")).sendKeys("+7654321");
		driver.findElement(By.id("country")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Norway')]")).click();

		// Grant only some access
		driver.findElement(By.id("accordion-title-Broadcast")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Admin']")));
		driver.findElement(By.id("permission-option-Broadcast-Admin")).click();

		// Click Cancel
		driver.findElement(By.id("cancel-button")).click();
		driver.findElement(By.id("discard-modal-confirm-button")).click();
		driver.findElement(By.xpath("//a[(text()='Users')]"));

		Thread.sleep(2000);
		// Click on the user
		driver.findElement(By.xpath(
				"//tr[@id='row-4466cc85-c3ea-4272-abd8-c9472828519d']//td[@style='width: auto; text-align: right;']//div[@class='gap-table-cell-value']//button[@class='ui blue basic icon button']"))
				.click();

		// Click edit profile details
		driver.findElement(By.id("firstName")).sendKeys("XXXxxx");
		driver.findElement(By.id("lastName")).sendKeys("YYYyyy");
		if (driver.findElement(By.id("email")).isEnabled())
			System.out.println("Email is enabled to edit");
		driver.findElement(By.id("phone")).sendKeys("+12345");
		driver.findElement(By.id("country")).click();
		driver.findElement(By.xpath("//span[contains(text(),'United Arab Emirates')]")).click();

		// Edit name, country and type of access
		driver.findElement(By.xpath("//*[contains(text(), 'Broadcast Dashboard')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Admin']")));
		driver.findElement(By.xpath("//*[text()='Admin']")).click();

		driver.findElement(By.xpath("//*[contains(text(), 'Studio Dashboard')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("permission-option-Studio-Admin")));
		driver.findElement(By.id("permission-option-Studio-Admin")).click();

		driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div[1]/div/a[1]")).click();
		driver.findElement(By.id("discard-modal-confirm-button")).click();

		driver.findElement(By.xpath("//*[@id=\"sidebar\"]/img")).click();
		Thread.sleep(2000);

		// Click Settings
		driver.findElement(By.className("settings")).click();
		Thread.sleep(2000);
		// Change language
		driver.findElement(By.xpath("//*[@id=\'app\']/div/div[2]/div/div/div[1]/div/div/form/div[2]/div")).click();
		// Revisit Settings
		Thread.sleep(3000);

		/*
		 * //Check if language is correct S
		 */
		driver.findElement(By.className("settings")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'app\']/div/div[2]/div/div/div[1]/div/div/form/div[1]/div")).click();

	}
}
