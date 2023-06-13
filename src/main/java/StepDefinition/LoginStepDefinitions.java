package StepDefinition;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class LoginStepDefinitions {

    AndroidDriver driver;
    @Given("User fills the details on login page")
    public void login() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:devicename", "Android Emulator");
        desiredCapabilities.setCapability("appium:platformName", "Android");
        desiredCapabilities.setCapability("appium:app", "C:\\Users\\Shivam.Roy\\ANDROID\\src\\main\\resources\\General-Store.apk");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(url, desiredCapabilities);



    }
    @When("User adds a product to cart")
    public void addProduct() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(AppiumBy.id("android:id/text1")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Bangladesh\").instance(0))")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Shivam");
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

    }
    @Then("User checks out")
    public void checkout() {
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/productAddCart")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        AndroidTouchAction action = new AndroidTouchAction(driver);

        WebElement longpress = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/termsButton"));

        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(longpress))).perform();
        driver.findElement(AppiumBy.id("android:id/button1")).click();
    }


}
