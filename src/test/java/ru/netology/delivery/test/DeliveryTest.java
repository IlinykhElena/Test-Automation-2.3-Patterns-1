package ru.netology.delivery.test;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.delivery.data.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DeliveryTest {

    @BeforeEach
    void setUp() {
        open("http://localhost:9999/");
    }

    @Test
    void shouldPlanAndReplanMeeting() {
        var validUser = DataGenerator.Registration.generateUser("ru");
        var date1 = DataGenerator.generateDate(3);
        var date2 = DataGenerator.generateDate(5);
        $("[data-test-id=\"city\"] .input__control").setValue(validUser.getCity());
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[placeholder=\"Дата встречи\"]").setValue(date1);
        $("[data-test-id=\"name\"] .input__control").setValue(validUser.getName());
        $("[data-test-id=\"phone\"] .input__control").setValue(validUser.getPhone());
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Запланировать")).click();

        $("[data-test-id=\"success-notification\"] .notification__content").shouldHave(Condition.text("Встреча успешно забронирована на " + date1), Duration.ofSeconds(15));
        $(".notification__content").shouldBe(visible);

        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[placeholder=\"Дата встречи\"]").setValue(date2);
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Запланировать")).click();
        $("[data-test-id=\"replan-notification\"]").should(visible, Duration.ofSeconds(15));
        $(byText("Перепланировать")).click();
        $("[data-test-id=\"success-notification\"]").should(visible, Duration.ofSeconds(15));
        $("[data-test-id=\"success-notification\"]").shouldHave(Condition.text("Встреча успешно забронирована на " + date2), Duration.ofSeconds(15));
    }
}
