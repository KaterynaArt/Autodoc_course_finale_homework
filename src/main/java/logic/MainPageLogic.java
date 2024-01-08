package logic;


import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class MainPageLogic extends MainPageLocators {

    final String URL = "https://www.amazon.com/";

    final String AMZ_CAPTCHA1 = "1703696784017600";
    final String AMZ_CAPTCHA2 = "87ImkDzlbwltraqnNDQqMg==";
    final String CSM_HIT = "tb:GJ1SPAWSFV8JGMDTWEPK+s-9BF55X2FNFAEGZX97CSS|1704705399078&t:1704705399078&adb:adblk_no";
    final String CP_CDN = "\"L5Z9:UA\"";

    public MainPageLogic changeCFCookie() {
        Cookie cookie = new Cookie("x-amz-captcha-1", AMZ_CAPTCHA1);
        getWebDriver().manage().addCookie(cookie);
        Cookie cookie2 = new Cookie("x-amz-captcha-2", AMZ_CAPTCHA2);
        getWebDriver().manage().addCookie(cookie2);
        Cookie cookie3 = new Cookie("csm-hit", CSM_HIT);
        getWebDriver().manage().addCookie(cookie3);
        Cookie cookie4 = new Cookie("sp-cdn", CP_CDN);
        getWebDriver().manage().addCookie(cookie4);
        getWebDriver().navigate().refresh();
        return this;
    }


    @Step("openAmazon")
    public MainPageLogic openAmazon(){
        open(URL);
        return this;
    }
    @Step("makeSignInPopupVisible")
    public MainPageLogic makeSignInPopupVisible(){
        accountList_link_locator.hover();
        return this;
    }

    @Step("openSignInPopup")
    public SignInPageLogic openSignInPopup() {
        sign_In_Btn_locator.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        return page(SignInPageLogic.class);
    }

}
