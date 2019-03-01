package com.qa.assessment;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.taskonepom.JenkinsLogin;

public class TaskOneTest {
WebDriver driver;
JenkinsLogin login;
@Before
public void setup() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jordan\\Desktop\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(login.getLandingUrl());
	login = PageFactory.initElements(driver, JenkinsLogin.class);
}
@After
public void teardown() {
	
}

}
