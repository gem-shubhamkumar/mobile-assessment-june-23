package StepDefinition;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Step2 {

    AndroidDriver driver;
    @Given("User is on login page")
    public void user_is_on_login_page() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:devicename", "Android Emulator");
        desiredCapabilities.setCapability("appium:platformName", "Android");
        desiredCapabilities.setCapability("appium:app", "C:\\Users\\Shivam.Roy\\ANDROID\\src\\main\\resources\\General-Store.apk");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(url, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @When("User fills the details")
    public void user_fills_the_details() {
       driver.findElement(AppiumBy.id("android:id/text1")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Bangladesh\").instance(0))")).click();
       driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("shivam yadav");

    }

    @Then("User click on shopnow")
    public void user_click_on_shopnow() {
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"PG 3\").instance(0))")).click();
        driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text='ADD TO CART'])[2]")).click();

        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        WebElement ele=driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text='Shivam'])[1]"));
        AndroidTouchAction action =new AndroidTouchAction(driver);
        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(ele))).perform();



    }


}
