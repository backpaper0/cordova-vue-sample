package provider;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.codeborne.selenide.WebDriverProvider;

public class ChromeMobileEmulatorDriverProvider implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Google Nexus 5");

        Map<String, Object> chromeOptions = new HashMap<>();
        chromeOptions.put("mobileEmulation", mobileEmulation);
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        ChromeDriver driver = new ChromeDriver(desiredCapabilities);

        return driver;
    }
}
