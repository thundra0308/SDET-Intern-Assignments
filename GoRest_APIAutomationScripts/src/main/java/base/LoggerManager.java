package base;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerManager {

	public Logger log = LogManager.getLogger(LoggerManager.class);
	

	public void initLogger() {
		PropertyConfigurator.configure(System.getProperty("user.dir")+"/properties/"+"log4j.properties");
	}

	public void startTestCase(String testCase) {
		log.info("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		log.info("-------------------------------------- START TEST CASE : "+testCase+"--------------------------------------");
		log.info("****************************************************************************************************************");
	}

	public void endTestCase() {
		log.info("****************************************************************************************************************");
		log.info("---------------------------------------------- ++++END TEST CASE++++ ----------------------------------------------");
		log.info("////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
	}

	public void info(String message) {
		log.info(message);
	}

	public void warn(String message) {
		log.warn(message);
	}

	public void error(String message) {
		log.error(message);
	}

	public void fatal(String message) {
		log.fatal(message);
	}

	public void debug(String message) {
		log.debug(message);
	}

	

}
