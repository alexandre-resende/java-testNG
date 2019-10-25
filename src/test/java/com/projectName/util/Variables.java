package com.projectName.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.junit.runners.model.TestClass;

public class Variables {

	// Final
	public final static String HOMEPAGE = "http://www.google.com.br";

	// Variable
	public static String actualDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
	public static String newDate = new SimpleDateFormat("dd-MM-yyyy HH.mm.ss").format(Calendar.getInstance().getTime());

	public void updateDate(){
		newDate = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
	}

	public void setDate() throws IOException{
		Properties prop = new Properties();
		InputStream in = TestClass.class.getResourceAsStream("/main.properties");
		prop.load(in);

		String projectDate = prop.getProperty("project.date");
		String projectDir = prop.getProperty("project.dir");
		String projectDirSurefire = prop.getProperty("project.dir.surefire");
		String projectDirOutput = prop.getProperty("project.dir.output");
		String projectDirTestOutput = prop.getProperty("project.dir.testOutput");

		System.err.println("projectDate: "+projectDate);
		System.err.println("projectDir: "+projectDir);
		System.err.println("projectDirSurefire: "+projectDirSurefire);
		System.err.println("projectDirOutput: "+projectDirOutput);
		System.err.println("projectDirTestOutput: "+projectDirTestOutput);
	}

}
