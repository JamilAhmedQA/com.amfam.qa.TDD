package reporting;

import java.util.logging.Logger;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;

public class JavaLog {

	private static final Logger LOGGER = Logger.getLogger(JavaLog.class.getName());

	public static void log(String msg) {
		LOGGER.info(msg);
		Reporter.log(msg);
		ExtentTestManger.getTest().log(Status.INFO, msg);
	}
}
