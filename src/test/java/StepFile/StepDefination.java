package StepFile;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.App;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class StepDefination {
    static AppiumDriver driver;

    @Before
    public void setingUpCapabilities() {
        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("deviceName", "Android-Emulator");
            cap.setCapability("udid", "emulator-5554");
            cap.setCapability("platformName", "Android");
            cap.setCapability("app", "C:\\Users\\yudhisthir.gour\\Downloads\\ColorNote+Notepad.apk");

            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver(url, cap);
            System.out.println("Notepad is Launched");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @Given("Add three text-notes")
    public void add_three_text_notes() {
        driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click();
        driver.findElement(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/btn_start_skip")).click();

        for (int i = 1; i < 4; i++) {
            driver.findElement(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/main_btn1")).click();
            driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]")).click();
            WebElement note = driver.findElement(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/edit_note"));
            note.sendKeys("Hello This is Note " + i);
            driver.navigate().back();
            driver.navigate().back();
            driver.navigate().back();
        }

    }

    @When("Change the color of text note as RED ORANGE YELLOW")
    public void change_the_color_of_text_note_as_red_orange_yellow() {
        //long pressing on text 1
        LongPressOptions longPressOptions1 = new LongPressOptions();
        WebElement text1 = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/b.k.a.a/android.view.ViewGroup/android.widget.RelativeLayout/b.q.a.b/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]"));
        AndroidTouchAction action1 = new AndroidTouchAction((PerformsTouchActions) driver);
        longPressOptions1.withDuration(Duration.ofSeconds(3)).withElement(ElementOption.element(text1));
        action1.longPress(longPressOptions1).release().perform();

        //changing color of first text to red
        driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"Color\"]/android.widget.ImageView")).click();
        driver.findElement(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/txt1")).click();


        //long pressing on text 2
        LongPressOptions longPressOptions2 = new LongPressOptions();
        WebElement text2 = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/b.k.a.a/android.view.ViewGroup/android.widget.RelativeLayout/b.q.a.b/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]"));
        AndroidTouchAction action2 = new AndroidTouchAction((PerformsTouchActions) driver);
        longPressOptions2.withDuration(Duration.ofSeconds(3)).withElement(ElementOption.element(text2));
        action2.longPress(longPressOptions2).release().perform();

        //changing color of first text to orange
        driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"Color\"]/android.widget.ImageView")).click();
        driver.findElement(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/txt2")).click();


        //long pressing on text 3
        LongPressOptions longPressOptions3 = new LongPressOptions();
        WebElement text3 = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/b.k.a.a/android.view.ViewGroup/android.widget.RelativeLayout/b.q.a.b/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.RelativeLayout[3]/android.widget.LinearLayout/android.widget.TextView[1]"));
        AndroidTouchAction action3 = new AndroidTouchAction((PerformsTouchActions) driver);
        longPressOptions3.withDuration(Duration.ofSeconds(3)).withElement(ElementOption.element(text3));
        action2.longPress(longPressOptions3).release().perform();

        //changing color of first text to yellow
        driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"Color\"]/android.widget.ImageView")).click();
        driver.findElement(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/txt3")).click();


    }

    @When("Print the time of each notes")
    public void print_the_time_of_each_notes(){
    //Printing the time of first Note
     String Time1 = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/b.k.a.a/android.view.ViewGroup/android.widget.RelativeLayout/b.q.a.b/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]")).getText();


    // Printing the time of second Note
      String Time2 =   driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/b.k.a.a/android.view.ViewGroup/android.widget.RelativeLayout/b.q.a.b/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.TextView[2]")).getText();



    //Printing the time of third Note
      String Time3 =   driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/b.k.a.a/android.view.ViewGroup/android.widget.RelativeLayout/b.q.a.b/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.RelativeLayout[3]/android.widget.LinearLayout/android.widget.TextView[2]")).getText();

        System.out.println(Time1);
        System.out.println(Time2);
        System.out.println(Time3);

    }

    @Then("Open Settings and change the First day of week to MONDAY")
    public void open_settings_and_change_the_first_day_of_week_to_monday() {
        //opening settings
        driver.findElement(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/main_btn3")).click();
        driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[6]/android.widget.RelativeLayout/android.widget.TextView")).click();

        //scrolling down to change first day of week
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
                + ".scrollIntoView(new UiSelector()" + ".textMatches(\"" + "First day of week" + "\").instance(0))"));

        driver.findElement(AppiumBy.xpath("//*[contains(@text,'First day of week')]")).click();
        driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")).click();
    }


}
