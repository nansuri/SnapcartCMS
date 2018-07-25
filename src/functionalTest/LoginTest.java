package functionalTest;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import element.LoginPage;
import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIResults;
import toolsAndDefine.GlobalVariable;
import toolsAndDefine.Login;
import toolsAndDefine.TestlinkBridge;

public class LoginTest {
	
	static WebDriver driver;
	TestlinkBridge TB;
	
	//TestLink Section
	public static String DEV_KEY = "bb340a3e1f178109c74437fbfaae6daf"; //Your API Key
	public static String SERVER_URL = ("http://localhost/testlinkmoka/lib/api/xmlrpc/v1/xmlrpc.php"); //your testlink server url
	public static String PROJECT_NAME = "Cashback"; 
	public static String PLAN_NAME = "Testing";
	public static String BUILD_NAME = "Demo";
	public static String result = TestLinkAPIResults.TEST_PASSED;
	
	
	@BeforeTest
	public static void setUp(){
		System.setProperty("webdriver.gecko.driver",Login.geckoDriverLoc);
		driver = new FirefoxDriver();
		driver.get(GlobalVariable.CMS_LINK_STG);
	}
		
	//@Test
	public void Snap01_InvalidLogin() throws Exception{
		driver.findElement(By.xpath(LoginPage.FIELD_USERNAME)).sendKeys(Login.USERNAME_INVALID);
		driver.findElement(By.xpath(LoginPage.FIELD_PASSWORD)).sendKeys(Login.PASSWORD_INVALID);
		Select dropdown = new Select(driver.findElement(By.xpath(LoginPage.DROPDOWN_ROLE)));
		dropdown.selectByVisibleText(Login.ROLE_ADMIN);
		driver.findElement(By.xpath(LoginPage.BUTTON_LOGIN)).click();
	}
	
	// @Test
	public void Snap02_ClickForgetPassword() throws Exception{
		driver.findElement(By.xpath(LoginPage.BUTTON_FORGET_PASSWORD)).click();
		driver.findElement(By.xpath(LoginPage.FIELD_FP_EMAIL)).sendKeys(Login.EMAIL_INVALID);
	}
	
	@Test
	public void TestTestlink() throws Exception{
		// Testlink Section
		TestLinkAPIClient testlinkAPIClient = new TestLinkAPIClient(DEV_KEY,SERVER_URL);
		testlinkAPIClient.reportTestCaseResult(PROJECT_NAME, PLAN_NAME, "CASH-1", BUILD_NAME, null, result);
	}
	
	@AfterTest
	public static void setDown() {
		driver.quit();
	}
}