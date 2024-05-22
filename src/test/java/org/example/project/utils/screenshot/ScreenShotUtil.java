package org.example.project.utils.screenshot;

import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.example.project.configurations.driverfactory.DriverFactory;
import org.example.project.configurations.logs.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.example.project.configurations.properties.PropertyConfigurator.getProperty;
public class ScreenShotUtil {
    public static void takeScreenShot(Scenario scenario) {
        TakesScreenshot scrShot = ((TakesScreenshot) DriverFactory.getDriver());
        byte[] srcFile = scrShot.getScreenshotAs(OutputType.BYTES);
        scenario.attach(srcFile, "image/png", "SCREENSHOT");
        try {
            FileUtils.writeByteArrayToFile(new File(
                    getProperty("PATH.TO.SCREENSHOTS.FOLDER")
                            + new SimpleDateFormat(getProperty("DATE.FORMAT")
                            + " "
                            + scenario.getName()
                            + getProperty("FORMAT.OF.SCREENSHOT")).format(new Date())), srcFile);
        } catch (IOException e) {
            Log.info("Failed to save screenshot as .png file");
        }
    }
}
