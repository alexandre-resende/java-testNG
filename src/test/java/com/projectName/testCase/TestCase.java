package com.projectName.testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.projectName.util.Variables;

public class TestCase extends TestListenerAdapter {

	protected static WebDriver driver;
	public static String suiteName;
	public static String testCaseName;
	private final String urlScreenshot = System.getProperty("user.dir") +"/target/"+ Variables.actualDate +"/screenshots";

	/**
	 * Launch browser one time for all test on this test case.
	 * @throws InterruptedException
	 */
	@BeforeTest
	public void setUp() throws InterruptedException {
		System.out.println("\n===============================================\n");
		// 		System.out.println("Launching chrome browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // DEFAULT 10
		driver.manage().deleteAllCookies();
	}

	/**
	 * Close browser after execute all test cases on suite.
	 */
	@AfterTest
	public void tearDown() {
		// 		if(driver!=null) {
		// 			System.out.println("\nClosing chrome browser");
		System.out.println("\n===============================================\n");
		driver.quit(); // driver.close();
		// 		}
	}

	/**
	 * Get Suite name
	 */
	@BeforeClass
	public void getSuiteName() {
		suiteName = this.getClass().getSimpleName();
		System.out.println("\n"+suiteName);
	}

	/**
	 * Get Test Case names
	 */
	@BeforeMethod
	public void getTestCaseName(Method method, Object[] testData, ITestContext ctx) {
		testCaseName = method.getName();
		System.out.println("✔ "+testCaseName);
	}

	/**
	 * Go to homepage
	 */
	@BeforeMethod
	public void goToHome() {
		changeUrl(Variables.HOMEPAGE);
	}

	/**
	 * Get current URL
	 */
	public String getUrl() {
		return driver.getCurrentUrl();
	}

	/**
	 * Change URL to param page
	 * @param newPage
	 */
	public void changeUrl(String newPage) {
		driver.get(newPage);
	}

	/**
	 * Take screenshot evidence if test case fail
	 */
	@AfterMethod
	public void takeScreenshotOnFailure(ITestResult result, Method method) {
		if(!result.isSuccess()){
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				File destFile = new File(urlScreenshot +"/failure/"+ getClass().getSimpleName() +"/"+ testCaseName +".png");
				FileUtils.copyFile(scrFile, destFile);
//				System.err.println("Taking screenshot failure to: "+ destFile);
				Reporter.log("<a href='"+ destFile.getAbsolutePath() + "'> <img src='"+ destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
			} catch (IOException e) {
				e.printStackTrace();
//				System.err.println(e);
			}
		}
	}

}
