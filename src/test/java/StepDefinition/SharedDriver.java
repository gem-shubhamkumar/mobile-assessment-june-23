package StepDefinition;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class SharedDriver {
    private static AndroidDriver driver;
    public static AndroidDriver getDriver(DesiredCapabilities desiredCapabilities, URL remoteUrl){
        try {
            if (driver == null) {

                driver = new AndroidDriver(remoteUrl, desiredCapabilities);

            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return driver;

    }
}
