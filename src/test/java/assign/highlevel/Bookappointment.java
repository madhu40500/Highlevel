package assign.highlevel;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.highlevel.base.Baseclass;
import com.highlevel.base.Listeners;
import com.highlevel.pageobjects.Bookingpage;
import com.highlevel.pageobjects.Calenderspage;
import com.highlevel.pageobjects.Homepage;
import com.highlevel.pageobjects.Loginpage;
import com.highlevel.pageobjects.Settingspage;
import com.highlevel.utilities.Constants;
import com.highlevel.utilities.Generic;

public class Bookappointment extends Baseclass {
	public WebDriver driver;
	Loginpage lPage;
	Calenderspage cPage;
	Settingspage sPage;
	Homepage hPage;
	Bookingpage bPage;
	Generic gen;
	SoftAssert sAssert= new SoftAssert();

	@Test(priority = 0)
	void intial() throws IOException {

		driver = setup();
		driver.get(url);
		log.info("Navigated to :" +url);
		Listeners.test.log(Status.INFO, "Navigated to :" +url);
		gen= new Generic(driver);
		lPage = new Loginpage(driver);
		cPage = new Calenderspage(driver);
		hPage = new Homepage(driver);
		sPage = new Settingspage(driver);
		lPage.signin();
	}

	@Test(priority = 1)
	void booking() throws InterruptedException {
		hPage.clickOnSettings();
		wait.until(ExpectedConditions.elementToBeClickable(sPage.clickOnGoBack()));
		cPage.clickOnCalanders();
		 bPage = cPage.clickOnBooking();
		 gen.switchWindow();
		 //Here i'm only booking 8'o clock slots, if it's not available it will check on next day 
		 //and it continues until the available 8'o clock slot.
		 bPage.bookSlot();
		 
		 bPage.enterInfo();
		 String meetLocation= bPage.meetingLocation();
		 String conformMessage= bPage.conformMessage();
		 sAssert.assertEquals(conformMessage, Constants.sucessMessage);
//If Both locations are same means that the slot is booked to the prioritized Doctor
		 sAssert.assertEquals(meetLocation, Createcalender.priorLocation,"Either the priortised slots are full or a defect");
		 sAssert.assertAll();
	
	}



}
