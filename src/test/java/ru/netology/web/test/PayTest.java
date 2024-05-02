package ru.netology.web.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.web.data.DataHelper;
import ru.netology.web.data.SQLHelper;
import ru.netology.web.pages.DashboardPage;
import ru.netology.web.pages.PaymentPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.web.data.DataHelper.*;

public class PayTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://localhost:8080");
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    @DisplayName("1. Оплата с одобренной карты с валидными данными")
    public void shouldSuccessfulPay() {
        var userInfo = new DataHelper.UserInfo(getApprovedCardInfo(), getValidMonth(), getValidYear(), getRandomName(), getValidCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.verifySuccessNotification();
    }

    @Test
    @DisplayName("2. Покупка в кредит с одобренной карты с валидными данными")
    public void shouldSuccessfulCredit() {
        var userInfo = new DataHelper.UserInfo(getApprovedCardInfo(), getValidMonth(), getValidYear(), getRandomName(), getValidCVC());
        var dashboardPage = new DashboardPage();
        var creditPage = dashboardPage.payByCredit();
        creditPage.formCredit(userInfo);
        creditPage.verifySuccessNotificationCredit();
    }

    @Test
    @DisplayName("3. Оплата с удаленной карты с валидными данными") // не проходит
    public void shouldNegativePayWithDeclinedCard() {
        var userInfo = new DataHelper.UserInfo(getDeclinedCardInfo(), getValidMonth(), getValidYear(), getRandomName(), getValidCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.verifyErrorNotification();
    }

    @Test
    @DisplayName("4. Покупка в кредит с удаленной карты с валидными данными") // не проходит
    public void shouldNegativeCreditWithDeclinedCard() {
        var userInfo = new DataHelper.UserInfo(getDeclinedCardInfo(), getValidMonth(), getValidYear(), getRandomName(), getValidCVC());
        var dashboardPage = new DashboardPage();
        var creditPage = dashboardPage.payByCredit();
        creditPage.formCredit(userInfo);
        creditPage.verifyErrorNotificationCredit();
    }

    @Test
    @DisplayName("5. Оплата по карте с невалидным номером")
    public void PayWithCardInvalidNumber() {
        var userInfo = new DataHelper.UserInfo(randomNumberCardInfo(), getValidMonth(), getValidYear(), getRandomName(), getValidCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.verifyErrorNotification();
    }
    @Test
    @DisplayName("6. Оплата по карте с неполным номером")
    public void PayWithCardIncompleteNumber() {
        var userInfo = new DataHelper.UserInfo(getIncompleteNumberCardInfo(), getValidMonth(), getValidYear(), getRandomName(), getValidCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.errorFormatVisible();
    }

    @Test
    @DisplayName("7. Оплата услуги без указания номера карты")
    public void EmptyCardNumber() {
        var userInfo = new DataHelper.UserInfo(getEmptyCardInfo(), getValidMonth(), getValidYear(), getRandomName(), getValidCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.errorFormatVisible();
    }

    @Test
    @DisplayName("8. Отправка формы оплаты без указания месяца")
    public void EmptyMonth() {
        var userInfo = new DataHelper.UserInfo(getApprovedCardInfo(), getEmptyMonth(), getValidYear(), getRandomName(), getValidCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.errorFormatVisible();
    }

    @Test
    @DisplayName("9. Отправка формы оплаты с месяцем 00") //не проходит
    public void ZeroMonth() {
        var userInfo = new DataHelper.UserInfo(getApprovedCardInfo(), getZeroMonth(), getValidYear(), getRandomName(), getValidCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.errorFormatVisible();
    }

    @Test
    @DisplayName("10. Отправка формы оплаты с несуществующим месяцем")
    public void nonExistentMonth() {
        var userInfo = new DataHelper.UserInfo(getApprovedCardInfo(), get13Month(), getValidYear(), getRandomName(), getValidCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.invalidExpirationDateVisible();
    }

    @Test
    @DisplayName("11. Ввод одной цифры в поле месяц")
    public void OneDigitMonth() {
        var userInfo = new DataHelper.UserInfo(getApprovedCardInfo(), getInOneDigitMonth(), getValidYear(), getRandomName(), getValidCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.errorFormatVisible();
    }

    @Test
    @DisplayName("12. Ввод трех цифр в поле месяц")
    public void ThreeDigitMonth() {
        var userInfo = new DataHelper.UserInfo(getApprovedCardInfo(), getInThreeDigitMonth(), getValidYear(), getRandomName(), getValidCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.invalidExpirationDateVisible();
    }

    @Test
    @DisplayName("13. Ввод букв в поле месяц")
    public void LettersMonth() {
        var userInfo = new DataHelper.UserInfo(getApprovedCardInfo(), getLettersMonth(), getValidYear(), getRandomName(), getValidCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.errorFormatVisible();
    }

    @Test
    @DisplayName("14. Ввод символов в поле месяц")
    public void SymbolMonth() {
        var userInfo = new DataHelper.UserInfo(getApprovedCardInfo(), getSymbolMonth(), getValidYear(), getRandomName(), getValidCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.errorFormatVisible();
    }

    @Test
    @DisplayName("15. Отправка формы оплаты с пустым годом")
    public void EmptyYear() {
        var userInfo = new DataHelper.UserInfo(getApprovedCardInfo(), getValidMonth(), getEmptyYear(), getRandomName(), getValidCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.errorFormatVisible();
    }

    @Test
    @DisplayName("16. Отправка формы оплаты с годом из прошлого")
    public void PastYear() {
        var userInfo = new DataHelper.UserInfo(getApprovedCardInfo(), getValidMonth(), getPastYear(), getRandomName(), getValidCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.cardHasExpiredVisible();
    }

    @Test
    @DisplayName("17. Отправка формы оплаты с годом, следующим за сроком действия карты")
    public void FutureYear() {
        var userInfo = new DataHelper.UserInfo(getApprovedCardInfo(), getValidMonth(), getFutureYear(), getRandomName(), getValidCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.invalidExpirationDateVisible();
    }

    @Test
    @DisplayName("18. Ввод трех цифр в поле год")
    public void ThreeDigitsYear() {
        var userInfo = new DataHelper.UserInfo(getApprovedCardInfo(), getValidMonth(), getThreeDigitsYear(), getRandomName(), getValidCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.invalidExpirationDateVisible();
    }

    @Test
    @DisplayName("19. Ввод одной цифры в поле год")
    public void OneDigitsYear() {
        var userInfo = new DataHelper.UserInfo(getApprovedCardInfo(), getValidMonth(), getOneDigitsYear(), getRandomName(), getValidCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.errorFormatVisible();
    }

    @Test
    @DisplayName("20. Ввод букв в поле год")
    public void LettersYear() {
        var userInfo = new DataHelper.UserInfo(getApprovedCardInfo(), getValidMonth(), getLettersYear(), getRandomName(), getValidCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.errorFormatVisible();
    }

    @Test
    @DisplayName("21. Ввод символов в поле год")
    public void SymbolYear() {
        var userInfo = new DataHelper.UserInfo(getApprovedCardInfo(), getValidMonth(), getSymbolYear(), getRandomName(), getValidCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.errorFormatVisible();
    }

    @Test
    @DisplayName("22. Отправка формы оплаты с пустым полем \"Владелец\"")
    public void EmptyName() {
        var userInfo = new DataHelper.UserInfo(getApprovedCardInfo(), getValidMonth(), getValidYear(), getEmptyName(), getValidCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.errorNameVisible();
    }

    @Test
    @DisplayName("23. Ввод кирилицы в поле Владелец") // не проходит
    public void RandomRusName() {
        var userInfo = new DataHelper.UserInfo(getApprovedCardInfo(), getValidMonth(), getValidYear(), getRandomRusName(), getValidCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.errorFormatVisible();
    }

    @Test
    @DisplayName("24. Ввод цифр в поле Владелец") // не проходит
    public void DigitName() {
        var userInfo = new DataHelper.UserInfo(getApprovedCardInfo(), getValidMonth(), getValidYear(), getDigitName(), getValidCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.errorFormatVisible();
    }

    @Test
    @DisplayName("25. Ввод символов в поле Владелец") // не проходит
    public void SymbolName() {
        var userInfo = new DataHelper.UserInfo(getApprovedCardInfo(), getValidMonth(), getValidYear(), getSymbolName(), getValidCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.errorFormatVisible();
    }

    @Test
    @DisplayName("26. Ввод 65 латинских букв в поле Владелец") // не проходит
    public void More64LettersName() {
        var userInfo = new DataHelper.UserInfo(getApprovedCardInfo(), getValidMonth(), getValidYear(), get65LettersName(), getValidCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.errorFormatVisible();
    }

    @Test
    @DisplayName("27. Ввод двойной фамилии через дефис в поле Владелец")
    public void DoubleSurnameName() {
        var userInfo = new DataHelper.UserInfo(getApprovedCardInfo(), getValidMonth(), getValidYear(), getDoubleSurnameName(), getValidCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.verifySuccessNotification();
    }

    @Test
    @DisplayName("28. Отправка формы оплаты с пустым полем CVC/CVV")
    public void EmptyCVC() {
        var userInfo = new DataHelper.UserInfo(getApprovedCardInfo(), getValidMonth(), getValidYear(), getRandomName(), getEmptyCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.errorFormatVisible();
    }

    @Test
    @DisplayName("29. Ввод 1 цифры в поле CVC/CVV")
    public void OneDigitCVC() {
        var userInfo = new DataHelper.UserInfo(getApprovedCardInfo(), getValidMonth(), getValidYear(), getRandomName(), getOneDigitCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.errorFormatVisible();
    }


    @Test
    @DisplayName("30. Ввод букв в поле CVC/CVV")
    public void LettersCVC() {
        var userInfo = new DataHelper.UserInfo(getApprovedCardInfo(), getValidMonth(), getValidYear(), getRandomName(), getLettersCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.errorFormatVisible();
    }

    @Test
    @DisplayName("31. Ввод символов в поле CVC/CVV")
    public void SymbolCVC() {
        var userInfo = new DataHelper.UserInfo(getApprovedCardInfo(), getValidMonth(), getValidYear(), getRandomName(), getSymbolCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.errorFormatVisible();
    }

    @Test
    @DisplayName("32. Просмотр статуса в MySQL пользователя с одобренной картой")
    public void SQLStatusApprovedCard() {
        var userInfo = new DataHelper.UserInfo(getApprovedCardInfo(), getValidMonth(), getValidYear(), getRandomName(), getValidCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.verifySuccessNotification();
        var PaymentStatus = SQLHelper.getStatusSQL();
        Assertions.assertEquals("APPROVED", PaymentStatus);
    }

    @Test
    @DisplayName("33. Просмотр статуса оплаты в MySQL пользователя с одобренной картой")
    public void SQLStatusAmountApprovedCard() {
        var userInfo = new DataHelper.UserInfo(getApprovedCardInfo(), getValidMonth(), getValidYear(), getRandomName(), getValidCVC());
        var dashboardPage = new DashboardPage();
        var paymentPage = dashboardPage.payByCard();
        paymentPage.formPay(userInfo);
        paymentPage.verifySuccessNotification();
        var PaymentAmount = SQLHelper.getAmountSQL();
        Assertions.assertEquals(45000, PaymentAmount);
    }
}