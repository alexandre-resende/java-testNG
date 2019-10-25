package com.projectName.pageObject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectName.util.Screenshots;
import com.projectName.util.Variables;

public class PageObject {

	protected WebDriver driver;
	
	private final String urlScreenshot = System.getProperty("user.dir") +"/target/"+ Variables.actualDate +"/screenshots";

    /**
     * Init WebDriver
     * @param driver
     */
	public PageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
//	public static String getCallingMethod() {
//	    StackTraceElement[] stack = new Throwable().getStackTrace();
//	    StackTraceElement ste = null;
//	    if (stack.length > 1) 
//	        ste = stack[1];
//	    return ste == null ? "[Unavailable]" : ste.getMethodName();
//	}
	
	/**
	 * Take screenshot when requested
	 */
	public void takeScreenshot(Screenshots ssName) {
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
//			File destFile = new File(urlScreenshot +"/success/"+ super.getClass().getSimpleName() +"/"+ this.getClass().getSimpleName() +"/"+ ssName +".png");
			File destFile = new File(urlScreenshot +"/success/"+ getClass().getSimpleName() +"/" +ssName +".png");
//			System.err.println("Taking screenshot success to: "+ destFile);
			FileUtils.copyFile(scrFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
//			System.err.println(e);
		}
	}

}