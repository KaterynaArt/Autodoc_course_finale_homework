package logic;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import java.time.Duration;

public class SignInPageLogic extends SignInPageLocators{

    @Step("enterEmailAndSubmit")
    public SignInPageLogic enterEmailAndSubmit(String email){
        email_input_locator.shouldBe(Condition.visible, Duration.ofSeconds(15)).setValue(email);
        btn_submit_locator.click();
        return this;
    }
    @Step("enterPasswordAndSubmit")
    public SignInPageLogic enterPasswordAndSubmit(String password){
        password_input_locator.shouldBe(Condition.visible, Duration.ofSeconds(15)).setValue(password);
        signInSubmit_btn_locator.click();
        return this;
    }
    @Step("getErrorMessage_Incorrect_Email")
    public String getErrorMessage (){
        return error_message.shouldBe(Condition.visible,Duration.ofSeconds(15)).getText();
    }
    @Step("getUserGreeting")
    public String getUserGreeting(){
        return user_greeting.shouldBe(Condition.appear).getText();
    }
    @Step("goWithoutPassword")
    public SignInPageLogic goWithoutPassword(){
        signInSubmit_btn_locator.click();
        return this;
    }
    @Step("getErrorMessageValidation_Enter_Password")
    public String getErrorMessageValidation (){
        return error_message_validation.shouldBe(Condition.visible,Duration.ofSeconds(15)).getText();
    }
}
