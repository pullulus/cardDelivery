package ru.netology.web;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.*;
import static java.time.LocalDate.*;

public class DeliveryTest {
    @Test
    void shouldRunDeliveryForm() {
        open("http://localhost:9999");
        $("[placeholder= 'Город']").setValue("Кострома");
        $("[placeholder= 'Дата встречи']").sendKeys(Keys.chord(Keys.BACK_SPACE));
        $("[placeholder= 'Дата встречи']").sendKeys(Keys.chord(Keys.BACK_SPACE));
        $("[placeholder= 'Дата встречи']").sendKeys(Keys.chord(Keys.BACK_SPACE));
        $("[placeholder= 'Дата встречи']").sendKeys(Keys.chord(Keys.BACK_SPACE));
        $("[placeholder= 'Дата встречи']").sendKeys(Keys.chord(Keys.BACK_SPACE));
        $("[placeholder= 'Дата встречи']").sendKeys(Keys.chord(Keys.BACK_SPACE));
        $("[placeholder= 'Дата встречи']").sendKeys(Keys.chord(Keys.BACK_SPACE));
        $("[placeholder= 'Дата встречи']").sendKeys(Keys.chord(Keys.BACK_SPACE));
        LocalDate date = LocalDate.now().plusDays(3);
        $("[placeholder= 'Дата встречи']").
        $$("[type= 'text']").last().setValue("Сусанин Иван");
        $("[name= 'phone']").setValue("+78889990001");
        $(".checkbox__box").click();
        $(".button__content").click();
        $(".notification").waitUntil(Condition.visible, 15000);
    }
}
