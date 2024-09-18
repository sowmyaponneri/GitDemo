package Automation;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
public class FilterUsingStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ramso\\WebDrivers\\chromedriver.exe");
		WebDriver dr=new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		dr.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> veg=dr.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> filteredlist=veg.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
		Assert.assertEquals(veg.size(), filteredlist.size());

	}

}
