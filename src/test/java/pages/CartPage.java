package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private SelenideElement

            cart = $(".navbar-pc__icon--basket"),
            searchInput = $("#searchInput"),
            resultsHeader = $(".same-part-kt"),
            addToCartButton = $(".btn-main"),
            cartSection = $(".basket-page"),
            deleteButton = $(".btn__del");

    @Step("Enter item's article number")
    public CartPage inputArticle() {
        searchInput.click().setValue("40906848").pressEnter();

        return this;
    }

    @Step("Check search result")
    public CartPage checkArticleResult() {
        resultsHeader.shouldHave(text("Оригинальные мужские наручные часы Emporio Armani"));

        return this;
    }

    @Step("Add item to cart")
    public CartPage addItemToCart() {
        addToCartButton.click();
        Selenide.sleep(1000);

        return this;
    }

    @Step("Open cart page")
    public CartPage openCartPage() {
        cart.click();

        return this;
    }

    @Step("Check added item to cart")
    public CartPage checkAddedItem() {
        cartSection.shouldHave(text("Оригинальные мужские наручные часы Emporio Armani"));

        return this;
    }

    @Step("Remove item from cart")
    public CartPage removeItemFromCart() {
        deleteButton.click();

        return this;
    }

    @Step("Check empty cart")
    public CartPage checkCartIsEmpty() {
        cartSection.shouldHave(text("В корзине пока ничего нет"));

        return this;
    }
}
