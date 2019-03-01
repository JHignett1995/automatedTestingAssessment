package com.qa.assessment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.taskonepom.JenkinsHome;
import com.qa.taskonepom.JenkinsLogin;
import com.qa.taskonepom.Tasks;
import com.qa.tasktwoconstants.Constants;
import com.qa.tasktwoconstants.CreateUser;
import com.qa.tasktwoconstants.ManageJenkins;
import com.qa.tasktwoconstants.ManageUsers;

@RunWith(Parameterized.class)
public class TaskTwoTest {

	@Parameters
	public static Collection<Object[]> data() throws IOException {
		Constants cons = new Constants();
		FileInputStream file = new FileInputStream(cons.getExcelSheet());
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		Object[][] ob = new Object[sheet.getPhysicalNumberOfRows()][4];

		// Reading
		for (int rowNum = 0; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
			ob[rowNum][0] = sheet.getRow(rowNum).getCell(0).getStringCellValue();
			ob[rowNum][1] = sheet.getRow(rowNum).getCell(1).getStringCellValue();
			ob[rowNum][2] = sheet.getRow(rowNum).getCell(2).getStringCellValue();
			ob[rowNum][3] = sheet.getRow(rowNum).getCell(3).getStringCellValue();
		}
		return Arrays.asList(ob);
	}
	
	private String username;
	private String fullname;
	private String password;
	private String email;
	
	public TaskTwoTest(String username, String fullname, String password, String email) {
		this.username = username;
		this.fullname = fullname;
		this.password = password;
		this.email = email;
	}
	WebDriver driver;
	JenkinsLogin login;
	JenkinsHome home;
	ManageJenkins manageJ;
	ManageUsers manageUser;
	CreateUser createUser;
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jordan\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://35.189.110.9:8080/login?from=%2F");
		login = PageFactory.initElements(driver, JenkinsLogin.class);
		home = PageFactory.initElements(driver, JenkinsHome.class);
		manageJ = PageFactory.initElements(driver, ManageJenkins.class);
		manageUser = PageFactory.initElements(driver, ManageUsers.class);
		createUser = PageFactory.initElements(driver, CreateUser.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@After
	public void teardown() {
		driver.close();
	}
	
	@Test
	public void addUsers() {
		login.login(driver);
		home.clickManageJenk();
		manageJ.clickUser();
		manageUser.create();
		createUser.createAUser(username,fullname,password,email);
		manageUser.check(username);
	}
	
}
