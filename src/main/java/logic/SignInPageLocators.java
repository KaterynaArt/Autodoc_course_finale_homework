package logic;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
public class SignInPageLocators {
    final SelenideElement email_input_locator = $(By.id("ap_email"));
    final SelenideElement btn_submit_locator = $(By.id("continue"));
    final SelenideElement password_input_locator = $(By.id("ap_password"));
    final SelenideElement signInSubmit_btn_locator = $(By.id("signInSubmit"));
    final SelenideElement error_message = $(By.id("auth-error-message-box"));
    final SelenideElement error_message_validation = $(By.id("auth-password-missing-alert"));
    final SelenideElement user_greeting = $(By.id("nav-link-accountList-nav-line-1"));

}
