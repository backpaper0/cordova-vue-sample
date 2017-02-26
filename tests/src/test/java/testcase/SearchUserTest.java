package testcase;

import org.junit.Test;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import page.HomePage;
import page.UsersPage;

public class SearchUserTest extends TestCaseSkeleton {

    @Test
    public void test() throws Exception {
        launchApp();

        HomePage homePage = Selenide.page(HomePage.class);
        homePage.page.shouldBe(Condition.visible);

        takeScreenshot("001.home_init");

        homePage.query.val("backpaper0");

        takeScreenshot("002.home_input");

        homePage.searchUsers.click();

        UsersPage usersPage = Selenide.page(UsersPage.class);

        usersPage.page.shouldBe(Condition.visible);

        takeScreenshot("003.users");

        usersPage.users.shouldBe(CollectionCondition.size(1));
        usersPage.users.get(0).shouldBe(Condition.text("backpaper0"));
    }
}
