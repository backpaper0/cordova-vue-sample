package testcase;

import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;

public abstract class TestCaseSkeleton {

    @Rule
    public TestRule contextSwitcherForAppium = new TestRule() {
        @Override
        public Statement apply(Statement base, Description description) {
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    if (isAppium()) {
                        switchContextToWebView();
                        base.evaluate();
                        switchContextToNative();
                    } else {
                        base.evaluate();
                    }
                }
            };
        }
    };

    private boolean isAppium() {
        return WebDriverRunner.getWebDriver() instanceof AppiumDriver<?>;
    }

    protected void launchApp() {
        if (isAppium() == false) {
            Selenide.open("/");
        }
    }

    protected void takeScreenshot(String fileName) {
        if (isAppium()) {
            switchContextToNative();
            Selenide.screenshot(fileName);
            switchContextToWebView();
        } else {
            Selenide.screenshot(fileName);
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
