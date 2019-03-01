package com.qa.taskonepom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JenkinsHome {

	@FindBy(xpath = "//*[@id=\"tasks\"]/div[1]/a[2]")
	private WebElement newTask;
	
	public void click(WebDriver driver) {
		newTask.click();
		NewTask newTask = PageFactory.initElements(driver, NewTask.class);
	}
}
