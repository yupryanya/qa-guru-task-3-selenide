package guru.qa;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPageGitHubTest extends BaseTest {

    @Test
    void toSolutionEnterpriseFromMenu() {

        open("https://github.com");

        $(".header-menu-wrapper").$(withTagAndText("button", "Solutions")).hover();
        $(".header-menu-wrapper").$(withTagAndText("a", "Enterprise")).click();
        $(".application-main h4").shouldHave(text("GitHub for Enterprises"));
    }
}
