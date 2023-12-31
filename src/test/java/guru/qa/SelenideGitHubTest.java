package guru.qa;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class SelenideGitHubTest extends BaseTest {

    @Test
    void wikiSoftAssertionsShouldHaveJUnitTest() {

        open("https://github.com/selenide/selenide");

        // Ссылка, которую мы хотим найти на странице Wiki
        String linkToFind = "SoftAssertions";
        // Текст, который мы хотим найти на странице "SoftAssertions" в Wiki
        String textToFind = """ 
                Using JUnit5 extend test class:
                @ExtendWith({SoftAssertsExtension.class})
                  class Tests {
                    @Test
                 """;

        // Клик на меню для перехода на страницу Wiki
        $("#wiki-tab").click();

        // Клик на ссылку "More Pages", чтобы раскрыть список ссылок Wiki страниц
        $(".wiki-more-pages-link button").click();

        // Проверяем, есть ли нужная ссылка в списке Wiki страниц
        $("#wiki-pages-box").shouldHave(text(linkToFind));

        // Клик на ссылку для перехода на страницу "SoftAssertions"
        $("#wiki-pages-box [href*=" + linkToFind + "]").click();

        // Проверяем, есть ли на странице текст для JUnit5
        $("#wiki-body").shouldHave(text(textToFind));
    }
}
