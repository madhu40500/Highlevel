package com.highlevel.pageobjects;

import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.highlevel.base.Baseclass;
import com.highlevel.utilities.Generic;

public class Settingspage extends Baseclass{
	public WebDriver driver;

	public Settingspage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='My Staff']")
	private WebElement clickOnMyStaff;
	
	@FindBy(xpath = "(//div[@id='backButtonv2'])[1]")
	private WebElement clickOnGoBack;
	
	@FindBy(xpath = "//button[normalize-space()='Add Employee']")
	private WebElement clickOnAddEmploy;

	@FindBy(xpath = "//span[normalize-space()='User Info']")
	private WebElement clickOnUserInfo;

	@FindBy(css = "input[placeholder='First Name']")
	private WebElement typeFirstName;
	
	@FindBy(css = "input[placeholder='Last Name']")
	private WebElement typeLastName;

	@FindBy(css = "input[placeholder='Email']")
	private WebElement typeEmail;

	@FindBy(css = "input[placeholder='Password']")
	private WebElement typePassword;

	@FindBy(xpath = "(//button[contains(@type,'button')][normalize-space()='Save'])[2]")
	private WebElement clickOnSave;

	@FindBy(xpath = "//span[normalize-space()='Teams']")
	private WebElement clickOnTeam;

	@FindBy(xpath = "//button[normalize-space()='Add Team']")
	private WebElement clickOnAddTeam;

	@FindBy(xpath = "//button[contains(@data-target,'#collapse-team-info')]")
	private WebElement clickOnTeamInfo;

	@FindBy(css = "input[placeholder='Add Team Name']")
	private WebElement typeTeamName;
//List of checkboxes
	@FindBy(xpath = "//input[@type='checkbox']")
	private List<WebElement> checkBoxes;

	@FindBy(xpath = "//span[normalize-space()='Calendar Team Configuration']")
	private WebElement clickOnTeamConfig;

	@FindBy(css = "input[placeholder='Add Name']")
	private WebElement typeName;

	@FindBy(css = "textarea[placeholder='Add Description']")
	private WebElement typeDescription;

	@FindBy(css = "input[placeholder='Enter Unique Slug']")
	private WebElement typeUniqueSlug;

	@FindBy(xpath = "(//button[@type='button'][normalize-space()='Save'])[2]")
	private WebElement clickOnTeamSave;

	public void clickOnMyStaff() {
		clickOnMyStaff.click();
	}
public WebElement clickOnGoBack()
{
	return clickOnGoBack;
}
	public void addEmployee() {
		clickOnAddEmploy.click();
		clickOnUserInfo.click();
		typeFirstName.sendKeys("madhu");
		typeLastName.sendKeys("Doctor1");
		typeEmail.sendKeys("asdf@gmail.com");
		typePassword.sendKeys("Madhu@121");
		clickOnSave.click();
	}

	public void clickOnTeam() {
		clickOnTeam.click();
	}

	public void createTeam() {
		clickOnAddTeam.click();
		clickOnTeamInfo.click();
		typeTeamName.sendKeys("Random23");
		Generic.clickAll(checkBoxes);
		clickOnTeamConfig.click();
		typeName.sendKeys("name");
		typeDescription.sendKeys("masghdfjahllljsg");
		typeUniqueSlug.sendKeys("masdhu45");
		clickOnTeamSave.click();

	}

}
