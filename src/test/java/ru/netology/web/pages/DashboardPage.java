package ru.netology.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Value;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    private static final SelenideElement heading = $(byText("Путешествие дня"));
    private static final SelenideElement paymentButton = $(byText("Купить"));
    private static final SelenideElement creditButton = $(byText("Купить в кредит"));

    public PaymentPage payByCard() {
        heading.shouldBe(visible);
        paymentButton.click();
        return new PaymentPage();
    }

    public CreditPage payByCredit() {
        heading.shouldBe(visible);
        creditButton.click();
        return new CreditPage();
    }
}
