package StepDefinition;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class NotepadStepDefinition {
    AndroidDriver driver;
    @Given("User is on homepage")
    public void user_is_on_homepage() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:devicename", "Android Emulator");
        desiredCapabilities.setCapability("appium:platformName", "Android");
        desiredCapabilities.setCapability("appium:app", "C:\\Users\\Shivam.Roy\\ANDROIDTEST\\src\\main\\resources\\ColorNote+Notepad.apk");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(url, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click();
        driver.findElement(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/btn_start_skip")).click();
    }
    @When("User Makes Notes")
    public void user_makes_notes() {

        for(int i=0;i<3;i++) {
            driver.findElement(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/main_btn1")).click();
            driver.findElement(AppiumBy.xpath("(//android.widget.LinearLayout)[4]")).click();
            driver.findElement(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/edit_note")).sendKeys("SHIVAM"+i);
            driver.findElement(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/back_btn")).click();
            driver.findElement(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/back_btn")).click();
        }
    }
    @Then("Change color and change dates")
    public void change_color_and_change_dates() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement ele=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='SHIVAM0']"));

        TouchAction action =new TouchAction<>(driver);

        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(ele))).perform();
        driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"Color\"]/android.widget.ImageView")).click();

        driver.findElement(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/txt1")).click();

        WebElement ele1=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='SHIVAM1']"));

        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(ele1))).perform();
        driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"Color\"]/android.widget.ImageView")).click();
        driver.findElement(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/txt2")).click();
        WebElement ele2=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='SHIVAM2']"));

        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(ele2))).perform();
        driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"Color\"]/android.widget.ImageView")).click();
        driver.findElement(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/txt3")).click();
        String t1=driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.socialnmobile.dictapps.notepad.color.note:id/date'])[1]")).getText();
        String t2=driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.socialnmobile.dictapps.notepad.color.note:id/date'])[2]")).getText();
        String t3=driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.socialnmobile.dictapps.notepad.color.note:id/date'])[3]")).getText();

        System.out.println(t1+" "+t2+" "+t3);
        driver.findElement(AppiumBy.id("com.socialnmobile.dictapps.notepad.color.note:id/main_btn3")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Settings']")).click();

        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"First day of week\").instance(0))")).click();
        driver.findElement(AppiumBy.xpath("(//android.widget.CheckedTextView[@resource-id='android:id/text1'])[2]")).click();

    }

}
