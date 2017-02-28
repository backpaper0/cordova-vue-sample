package provider;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidDriverProvider implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, "true");

        desiredCapabilities.setCapability(MobileCapabilityType.APP,
                Paths.get("../platforms/android/build/outputs/apk/android-debug.apk")
                        .toAbsolutePath()
                        .toString());

        //        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,
        //                "com.github.backpaper0.sample.searchusers");
        //        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
        //                ".MainActivity");

        try {
            URL url = new URL("http://localhost:4723/wd/hub");
            AndroidDriver<WebElement> driver = new AndroidDriver<>(url, desiredCapabilities);
            return driver;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
