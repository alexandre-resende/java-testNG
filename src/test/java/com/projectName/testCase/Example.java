package com.projectName.testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.projectName.util.Variables;

public class Example extends TestCase{
	
	@Test (description="TC001 Login With Success")
	public void TC001_searchOnGoogle() throws InterruptedException {
		com.projectName.pageObject.ExamplePO login = new com.projectName.pageObject.ExamplePO(driver);
		login.login();
	}
	
	//@Ignore (description="TC002 Assert Equals")
	//public void TC002_assertEquals() throws IOException {
	//	Assert.assertEquals(2, 23);
	//}
	
	@Test (description="TC003 Assert True")
	public void TC003_assertTrue() {
		Assert.assertTrue(true, "This test should be failed");
	}
	
	@Test (description="TC004 Change URL")
	public void TC004_changeUrl() {
		changeUrl(Variables.HOMEPAGE);
		System.out.println("New Page: "+getUrl());
	}

}