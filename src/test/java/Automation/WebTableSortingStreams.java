package Automation;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class WebTableSortingStreams {
	@Test
	public void webTableSort() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ramso\\WebDrivers\\chromedriver.exe");
		WebDriver dr=new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//click on veg/fruit name column
		dr.findElement(By.xpath("//tr/th[1]")).click();
		
		//Capture all webelements into list
		List<WebElement> elementList=dr.findElements(By.xpath("//tbody/tr/td[1]"));
		
		//capture text of all webelements into new list(original - actual result)
		List<String> originalList=elementList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//sort on the original list -> sorted list(expected result)
		List<String> sortedList=originalList.stream().sorted().collect(Collectors.toList());
		
		//compare original vs sorted list
		Assert.assertTrue(originalList.equals(sortedList));
		
		//veg column - get text "Beans" - print the price of "Beans" (its in first page visible)
		List<String> price=elementList.stream().filter(s->s.getText().contains("Beans")).
					map(s->getVegPrice(s)).collect(Collectors.toList());
		 price.forEach(s->System.out.println(s));
		//veg column - get text "Rice" - print the price of "Rice" (its in next page not visible)
		//Pagination		
		 List<String> price1;
		do
		{
			List<WebElement> elementList1=dr.findElements(By.xpath("//tbody/tr/td[1]"));
		 price1=elementList1.stream().filter(s->s.getText().contains("Rice")).
				map(s->getVegPrice(s)).collect(Collectors.toList());

		if(price1.size()<1)
		{
			dr.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
		}while(price1.size()<1);
		price1.forEach(s->System.out.println(s));

	}

	private static String getVegPrice(WebElement s) {
		// TODO Auto-generated method stub
		String priceValue=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
