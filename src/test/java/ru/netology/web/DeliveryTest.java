package ru.netology.web;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class DeliveryTest {

    @Test
    void shouldRunDeliveryForm() {
        open("http://localhost:9999");
        $("[placeholder= 'Город']").setValue("Кострома");
        $("[placeholder= 'Дата встречи']").doubleClick();
        $("[placeholder= 'Дата встречи']").sendKeys(Keys.chord(Keys.BACK_SPACE));
        String dateOfMeeting = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[placeholder= 'Дата встречи']").setValue(dateOfMeeting);
        $("[name= 'name']").setValue("Сусанин Иван");
        $("[name= 'phone']").setValue("+78889990001");
        $(".checkbox__box").click();
        $(".button__content").click();
        $(".notification").waitUntil(visible, 15000);
        $(".notification__content").shouldHave(text("Встреча успешно забронирована на " + dateOfMeeting));
    }
}
