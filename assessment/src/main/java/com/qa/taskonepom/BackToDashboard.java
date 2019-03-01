package com.qa.taskonepom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BackToDashboard {
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[1]/a[2]")
	private WebElement backToDash;

	public void select(WebDriver driver) {
		backToDash.click();
		Tasks newTask = PageFactory.initElements(driver, Tasks.class);
	}
}
