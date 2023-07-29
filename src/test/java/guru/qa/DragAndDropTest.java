package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com/drag_and_drop";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void checkWithactions() {

        open("");

        SelenideElement sourceLocator = $("#column-a");
        SelenideElement destinationLocator = $("#column-b");

        //должно перемещать элемент из колонки А в колонку B с помощью actions
        //Не работает ¯\_(ツ)_/¯
        actions()
                .clickAndHold(sourceLocator)
                .moveToElement(destinationLocator)
                .release()
                .perform();

        //проверяем что элементы поменялись
        sourceLocator.shouldHave(text("B"));
        destinationLocator.shouldHave(text("A"));
    }

    @Test
    void checkWithDragAndDropMethod() {

        open("");

        SelenideElement sourceLocator = $("#column-a");
        SelenideElement destinationLocator = $("#column-b");

        //перемещаем элемент из колонки А в колонку B с помощью dragAndDropTo
        sourceLocator.dragAndDropTo(destinationLocator);

        //проверяем что элементы поменялись
        sourceLocator.shouldHave(text("B"));
        destinationLocator.shouldHave(text("A"));

    }
}