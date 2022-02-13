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

public class validateNavBar extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initilizer() throws IOException {
		
		driver = intializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void basePageNavigation() throws IOException {

		

		LandingPage lpage = new LandingPage(driver);
		//Assert.assertEquals(lpage.getTitle().getText(), "Featured Courses");
		Assert.assertTrue(lpage.getNavBar().isDisplayed());
		log.info("Navigation is successful");
		
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	


	}


