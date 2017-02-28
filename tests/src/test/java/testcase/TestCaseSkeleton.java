package testcase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.runners.model.Statement;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import provider.ChromeMobileEmulatorDriverProvider;

public abstract class TestCaseSkeleton {

    static {
        if (System.getProperty("webdriver.chrome.driver") == null) {
            Path home = Paths.get(System.getProperty("user.home"));
            Stream.of("chromedriver", "chromedriver.exe")
                    .map(home::resolve)
                    .filter(Files::exists)
                    .findAny()
                    .map(Path::toAbsolutePath)
                    .map(Objects::toString)
                    .ifPresent(x -> System.setProperty("webdriver.chrome.driver", x));
        }
        if (System.getProperty("selenide.browser") == null) {
            Configuration.browser = ChromeMobileEmulatorDriverProvider.class.getName();
        }
    }

    private boolean screenshot = Boolean.parseBoolean(System.getProperty("my.screenshot", "true"));

    @Rule
    public TestRule contextSwitcherForAppium = (base, description) -> new Statement() {
        @Override
        public void evaluate() throws Throwable {
            if (isAppium()) {
                switchContextToWebView();
                base.evaluate();
                switchContextToNative();
            } else {
                Selenide.open("/");
                base.evaluate();
            }
        }
    };

    private boolean isAppium() {
        return WebDriverRunner.getWebDriver() instanceof AppiumDriver<?>;
    }

    protected void takeScreenshot(String fileName) {
        if (screenshot) {
            if (isAppium()) {
                switchContextToNative();
                Selenide.screenshot(fileName);
                switchContextToWebView();
            } else {
                Selenide.screenshot(fileName);
            }
        }
    }

    private void switchContextToNative() {
        switchContextTo("NATIVE_APP");
    }
    private void switchContextToWebView() {
        switchContextTo("WEBVIEW");
    }

    private void switchContextTo(String contextInfix) {
        AppiumDriver<?> driver = (AppiumDriver<?>) WebDriverRunner.getWebDriver();
        driver.context(driver
                .getContextHandles()
                .stream()
                .filter(x -> x.contains(contextInfix))
                .findAny()
                .get());
    }
}
