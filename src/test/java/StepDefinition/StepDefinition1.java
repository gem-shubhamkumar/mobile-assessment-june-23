package StepDefinition;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class StepDefinition1 {
    public static AndroidDriver driver;
    @Before
    public void setup()
    {
        try {

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("aapium:devicename", "Android Emulator");
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("appium:app", "C:\\Users\\muskan.kesarwani\\Downloads\\ColorNote+Notepad.apk");
            desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
            desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
            desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
            desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

            URL remoteUrl = new URL("http://localhost:4723/wd/hub");

            driver = SharedDriver.getDriver(desiredCapabilities,remoteUrl);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @Given("User is on notepad app")
    public void handlePopups()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("App has launched");
        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
        driver.findElement(By.id("com.socialnmobile.dictapps.notepad.color.note:id/btn_start_skip")).click();

    }

    @When("User creates notes")
    public void userCreatesANote() {
        for (int i=0;i<3;i++) {
            driver.findElement(By.id("com.socialnmobile.dictapps.notepad.color.note:id/main_btn1")).click();
            driver.findElement(By.xpath("//android.widget.TextView[@text='Text']")).click();
            driver.findElement(By.id("com.socialnmobile.dictapps.notepad.color.note:id/edit_note")).sendKeys("Muskan");
            driver.findElement(By.id("com.socialnmobile.dictapps.notepad.color.note:id/back_btn")).click();
            driver.findElement(By.id("com.socialnmobile.dictapps.notepad.color.note:id/back_btn")).click();
        }

    }




    @When("Change colour of first note")
    public void changeColourOfFirstNote() {
        AndroidTouchAction touch = new AndroidTouchAction (driver);
        touch.longPress(LongPressOptions.longPressOptions()
                        .withElement (ElementOption.element (driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.socialnmobile.dictapps.notepad.color.note:id/background'])[1]")))))
                .perform ();

        driver.findElement(AppiumBy.accessibilityId("Color")).click();
        driver.findElement(By.id("com.socialnmobile.dictapps.notepad.color.note:id/txt1")).click();



    }

    @And("Change colour of second note")
    public void changeColourOfSecondNote() {
        AndroidTouchAction touch = new AndroidTouchAction (driver);
        touch.longPress(LongPressOptions.longPressOptions()
                        .withElement (ElementOption.element (driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.socialnmobile.dictapps.notepad.color.note:id/background'])[2]")))))
                .perform ();

        driver.findElement(AppiumBy.accessibilityId("Color")).click();
        driver.findElement(By.id("com.socialnmobile.dictapps.notepad.color.note:id/txt2")).click();

    }

    @And("Change colour of third note")
    public void changeColourOfThirdNote() {
        AndroidTouchAction touch = new AndroidTouchAction (driver);
        touch.longPress(LongPressOptions.longPressOptions()
                        .withElement (ElementOption.element (driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.socialnmobile.dictapps.notepad.color.note:id/background'])[3]")))))
                .perform ();

        driver.findElement(AppiumBy.accessibilityId("Color")).click();
        driver.findElement(By.id("com.socialnmobile.dictapps.notepad.color.note:id/txt3")).click();
    }

    @Then("Print time stamps of all the notes")
    public void printTimeStampsOfAllTheNotes() {
        System.out.println("Time stamps of the given notes are: ");
        for (int i=1;i<=3;i++)
        {
            System.out.println(driver.findElement(By.xpath("(//android.widget.TextView[@resource-id='com.socialnmobile.dictapps.notepad.color.note:id/date'])["+i+"]")).getText());
        }
    }

    @When("User clicks on options")
    public void userClicksOnOptions() {
        driver.findElement(By.id("com.socialnmobile.dictapps.notepad.color.note:id/main_btn3")).click();

    }

    @And("User clicks on setting")
    public void userClicksOnSetting() {
        driver.findElement(By.xpath("//android.widget.TextView[@text='Settings']")).click();


    }

    @And("User scrolls to day option and clicks")
    public void userScrollsToDayOptionAndClicks() {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"First day of week\"));")).click();

    }

    @Then("User clicks on Monday")
    public void userClicksOnMonday() {
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Monday']")).click();
    }
}
