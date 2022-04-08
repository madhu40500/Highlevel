package com.highlevel.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.github.javafaker.Faker;
import com.highlevel.base.Baseclass;
import com.highlevel.utilities.Constants;
import com.highlevel.utilities.Generic;
import com.highlevel.utilities.Logs_Reports;

public class Calenderspage extends Baseclass {

	public WebDriver driver;
	Faker faker = new Faker();
	//Logs_Reports class is used to log the steps in file(logs/printf) and extentreports. 
	Logs_Reports logreport;

	public Calenderspage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logreport = new Logs_Reports();
	}

	@FindBy(xpath = "//span[normalize-space()='Calendars']")
	private WebElement clickOnCalanders;

	@FindBy(xpath = "(//div[@id='pg-team-cal__button--create-calendar'])[2]")
	private WebElement clickNewCalander;

	@FindBy(xpath = "//label[@class='team-member']")
	private List<WebElement> checkTeamMembers;

	@FindBy(css = "div[aria-expanded='true'] ul[class='dropdown-menu inner show'] li:nth-child(1)")
	private WebElement Selectprior;

	@FindBy(xpath="//input[@placeholder='Meeting Location']")
	private List<WebElement> meetingLocation;
	
	@FindBy(css = "input[placeholder='Add Calendar Name']")
	public WebElement typeCalenderName;

	@FindBy(css = "textarea[placeholder='Add Calendar Description']")
	private WebElement typeCalenderDescription;

	@FindBy(css = "input[placeholder='Enter Calendar Slug']")
	private WebElement typeCalenderSlug;

	@FindBy(xpath = "//button[@id='cmp-calmodal__button--save']")
	private WebElement clickOnSaveContinue;

	@FindBy(css = ".slug-unique.tick-icon")
	private WebElement verify;

	@FindBy(xpath = "(//div[@class='filter-option'])[9]")
	private WebElement slotInterval;

	@FindBy(css = "div[aria-expanded='true'] ul[class='dropdown-menu inner show'] li:nth-child(7)")
	private WebElement slotIntervalDuration;
	
	@FindBy(xpath="(//button[@class='btn btn-link btn--slug'])[2]")
	private WebElement clickOnBooking;

	public void clickOnCalanders() {
		try {
			clickOnCalanders.click();
			logreport.logs_reportsForClick(clickOnCalanders);
		} catch (Throwable t) {
			logreport.logs_reportsForClick(clickOnCalanders, t);
		}
	}

	public void clickNewCalander() {
		try {
			clickNewCalander.click();
			logreport.logs_reportsForClick(clickNewCalander);
		} catch (Throwable t) {
			logreport.logs_reportsForClick(clickNewCalander, t);
		}

	}

	public void typeMeetingLocation()
	{
		
		for(WebElement location:meetingLocation)
		{
			String city = faker.address().city();
			location.sendKeys(city);
		}
		
	}
	
	public String selectPriority() {

		String priorLocation = Generic.priority(checkTeamMembers);
		Selectprior.click();
		return priorLocation;
	}
//	public String getPriorLocation()
//	{
//		String priorLocation = Generic.priorLocation(meetingLocation);
//	}

	public void describeCalender() throws InterruptedException {
		try {
			typeCalenderName.sendKeys(Constants.name);
			logreport.logs_reportsForSendkeys(typeCalenderName, Constants.name);
		} catch (Throwable t) {
			logreport.logs_reportsForSendkeys(typeCalenderName, t);
		}
		try {
			typeCalenderDescription.sendKeys("random");
			logreport.logs_reportsForSendkeys(typeCalenderDescription, "random");
		} catch (Throwable t) {
			logreport.logs_reportsForSendkeys(typeCalenderDescription, t);
		}
		try {
			typeCalenderSlug.sendKeys(Constants.name + "504");
			logreport.logs_reportsForSendkeys(typeCalenderSlug, Constants.firstName + "504");
		} catch (Throwable t) {
			logreport.logs_reportsForSendkeys(typeCalenderSlug, t);
		}
		try {
			clickOnSaveContinue.click();
			logreport.logs_reportsForClick(clickOnSaveContinue);
		} catch (Throwable t) {
			logreport.logs_reportsForClick(clickOnSaveContinue, t);
		}

		wait.until(ExpectedConditions.visibilityOf(verify));

		clickOnSaveContinue.click();
		slotInterval.click();
		slotIntervalDuration.click();
		clickOnSaveContinue.click();
		wait.until(ExpectedConditions.elementToBeClickable(clickOnSaveContinue));

		clickOnSaveContinue.click();
	}
	
	public Bookingpage clickOnBooking()
	{
		try {
		clickOnBooking.click();
		logreport.logs_reportsForClick(clickOnBooking);
		} catch (Throwable t) {
			logreport.logs_reportsForClick(clickOnBooking, t);
		}
		return new Bookingpage(driver);
	}

}
