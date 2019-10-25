package com.projectName.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.projectName.util.Screenshots;

public class ExamplePO extends PageObject {
	
	@FindBy(xpath="//input[@name='q']")
    private WebElement search;
	
	@FindBy(name="btnK")
	private WebElement googleSearch;
			
	public void login() throws InterruptedException {
		Thread.sleep(1000);
		search.click();
		search.sendKeys("Google");
		Thread.sleep(1000);
		googleSearch.click();
		Thread.sleep(1000);
		takeScreenshot(Screenshots.SS001);

//		element.getText();
//		Assert.assertEquals(actual, expected);
	}
	
	public ExamplePO(WebDriver driver) {
		super(driver);
	}
	
}