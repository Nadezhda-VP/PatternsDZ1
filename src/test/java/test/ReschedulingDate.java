package test;


import data.DataPatternGenerator;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ReschedulingDate {
    private DataPatternGenerator.DataPattern dataText = DataPatternGenerator.generateData();
    private DataPatternGenerator date = new DataPatternGenerator();

    private SelenideElement dateElement;
    private SelenideElement planBtnElement;
    private SelenideElement replainElement;
    private SelenideElement planSuccessElement;

    @Test
    public void testValid() {
        open("http://localhost:9999/");

        $("[data-test-id ='city'] input").setValue(dataText.getCity());
        $("[data-test-id ='name'] input").setValue(dataText.getName());
        dateElement = $("[data-test-id ='date'] input");
        dateElement.sendKeys(Keys.LEFT_CONTROL + "a" + Keys.BACK_SPACE);
        dateElement.setValue(date.date(3));
        $(".input__inner").click();
        $("[data-test-id ='phone'] input").setValue(dataText.getPhone());
        $("[data-test-id ='agreement']").click();

        planBtnElement = $$("button").find(exactText("Запланировать"));
        planBtnElement.click();

        planSuccessElement = $("[data-test-id=success-notification]");
        planSuccessElement.shouldHave(text("Встреча успешно запланирована на")).shouldHave(text(date.date(3)));

        dateElement.sendKeys(Keys.LEFT_CONTROL + "a" + Keys.BACK_SPACE);
        dateElement.setValue(date.date(4));
        planBtnElement.click();

        replainElement = $("[data-test-id=replan-notification]");
        replainElement.shouldHave(text("Необходимо подтверждение"));
        replainElement.$$("button").find(exactText("Перепланировать")).click();

        planSuccessElement.shouldHave(text("Встреча успешно запланирована на")).shouldHave(text(date.date(4)));
    }

}