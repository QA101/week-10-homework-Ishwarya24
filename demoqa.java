
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.io.Files;

public class demoqa {
	public static void main(String[] args) {// Launch the web browser
		WebDriver driver = null;
		try {
		final String sUrl = "http://demoqa.com/";
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Ishwarya\\Documents\\MicrosoftWebDriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.edge();
		capabilities.setPlatform(Platform.WIN10);

		  driver = new EdgeDriver();// open the web page
		//System.out.println("Test");
		driver.get(sUrl);

		// driver.navigate().to("www.gmail.com");
		// Web element
		WebElement w = driver.findElement(By.partialLinkText("Registration"));// Find the element registration
		w.click();// click on the element
		if (driver.getCurrentUrl().contains("registration")) {
			System.out.println("Hey we made it");
		}
		Thread.sleep(1000);
		// Fill first name
	 WebElement name=	driver.findElement(By.id("name_3_firstname"));
		name.sendKeys("Ishwarya"); // sendkeys to fill in text box
		WebElement lname=driver.findElement(By.id("name_3_lastname"));
		lname.sendKeys("Manikandan");
		WebElement phone=driver.findElement(By.id("phone_9"));
		phone.sendKeys("8135043094");
		WebElement uname=driver.findElement(By.id("username"));
		uname.sendKeys("Ish");
		WebElement email=driver.findElement(By.id("email_1"));
		email.sendKeys("ashovarya.kp@gmail.com");
		WebElement aboutu=driver.findElement(By.id("description"));
		aboutu.sendKeys("Hi this is Ishwarya");
		WebElement pwd=driver.findElement(By.id("password_2"));
		pwd.sendKeys("password123");
		WebElement cpwd=driver.findElement(By.id("confirm_password_password_2"));
		cpwd.sendKeys("password123");
		
		
		// Dropdown
		Select country = new Select(driver.findElement(By.id("dropdown_7")));
		country.selectByValue("United States");
		Select month = new Select(driver.findElement(By.id("mm_date_8")));
		month.selectByValue("8");
		Select day = new Select(driver.findElement(By.id("dd_date_8")));
		day.selectByValue("24");
		Select year = new Select(driver.findElement(By.id("yy_date_8")));
		year.selectByValue("1990");
		// Radio button
		List<WebElement> status = driver.findElements(By.name("radio_4[]"));

		for (WebElement e : status) {
			if (e.getAttribute("value").equals("Married")) {
				e.click();
			}
		
		}
		List<WebElement> status1 = driver.findElements(By.name("checkbox_5[]"));
		status1.get(1).click();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);// take SS
		try {
			Files.copy(scrFile, new File("C:\\Users\\Ishwarya\\Documents\\screenshot.png"));// copy file to
																							// userspecified locatio
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		driver.quit();// close all the browser that the driver has created
	}catch(Exception e) {
		e.printStackTrace();
		driver.quit();
		
	}
	}
	
}
