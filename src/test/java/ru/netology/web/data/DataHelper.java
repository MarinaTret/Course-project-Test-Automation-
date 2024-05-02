package ru.netology.web.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {
    private DataHelper() {
    }

    private static final Faker faker = new Faker(new Locale("en"));

    // Номер карты
    public static String getApprovedCardInfo() {
        return ("1111 2222 3333 4444");
    }

    public static String getDeclinedCardInfo() {
        return ("5555 6666 7777 8888");
    }

    public static String randomNumberCardInfo() {
        return faker.numerify("################");
    }

    public static String getIncompleteNumberCardInfo() {
        return ("1111 2222 3333 444");
    }

    public static String getEmptyCardInfo() {
        return ("");
    }

//Месяц
    public static String getValidMonth() {
        return LocalDate.now().plusMonths(faker.number().numberBetween(1, 12)).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getZeroMonth() {
        return ("00");
    }

    public static String getEmptyMonth() {
        return ("");
    }

    public static String get13Month() {
        return ("13");
    }

    public static String getInOneDigitMonth() {
        return faker.numerify("#");
    }

    public static String getInThreeDigitMonth() {
        return faker.numerify("###");
    }

    public static String getLettersMonth() {
        return faker.letterify("##");
    }

    public static String getSymbolMonth() {
        return ("=/");
    }
//Год

    public static String getValidYear() {
        return LocalDate.now().plusYears(faker.number().numberBetween(1, 5)).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getPastYear() {
        return LocalDate.now().plusYears(faker.number().numberBetween(-1, -5)).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getFutureYear() {
        return LocalDate.now().plusYears(faker.number().numberBetween(6, 20)).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getThreeDigitsYear() {
        return ("333");
    }

    public static String getOneDigitsYear() {
        return faker.numerify("#");
    }

    public static String getLettersYear() {
        return faker.letterify("##");
    }

    public static String getSymbolYear() {
        return ("=/");
    }

    public static String getEmptyYear() {
        return ("");
    }

    //Владелец
    public static String getRandomName() {
        return faker.name().fullName();
    }

    public static String getRandomRusName() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().fullName();
    }

    public static String getDigitName() {
        return faker.numerify("#");
    }

    public static String getSymbolName() {
        return ("/");
    }

    public static String get65LettersName() {
        return ("English texts for beginners to practice reading and comprehension");
    }

    public static String getDoubleSurnameName() {
        return ("Ivanov-Ivanov Ivan");
    }

    public static String getEmptyName() {
        return ("");
    }

    //CVC
    public static String getValidCVC() {
        return faker.numerify("###");
    }

    public static String getOneDigitCVC() {
        return faker.numerify("#");
    }

    public static String getFourDigitCVC() {
        return faker.numerify("####");
    }

    public static String getLettersCVC() {
        return faker.letterify("###");
    }

    public static String getSymbolCVC() {
        return ("=/]");
    }

    public static String getEmptyCVC() {
        return ("");
    }

    @Value
    public static class UserInfo {
        String cardNumber;
        String month;
        String year;
        String name;
        String cvc;
    }
}