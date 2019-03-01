package com.qa.tasktwoconstants;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageJenkins {
@FindBy(xpath = "//*[@id=\"main-panel\"]/div[16]/a/img")
WebElement manageUsers;

public void clickUser() {
	manageUsers.click();
}
}
