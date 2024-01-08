package logic;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MainPageLocators {
    SelenideElement accountList_link_locator = $(By.id("nav-link-accountList"));
    SelenideElement sign_In_Btn_locator = $x("//div[@id='nav-al-signin']//span");
}
