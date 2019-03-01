package com.qa.taskonepom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Tasks {
	@FindBy(id = "job_AutomatedItem")
	private WebElement jobRow;

	private String testText = "AutomatedItem";

	public boolean findTask() {
		if(jobRow.isDisplayed()) {
			return true;
		}
		return false;
	}
}
