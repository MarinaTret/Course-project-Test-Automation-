package ru.netology.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CreditPage {
    private static final SelenideElement cardNumber = $(byText("Номер карты")).parent().$(".input__control");
    private static final SelenideElement month = $(byText("Месяц")).parent().$(".input__control");
    private static final SelenideElement year = $(byText("Год")).parent().$(".input__control");
    private static final SelenideElement name = $(byText("Владелец")).parent().$(".input__control");
    private static final SelenideElement cvc = $(byText("CVC/CVV")).parent().$(".input__control");
    private static final SelenideElement button = $(byText("Продолжить"));
    private static final SelenideElement successNotification = $(byText("Успешно")).parent().$(".notification__title");

    private static final SelenideElement errorNotification = $(byText("Ошибка")).parent().$(".notification__title");

    public void CreditPageVisibility() {
        cardNumber.shouldBe(visible);
    }

    public void verifySuccessNotificationCredit() {
        successNotification.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void verifyErrorNotificationCredit() {
        errorNotification.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void formCredit(DataHelper.UserInfo userInfo) {
        cardNumber.setValue(userInfo.getCardNumber());
        month.setValue(userInfo.getMonth());
        year.setValue(userInfo.getYear());
        name.setValue(userInfo.getName());
        cvc.setValue(userInfo.getCvc());
        button.click();
        //successNotification.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }
}
