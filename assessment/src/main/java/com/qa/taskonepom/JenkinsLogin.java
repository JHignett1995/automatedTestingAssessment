package com.qa.taskonepom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JenkinsLogin {
	private final String landingUrl = "http://35.189.110.9:8080/login?from=%2F";
	private final String user = "admin";
	private final String password = "admin";

	@FindBy(id="j_username")
	WebElement adminUser;
	
	@FindBy(xpath = "/html/body/div/div/form/div[2]/input")
	WebElement adminPass;
	
	@FindBy(xpath = "/html/body/div/div/form/div[3]/input")
	WebElement submit;

	public void login(WebDriver driver) {
		adminUser.sendKeys(user);
		adminPass.sendKeys(password);
		submit.click();
		JenkinsHome jHome = PageFactory.initElements(driver, JenkinsHome.class);
	}

	public String getLandingUrl() {
		return landingUrl;
	}
}
