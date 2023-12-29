package base;

import java.lang.reflect.Method;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static base.LoggerManager.*;

public class BaseTest {

	@BeforeMethod
	public void startTest(Method method) {
		initLogger();
		testStep = 1;
		startTestCase(method.getName());
	}

	@AfterMethod
	public void endTest() {
		endTestCase();
	}

}
