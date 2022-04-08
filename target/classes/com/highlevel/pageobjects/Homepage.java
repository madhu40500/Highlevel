package com.highlevel.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	
	
public WebDriver driver;
	
	public Homepage(WebDriver driver) {
this.driver= driver;
PageFactory.initElements(driver, this);
	}
	
 @FindBy(xpath="//span[normalize-space()='Settings']")
 private WebElement clickOnSettings;

public  void clickOnSettings()
{
	clickOnSettings.click();
}

}
