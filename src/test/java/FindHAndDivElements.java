
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;


public class FindHAndDivElements {

    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void DifferentResults() {

        open("https://javarush.com/quests/QUEST_JAVA_CORE");

        SelenideElement s = $("h1 div");

        SelenideElement s2 = $("h1").$("div");

        System.out.println(s);

        sleep(5000);

    }
}
