package com.qa.taskonepom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewTask {
	private String taskNameStr = "AutomatedItem";
	
	@FindBy(id="name")
	WebElement taskName;
	
	@FindBy(xpath = "//*[@id=\"j-add-item-type-standalone-projects\"]/ul/li[1]")
	WebElement freeStyle;

	@FindBy(id="ok-button")
	WebElement okButton;
	
	public void action(WebDriver driver) {
		taskName.sendKeys(taskNameStr);
		freeStyle.click();
		okButton.click();
		TaskCreation newTask = PageFactory.initElements(driver, TaskCreation.class);
	}
}
