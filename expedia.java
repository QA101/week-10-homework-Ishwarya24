package expe;


import java.io.File;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.http.client.utils.DateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;



import com.google.common.io.Files;



public class expedia {



	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.edge.driver","C:\\Users\\Ishwarya\\Documents\\MicrosoftWebDriver.exe");

		WebDriver driver = new EdgeDriver();		

		driver.get("http://expedia.com");
		WebElement origin = driver.findElement(By.id("package-origin-hp-package"));
		origin.sendKeys("SEA");
		origin.sendKeys(Keys.TAB);
		WebElement destination = driver.findElement(By.id("package-destination-hp-package"));
		destination.sendKeys("Mexico");
		destination.sendKeys(Keys.TAB);
		WebElement dateWidget = driver.findElement(By.id("package-departing-hp-package"));
		 DateFormat d= new SimpleDateFormat("mm/dd/yyyy");
		 Date date = new Date();

		dateWidget.sendKeys(d.format(date));
		dateWidget.sendKeys(Keys.TAB);

		List<WebElement> columns=dateWidget.findElements(By.tagName("td"));

		for (WebElement cell: columns){
		   if (cell.getText().equals("11")){
		      cell.findElement(By.linkText("11")).click();
		      break;
		   }
		}
		WebElement dateWidget1 = driver.findElement(By.id("package-returning-hp-package"));
		List<WebElement> columns1=dateWidget.findElements(By.tagName("td"));

		for (WebElement cell: columns1){
		   if (cell.getText().equals("23")){
		      cell.findElement(By.linkText("23")).click();
		      break;
		   }
		}
		WebElement search = driver.findElement(By.id("search-button-hp-package"));
		search.click();
		Thread.sleep(5000);
		driver.quit();
	
		}
	}




