package base;

import java.lang.reflect.Method;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import commons.AllActions;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ContinuePage;
import pages.GetQuatoPage;
import pages.LandingPage;
import pages.PolicyholderDetails;
import pages.ZipCodePage1;
import pages.ZipCodePage2;
import reporting.ExtentManager;
import reporting.ExtentTestManger;
import utils.ReadConfigFile;

public class BaseClass {
	public static WebDriver driver;
	private ExtentReports extent;
	protected AllActions allActions;
	protected LandingPage landingPage;
	protected ZipCodePage1 zipCodePage1;
	protected GetQuatoPage getQuatoPage;
	protected ZipCodePage2 zipCodePage2;
	protected PolicyholderDetails policyholderDetails;
	protected ContinuePage continuePage;
	
	
	@BeforeSuite
	public void reportingInitiating() {
		extent = ExtentManager.getInstance();
	}
	
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) {
		settingUpDriver(browser);
		driver.get(ReadConfigFile.getInstance().getUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ReadConfigFile.getInstance().getPageLoadTime()));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ReadConfigFile.getInstance().getImplicitlyWaitTime()));
		initClasses();
	}
	
	private WebDriver settingUpDriver(String driverName) {
		if(driverName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (driverName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if (driverName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		return driver;
	}
	
	@BeforeMethod
	public void startReport(Method method) {
		String className = method.getDeclaringClass().getSimpleName();
		ExtentTestManger.startTest(method.getName());
		ExtentTestManger.getTest().assignCategory(className);
	}
	
	@AfterMethod
	public void afterEachTestMethod(ITestResult result) {
		for(String groups : result.getMethod().getGroups()) {
			ExtentTestManger.getTest().assignCategory(groups);
		}
		
		if(result.getStatus() == ITestResult.SUCCESS) {
			ExtentTestManger.getTest().log(Status.PASS, "Test Passed");
		}else if(result.getStatus() == ITestResult.SKIP) {
			ExtentTestManger.getTest().log(Status.SKIP, "Test Skipped");
		}else if(result.getStatus() == ITestResult.FAILURE) {
			ExtentTestManger.getTest().log(Status.FAIL, "Test Failed \n" + result.getThrowable());
			String ssLocation = allActions.getScreenShot();
			ExtentTestManger.getTest().addScreenCaptureFromPath(ssLocation);
		}
	}
	
	@AfterMethod
	public void cleaningUp() {
		driver.quit();
	}
	
	@AfterSuite
	public void endReport() {
		extent.flush();
	}
	
	public void initClasses() {
		allActions = new AllActions();
		landingPage = new LandingPage(driver);
		zipCodePage1 = new ZipCodePage1(driver);
		getQuatoPage = new GetQuatoPage(driver);
		zipCodePage2 = new ZipCodePage2(driver);
		policyholderDetails = new PolicyholderDetails(driver);
		continuePage = new ContinuePage(driver);
		
	}

}
