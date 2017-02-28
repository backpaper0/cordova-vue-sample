package testcase;

import org.junit.Before;
import org.junit.Test;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import page.HomePage;
import page.UsersPage;

public class SearchUserTest extends TestCaseSkeleton {

    private HomePage homePage;

    @Before
    public void setUp() throws Exception {
        UsersPage usersPage = Selenide.page(UsersPage.class);
        if (usersPage.page.isDisplayed()) {
            usersPage.backToHome.click();
        }
        homePage = Selenide.page(HomePage.class);
        homePage.page.shouldBe(Condition.visible);
    }

    @Test
    public void testBackpaper0() throws Exception {
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

    @Test
    public void testSyobochim() throws Exception {
        takeScreenshot("004.home_init");
        homePage.query.val("syobochim");
        takeScreenshot("005.home_input");
        homePage.searchUsers.click();
        UsersPage usersPage = Selenide.page(UsersPage.class);
        usersPage.page.shouldBe(Condition.visible);
        takeScreenshot("006.users");
        usersPage.users.shouldBe(CollectionCondition.size(1));
        usersPage.users.get(0).shouldBe(Condition.text("syobochim"));
    }

    @Test
    public void testIrof() throws Exception {
        takeScreenshot("007.home_init");
        homePage.query.val("irof");
        takeScreenshot("008.home_input");
        homePage.searchUsers.click();
        UsersPage usersPage = Selenide.page(UsersPage.class);
        usersPage.page.shouldBe(Condition.visible);
        takeScreenshot("009.users");
        usersPage.users.shouldBe(CollectionCondition.sizeGreaterThan(1));
        usersPage.users.get(0).shouldBe(Condition.text("irof"));
    }
}
