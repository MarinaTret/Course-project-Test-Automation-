package ru.netology.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PaymentPage {

    private static final SelenideElement cardNumber = $("[placeholder=\"0000 0000 0000 0000\"]");
    private static final SelenideElement month = $("[placeholder=\"08\"]");
    private static final SelenideElement year = $("[placeholder=\"22\"]");
    private static final SelenideElement name = $(byText("Владелец")).parent().$(".input__control");
    private static final SelenideElement cvc = $("[placeholder=\"999\"]");
    private static final SelenideElement button = $(byText("Продолжить"));
    private static final SelenideElement successNotification = $(byText("Успешно")).parent().$(".notification__title");


    private static final SelenideElement errorNotification = $(byText("Ошибка")).parent().$(".notification__title");
    private static final SelenideElement errorFormat = $(byText("Неверный формат"));
    private static final SelenideElement invalidExpirationDate = $(byText("Неверно указан срок действия карты"));
    private static final SelenideElement cardHasExpired = $(byText("Истёк срок действия карты"));
    private static final SelenideElement errorName = $(byText("Поле обязательно для заполнения"));
    //private static final SelenideElement errorCvc = $(byText("CVC/CVV")).parent().$(".input__sub");



    public void PaymentPageVisibility() {
        cardNumber.shouldBe(visible);
    }

    public void verifySuccessNotification() {
        successNotification.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void verifyErrorNotification() {
        errorNotification.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void errorFormatVisible() {
        errorFormat.shouldBe(visible);
    }

    public void cardHasExpiredVisible() {
        cardHasExpired.shouldBe(visible);
    }

    public void invalidExpirationDateVisible() {
        invalidExpirationDate.shouldBe(visible);
    }

    public void errorNameVisible() {
        errorName.shouldBe(visible);
    }

    public void formPay(DataHelper.UserInfo userInfo) {
        cardNumber.setValue(userInfo.getCardNumber());
        month.setValue(userInfo.getMonth());
        year.setValue(userInfo.getYear());
        name.setValue(userInfo.getName());
        cvc.setValue(userInfo.getCvc());
        button.click();
        //successNotification.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }
}