package com.qa.taskonepom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JenkinsHome {

	@FindBy(xpath = "//*[@id=\"tasks\"]/div[1]/a[1]/img")
	private WebElement newTask;
	
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[4]/a[1]/img")
	WebElement manageJk;
	
	public void clickManageJenk() {
		manageJk.click();
	}
	
	public void clickNewTask(WebDriver driver) {
		newTask.click();
		NewTask newTask = PageFactory.initElements(driver, NewTask.class);
	}
}
