package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPageGitHubTest {

    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void toSolutionEnterpriseFromMenu() {

        open("");

        $(".header-menu-wrapper").$(withTagAndText("button","Solutions")).hover();
        $(".header-menu-wrapper").$(withTagAndText("a", "Enterprise")).click();
        $(".application-main h4").shouldHave(text("GitHub for Enterprises"));
    }
}
