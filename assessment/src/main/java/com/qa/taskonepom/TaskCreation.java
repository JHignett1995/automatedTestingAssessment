package com.qa.taskonepom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskCreation {
	@FindBy(id = "yui-gen38-button")
	private WebElement saveButton;

	public void select(WebDriver driver) {
		saveButton.click();
		BackToDashboard newTask = PageFactory.initElements(driver, BackToDashboard.class);
	}
}
