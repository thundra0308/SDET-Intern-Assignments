package base;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerManager {

	public static Logger log = LogManager.getLogger(LoggerManager.class);
	public static int testStep;

	public static void initLogger() {
		PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/main/resources/log4j.properties");
	}

	public static void startTestCase(String testCase) {
		log.info("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		log.info("-------------------------------------- START TEST CASE : "+testCase+"--------------------------------------");
	}

	public static void endTestCase() {
		log.info("---------------------------------------------- END TEST CASE ----------------------------------------------");
		log.info("////////////////////////////");
	}

	public static void info(String message) {
		log.info(message);
	}

	public static void warn(String message) {
		log.warn(message);
	}

	public static void error(String message) {
		log.error(message);
	}

	public static void fatal(String message) {
		log.fatal(message);
	}

	public static void debug(String message) {
		log.debug(message);
	}
	
}
