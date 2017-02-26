package page;

import org.openqa.selenium.support.FindBy;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class UsersPage {

    @FindBy(css = "#users-page")
    public SelenideElement page;

    @FindBy(css = ".user")
    public ElementsCollection users;
}
