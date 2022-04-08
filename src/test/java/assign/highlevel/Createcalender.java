package assign.highlevel;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.highlevel.base.Baseclass;
import com.highlevel.base.Listeners;
import com.highlevel.pageobjects.Calenderspage;
import com.highlevel.pageobjects.Homepage;
import com.highlevel.pageobjects.Loginpage;
import com.highlevel.pageobjects.Settingspage;

public class Createcalender extends Baseclass {
	public WebDriver driver;
	Loginpage lPage;
	Calenderspage cPage;
	Settingspage sPage;
	Homepage hPage;
	public static String priorLocation;
	@Test(priority = 0)
	void intial() throws IOException {

		driver = setup();
		driver.get(url);
		log.info("Navigated to :" +url);
		Listeners.test.log(Status.INFO, "Navigated to :" +url);
		lPage = new Loginpage(driver);
		cPage = new Calenderspage(driver);
		hPage = new Homepage(driver);
		sPage = new Settingspage(driver);
		lPage.signin();
	}

	@Test(priority = 1)
	void createCalander() throws InterruptedException {
		hPage.clickOnSettings();
		wait.until(ExpectedConditions.elementToBeClickable(sPage.clickOnGoBack()));
		cPage.clickOnCalanders();
		cPage.clickNewCalander();
		wait.until(ExpectedConditions.visibilityOf(cPage.typeCalenderName));
		cPage.typeMeetingLocation();
        priorLocation = cPage.selectPriority();
		cPage.describeCalender();

	}

}
