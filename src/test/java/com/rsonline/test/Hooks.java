package com.rsonline.test;

import java.io.File;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks {

    private static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.NANOSECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {
        try {
            // capture and add screenshot to report if scenario is failed
            if (scenario.isFailed()) {
                String filename = UUID.randomUUID().toString();
                File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scr, new File("./target/img/" + filename + ".png"));

            }
        } finally {
            driver.quit();
        }
    }

    /**
     * Get driver instance
     *
     * @return WebDriver
     */
    public static WebDriver getDriver() {
        return driver;
    }
}
