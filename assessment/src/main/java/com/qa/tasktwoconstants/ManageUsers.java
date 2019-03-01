package com.qa.tasktwoconstants;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageUsers {
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[3]/a[1]/img")
	WebElement createUser;

	@FindBy(id = "people")
	WebElement table;

	public void create() {
		createUser.click();
	}
	
	public boolean check(String userName) {
		
		List<WebElement> tbody = table.findElements(By.tagName("a"));
		for(int i=0;i<tbody.size();i++) {
			if(tbody.get(i).getText().equals(userName)) {
				return true;
			}
		}
		return false;
	}
}
