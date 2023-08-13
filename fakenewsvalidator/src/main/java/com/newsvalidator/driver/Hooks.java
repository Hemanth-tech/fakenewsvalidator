package com.newsvalidator.driver;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	String browser = System.getProperty("browser", "chrome");
	private static final Logger logger = LogManager.getLogger(Hooks.class);

	@Before
	public void setup() throws IOException {
		/*
		 * To Setup Driver
		 */
		logger.info("Launching browser " + browser);
		TestDriver.setUpDriver(browser);

	}

	@After
	public void teardown() throws FileNotFoundException {
		// To close the existing browser sessions
		TestDriver.tearDown();
		logger.info("End of the scenario");

	}
}
