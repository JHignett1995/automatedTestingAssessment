package com.qa.assessment;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.taskonepom.BackToDashboard;
import com.qa.taskonepom.JenkinsHome;
import com.qa.taskonepom.JenkinsLogin;
import com.qa.taskonepom.NewTask;
import com.qa.taskonepom.TaskCreation;
import com.qa.taskonepom.Tasks;

public class TaskOneTest {
	WebDriver driver;
	JenkinsLogin login;
	JenkinsHome jhome;
	NewTask newTask;
	TaskCreation createTask;
	BackToDashboard backToDash;
	Tasks tasks;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jordan\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://35.189.110.9:8080/login?from=%2F");
		login = PageFactory.initElements(driver, JenkinsLogin.class);
		jhome = PageFactory.initElements(driver, JenkinsHome.class);
		newTask = PageFactory.initElements(driver, NewTask.class);
		createTask = PageFactory.initElements(driver, TaskCreation.class);
		backToDash= PageFactory.initElements(driver, BackToDashboard.class);
		tasks = PageFactory.initElements(driver, Tasks.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void teardown() {
		driver.close();
	}

	@Test
	public void taskOne() {
		login.login(driver);
		jhome.clickNewTask(driver);
		newTask.action(driver);
		createTask.select(driver);
		backToDash.select(driver);
		assertTrue("Task was not found", tasks.findTask());
	}

}
