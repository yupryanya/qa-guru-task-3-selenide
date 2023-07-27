
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class SelenideGitHubTest {

    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://github.com/selenide/selenide";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void WikiSoftAssertionsShouldHaveJUnitTest() {

        open("");

        String linkToFind = "SoftAssertions";

        String textToFind = """ 
                Using JUnit5 extend test class:
                @ExtendWith({SoftAssertsExtension.class})
                  class Tests {
                    @Test
                 """;

        $("#wiki-tab").click();

        $(".wiki-more-pages-link button").click();
        $("#wiki-pages-box").shouldHave(text(linkToFind));

        $("#wiki-pages-box [href*=" + linkToFind + "]").click();

        $("#wiki-body").shouldHave(text(textToFind));

    }
}
