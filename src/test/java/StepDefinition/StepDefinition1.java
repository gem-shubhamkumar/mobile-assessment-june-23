package StepDefinition;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class StepDefinition1 {
    AndroidDriver driver;
    @Given("Android Driver Launch and App Launch")
    public void androidDriverLaunch() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:devicename", "Android Emulator");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:app", "C:\\Users\\ayush.saxena\\Downloads\\ColorNote+Notepad.apk");


        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        System.out.println("App started");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Then("Accept the permissions and do stuff")
    public void acceptThePermissions() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click();
        driver.findElement(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/btn_start_skip")).click();

        //Edit the Title and Make Note
        for(int i = 0; i < 3; i++){
            driver.findElement(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/main_btn1")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Text']")).click();
            driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='com.socialnmobile.dictapps.notepad.color.note:id/edit_title']")).sendKeys("Title "+i);
            driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='com.socialnmobile.dictapps.notepad.color.note:id/edit_note']")).sendKeys("Ayush");
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
        }

        //Color Change with longPress
        //title2
        LongPressOptions longPressOptions2 = new LongPressOptions();
        WebElement AndroidElement2 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Title 2']"));
        AndroidTouchAction action2 = new AndroidTouchAction(driver);
        longPressOptions2.withDuration(Duration.ofSeconds(5)).withElement(ElementOption.element(AndroidElement2));
        action2.longPress(longPressOptions2).release().perform();

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Color']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.socialnmobile.dictapps.notepad.color.note:id/txt1']")).click();
        System.out.println(driver.findElement(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/date")));

        //title1
        LongPressOptions longPressOptions1 = new LongPressOptions();
        WebElement AndroidElement1 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Title 1']"));
        AndroidTouchAction action1 = new AndroidTouchAction(driver);
        longPressOptions1.withDuration(Duration.ofSeconds(5)).withElement(ElementOption.element(AndroidElement1));
        action1.longPress(longPressOptions1).release().perform();

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Color']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.socialnmobile.dictapps.notepad.color.note:id/txt2']")).click();
        System.out.println(driver.findElement(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/date")));


        //title 0
        LongPressOptions longPressOptions0 = new LongPressOptions();
        WebElement AndroidElement = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Title 0']"));
        AndroidTouchAction action = new AndroidTouchAction(driver);
        longPressOptions0.withDuration(Duration.ofSeconds(5)).withElement(ElementOption.element(AndroidElement));
        action.longPress(longPressOptions0).release().perform();

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Color']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.socialnmobile.dictapps.notepad.color.note:id/txt3']")).click();
        System.out.println(driver.findElement(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/date")));

        //Open Settings, and change the First day of week to MONDAY.
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@resource-id='com.socialnmobile.dictapps.notepad.color.note:id/icon_nav']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Settings']")).click();

        //scroll
        ((JavascriptExecutor) driver).executeScript("mobile: scroll", ImmutableMap.of(
                    "direction", "down",
                    "strategy","-android uiautomator",
                    "selector", "text(\"First day of week\")"
            ));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='First day of week']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@text='Monday']")).click();
        driver.quit();
    }
}
