package page;

import org.openqa.selenium.support.FindBy;
import com.codeborne.selenide.SelenideElement;

public class HomePage {

    @FindBy(css = "#home-page")
    public SelenideElement page;

    @FindBy(css = "#q")
    public SelenideElement query;
    @FindBy(css = "#sort")
    public SelenideElement sort;
    @FindBy(css = "#searchUsers")
    public SelenideElement searchUsers;
}
