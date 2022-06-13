package commons;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.google.common.io.Files;
import base.BaseClass;
import reporting.JavaLog;


public class AllActions {
	
	WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(20));

	public void click(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			JavaLog.log("Element is Cliking : " + element + "<br>");
		} catch (Throwable e) {
			e.printStackTrace();
			JavaLog.log("Element is unable to click: " + element + "\n" + e.getMessage() + "<br>");
			Assert.fail(); // ???????
		}
	}
	
	public void click(String idlocator) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(idlocator)));
			WebElement element = BaseClass.driver.findElement(By.id(idlocator));
			element.click();
			JavaLog.log("Element is Cliking : " + idlocator + "<br>");
		}catch (StaleElementReferenceException e) {
			e.printStackTrace();
			BaseClass.driver.findElement(By.id(idlocator)).click();
		} catch (NullPointerException | TimeoutException e) {
			e.printStackTrace();
			JavaLog.log("Element is unable to click: " + idlocator + "\n" + e.getMessage() + "<br>");
			Assert.fail(); // ???????
		}
	}

	public void inputText(WebElement element, String text) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.sendKeys(text);
			JavaLog.log(text + " : value passed to element : " + element + "<br>");
		} catch (Throwable e) {
			e.printStackTrace();
			JavaLog.log("Element is not found : " + element + "\n" + e.getMessage() + "<br>");
			Assert.fail();
		}

	}

	public void inputText(WebElement element, char text) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.sendKeys(String.valueOf(text)); // we converted here String to char
			JavaLog.log(text + " : value passed to element : " + element + "<br>");
		} catch (Throwable e) {
			e.printStackTrace();
			JavaLog.log("Element is not found : " + element + "\n" + e.getMessage() + "<br>");
			Assert.fail();
		}

	}

	public String getUrl() {
		String currentUrl = BaseClass.driver.getCurrentUrl();
		JavaLog.log("current url is " + currentUrl + "<br>");
		return currentUrl;
	}

	public void selectByValue(WebElement element, String value) {
		try {
			sleep(0.5);
			Select select = new Select(element);
			select.selectByValue(value);
			JavaLog.log(value + "value has been selected from the element : " + element + "<br>");
		} catch (Throwable e) {
			e.printStackTrace();
			JavaLog.log("locator doesn't match " + element + "\n" + e.getMessage() + "<br>");
			Assert.fail();
		}
	}

	public boolean isSelected(WebElement element) {
		boolean status = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			status = element.isSelected();
			if (status) {
				JavaLog.log(element + " : is selected" + "<br>");
			} else {
				JavaLog.log(element + " : is Not selected" + "<br>");
			}
		} catch (Throwable e) {
			e.printStackTrace();
			JavaLog.log("Element Not Found : " + element + "\n" + e.getMessage() + "<br>");
			Assert.fail();
		}
		return status;
	}

	public void sleep(double seconds) {
		try {
			Thread.sleep((long) (seconds * 1000));
			JavaLog.log("Sleeping for : " + seconds + " seconds zZzz.." + "<br>");
		} catch (Throwable e) {
			e.printStackTrace();
			JavaLog.log("Sleeping interuppted" + "<br>");
		}
	}

	public boolean isPresent(By by) {
		boolean status = false;
		try {
			List<WebElement> elements = BaseClass.driver.findElements(by);
			if (elements.size() > 0) {
				status = true;
				JavaLog.log(by + " : Element is present " + "<br>");
			} else {
				JavaLog.log(by + " : Element is not present " + "<br>");
			}
		} catch (Throwable e) {
			e.printStackTrace();
			JavaLog.log("element is not found : " + by + "\n" + e.getMessage() + "<br>");
		}
		return status;
	}

	public void logEvent(String eventMsg) {
		JavaLog.log(eventMsg + "<br>");
	}

	public void logEventAndFail(String eventMsg) {
		JavaLog.log(eventMsg + "<br>");
		Assert.fail();
	}
	
	public String getScreenShot() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy_hh.mm.ss");
		String suffix = dateFormat.format(date);
		File file = new File("screenShots/error_"+suffix+".png");
		String fileLocation = file.getAbsolutePath();
		TakesScreenshot ss = ((TakesScreenshot)BaseClass.driver);
		File srcFile = ss.getScreenshotAs(OutputType.FILE);
		try {
		Files.copy(srcFile, file.getAbsoluteFile());
			JavaLog.log("Test Failed & Sceenshot taken in location : "+ fileLocation );
		}catch (IOException e) {
			JavaLog.log("Error while taking screen shot");
		}
		return fileLocation;
	}

}
