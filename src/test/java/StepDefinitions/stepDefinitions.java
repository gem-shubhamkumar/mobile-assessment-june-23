package StepDefinitions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class stepDefinitions {


    AppiumDriver driver;

    DesiredCapabilities capabilities;
    URL url;

    @Given("User is on notepad app")
    public void user_is_on_notepad_app()  {

        try {

            //Launching the app
            capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "Android-Emulator");
            capabilities.setCapability("udid", "emulator-5554");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("app", "C:\\Users\\chippada.monisha\\Desktop\\APK\\ColorNote+Notepad.apk");
            url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver(url, capabilities);

            System.out.println("App Started !");

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("User creates three notes")
    public void user_creates_three_notes() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //handling the alert box
        driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click();
        driver.findElement(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/btn_start_skip")).click();

        //creating notes
        for(int i = 0; i < 3; i++){
            driver.findElement(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/main_btn1")).click();
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Text\"]")).click();
            driver.findElement(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/edit_note")).sendKeys(i + " : Note");
            driver.navigate().back();
            driver.navigate().back();
            driver.navigate().back();
        }
    }
    @Then("User changes the color of the notes and print the timestamps")
    public void user_changes_the_color_of_the_notes() {

        // adding colors to the notes
        AndroidTouchAction action = new AndroidTouchAction((PerformsTouchActions) driver);
        List<WebElement> notes = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.socialnmobile.dictapps.notepad.color.note:id/title\"][1]"));
        int j = 1;
        for(int i = 0; i<notes.size(); i++){
            action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(notes.get(i)))).perform();
            driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"Color\"]/android.widget.ImageView")).click();
            driver.findElement(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/txt"+j)).click();
            j += 1;
        }

        //printing the timestamps of the notes
        List<WebElement> timeStamps = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.socialnmobile.dictapps.notepad.color.note:id/date\"]"));
        for(int i =0; i< timeStamps.size();i++){
            System.out.println("TimeStamps of Note " + i + " " + timeStamps.get(i).getText());
        }

    }
    @Then("User changes the day of week")
    public void user_changes_the_day_of_week() {
        //navigating to settings
        driver.findElement(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/main_btn3")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Settings\"]")).click();


        //scroll to "first day of week"
        HashMap<String, Object> scrollObject = new HashMap();
        scrollObject.put("strategy", "-android uiautomator");
        scrollObject.put("selector", "text(\"First day of week\")");
        scrollObject.put("percent",2);
        scrollObject.put("direction","down");
        driver.executeScript("mobile: scroll",scrollObject);

        //click on "first day of week"
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"First day of week\"]")).click();

        //select "monday"
        driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@text=\"Monday\"]")).click();


        //quit the app
        driver.quit();
    }




}
