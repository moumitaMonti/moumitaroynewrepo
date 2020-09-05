package com.careerhack.common;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.careerhack.common.ItextlistenerPractice.class)
public class TestNGPractice extends ItextlistenerPractice{
public WebDriver driver;
@Parameters("Browserr")
@BeforeTest
public void setup(String BrowserName) {
	
if(BrowserName.equalsIgnoreCase("Chrome")) {
	
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	}
else if(BrowserName.equalsIgnoreCase("Firefox")) {
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
}
	driver.get("https://www.amazon.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
}

@Test
public void Actual() {
	System.out.println(driver.getTitle());
	List<WebElement>list=driver.findElements(By.tagName("a"));
	System.out.println(list.size());
	Actions a=new Actions(driver);
	a.sendKeys(Keys.ALT);
	
	a.sendKeys(Keys.chord(Keys.ALT,Keys.CONTROL));
}
@AfterTest
public void Closure() {
	driver.quit();
}

}
