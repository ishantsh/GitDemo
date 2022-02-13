package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;

import resource.base;

public class validatetitle extends base {
	public WebDriver driver;
	LandingPage lpage;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initilizer() throws IOException {

		driver = intializeDriver();
		log.info("driver is intiliase");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to url");
	}

	@Test
	public void basePageNavigation() throws IOException {

		lpage = new LandingPage(driver);
		Assert.assertEquals(lpage.getTitle().getText(), "FEATURED COURSES");
		log.info("Successfully validated text message");

	}

	@Test
	public void validateHeader() throws IOException {

		Assert.assertEquals(lpage.getheader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("Successfully validated text message");
		System.out.println("Testing has completed");

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
