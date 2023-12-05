package base;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerManager {

	public Logger log = LogManager.getLogger(LoggerManager.class);
	public static Properties prop;

	public void initLogger() {
		PropertyConfigurator.configure(System.getProperty("user.dir")+"/properties/"+"log4j.properties");
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/utils/GlobalVariables.properties");
			prop.load(file);
		} catch (Exception e) {
			error(e.getMessage());
		}
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

	public void setProperty(String key, String value) {
		prop.setProperty(key, value);
		try (FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "/src/main/java/utils/GlobalVariables.properties")) {
            prop.store(fos, "Global Variables");
        } catch (IOException e) {
            error(e.getMessage());
        }
	}

}
