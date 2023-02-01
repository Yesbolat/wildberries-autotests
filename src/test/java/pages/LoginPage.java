package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement

            login = $(".navbar-pc__icon--profile"),
            phoneInput = $(".input-item"),
            requestCodeButton = $("#requestCode"),
            captchaImage = $(".form-block__captcha-img");


    @Step("Open login page'")
    public LoginPage  openLoginPage() {
        login.click();

        return this;
    }

    @Step("Enter phone number")
    public LoginPage inputPhoneNumber() {
        phoneInput.click();
        phoneInput.setValue("77079207040");

        return this;
    }

    @Step("Get an OTP code")
    public LoginPage getRequestCode() {
        requestCodeButton.click();

        return this;
    }

    @Step("Check that captcha has appeared")
    public LoginPage checkCaptcha() {
        captchaImage.shouldBe(visible);

        return this;
    }
}
