package com.highlevel.utilities;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Generic {

	public WebDriver driver;

	public Generic(WebDriver driver) {
		this.driver = driver;
	}

	public static void clickAll(List<WebElement> element) {
		element.stream().forEach(s -> s.click());
	}

	public static String priority(List<WebElement> element) {
	

		List<String> priorLocation = element.stream().filter(s -> s.getText().contains(Constants.priorityDoctor))
				.map(s -> getElement(s)).collect(Collectors.toList());
		element.stream().filter(s -> s.getText().contains(Constants.priorityDoctor)).map(s -> clickOnElement(s))
				.forEach(s -> s.click());
		return priorLocation.get(0);
	}
	
	static WebElement clickOnElement(WebElement s) {
		return s.findElement(By.xpath("following-sibling::div//button[@title='Low Priority']"));
	}
	
//	public static String priorLocation(List<WebElement> element)
//	{
//	}


	static String getElement(WebElement s) {
		return s.findElement(By.xpath("following-sibling::div//input[@placeholder='Meeting Location']")).getAttribute("placeholder");
	}

	public void switchWindow() {
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
	}

}
