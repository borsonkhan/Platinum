package base;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listener.EliteListener.class)
public class TestBase extends SauceLabs {

	@BeforeSuite
	public void setUp() {

		if (Boolean.valueOf(getProperty("saucelabes"))) {
			// run test in saucelabs
			setSauceLabs();

		} else {

			// run test locally
			setDriver();
		}

	}

	@Test
	public void test() {

		String title = driver.getTitle();
		Assert.assertEquals(title, "Job Search, Employment and Careers | EliteCareer");
	}

	@AfterSuite
	public void tearDown() {

		driver.quit();
	}

}
