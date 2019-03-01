package com.qa.tasktwoconstants;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUser {
	@FindBy(id = "username")
	WebElement userName;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[2]/td[2]/input")
	WebElement passWord;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[3]/td[2]/input")
	WebElement passConfirm;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[4]/td[2]/input")
	WebElement fullName;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[5]/td[2]/input")
	WebElement emailIn;
	
	@FindBy(id = "yui-gen1-button")
	WebElement submit;
	
	public void createAUser(String username, String fullname, String password, String email) {
		userName.sendKeys(username);
		passWord.sendKeys(password);
		passConfirm.sendKeys(password);
		emailIn.sendKeys(email);
		submit.click();
		
	}
}

