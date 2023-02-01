package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

        private SelenideElement

                logo = $("#goMain"),
                searchInput = $("#searchInput"),
                searchResults = $(".page__heading"),

                currencyList = $("#curBtn"),

                currencyTenge = $(withText("Казахстанский тенге"));


        @Step("Open main page")
        public MainPage openMainPage() {
                open("https://global.wildberries.ru");

            return this;
        }

        @Step("Check logo")
        public MainPage  checkLogo() {
            logo.shouldBe(visible);

            return this;
        }

        @Step("Search for an item")
        public MainPage  inputSearchItem(String testData) {
            searchInput.click().setValue(testData).pressEnter();

            return this;
        }

        @Step("Check search results")
        public MainPage  checkSearchResults(String expectedResult) {
            searchResults.shouldHave(text(expectedResult));

            return this;
        }

        @Step("Choose currency tenge")
        public MainPage  chooseCurrency() {
            currencyList.click();
            currencyTenge.click();

            return this;
        }

        @Step("Check change of curency")
        public MainPage  checkCurrencyChange() {
            currencyList.shouldHave(text("KZT"));

            return this;
        }
    }

