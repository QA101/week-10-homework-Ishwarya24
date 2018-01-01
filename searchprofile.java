
import java.io.File;

import java.io.IOException;

import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class searchprofile {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.edge.driver", "C:\\Users\\Ishwarya\\Documents\\MicrosoftWebDriver.exe");
		WebDriver driver = null;
		try {
			driver = new EdgeDriver();

			driver.get("http://google.com");
			WebElement text = driver.findElement(By.id("lst-ib"));
			text.sendKeys("Ishwarya Manikandan Linkedin profile");

			WebElement w = driver.findElement(By.name("btnK"));
			w.submit();
			Thread.sleep(2000);
			WebElement t= driver.findElement(By.partialLinkText("Ishwarya Manikandan"));
			t.click();
			
			//driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
			if(driver !=null)
			driver.quit();
		}
	}

}