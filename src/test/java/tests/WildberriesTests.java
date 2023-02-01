package tests;

import pages.CartPage;
import pages.LoginPage;
import pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;


public class WildberriesTests extends TestBase {

    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    CartPage cartPage = new CartPage();

    @Test
    @DisplayName("Checking the logo")
    void logoTest() {
        mainPage.
                openMainPage().
                checkLogo();
    }

    @Test
    @DisplayName("Checking currency change")
    void currencyChangeTest() {
        mainPage.
                openMainPage().
                chooseCurrency().
                checkCurrencyChange();
    }

    static Stream<Arguments> commonSearchDataProvider() {
        return Stream.of(
                Arguments.of("Часы", "По запросу «часы» найдено"),
                Arguments.of("Джинсы", "По запросу «джинсы» найдено"));
    }

    @MethodSource("commonSearchDataProvider")
    @ParameterizedTest(name = "Searching for items {0} and checking the display of text {0} in the search results")
    @DisplayName("Checking search of items")
    void searchAndCheckProductTest(String testData, String expectedResult) {
        mainPage.
                openMainPage().
                inputSearchItem(testData).
                checkSearchResults(expectedResult);
    }

    @Test
    @DisplayName("Checking captcha after entering a phone number")
    void captchaAppearsTest() {
        mainPage.
                openMainPage();
        loginPage.
                openLoginPage().
                inputPhoneNumber().
                getRequestCode().
                checkCaptcha();
    }

    @Test
    @DisplayName("Checking addition and removal of an item from cart")
    void addAndRemoveProductFromCartTest() {
        mainPage.
                openMainPage();
        cartPage.
                inputArticle().
                checkArticleResult().
                addItemToCart().
                openCartPage().
                checkAddedItem().
                removeItemFromCart().
                checkCartIsEmpty();
    }
}

