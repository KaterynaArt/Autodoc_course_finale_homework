package testsToCheckAuthorization;
import init.InitialSelenide;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import logic.MainPageLogic;
import org.testng.Assert;
import org.testng.annotations.Test;
public class TestErrorMessageDisplayedOnEmptyPassword extends InitialSelenide {
    final String EXPECTED_ERROR_EMPTY_PASSWORD = "Enter your password";
    final String EMAIL = "gbpr495@gmail.com";

    @Test
    @Owner("Kate")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test checking authorization with empty password")

    public void testErrorMessageDisplayedOnEmptyPassword() {

        String actualMessage = new MainPageLogic().openAmazon()
                .changeCFCookie()
                .makeSignInPopupVisible()
                .openSignInPopup()
                .enterEmailAndSubmit(EMAIL)
                .goWithoutPassword()
                .getErrorMessageValidation();
        Assert.assertEquals(EXPECTED_ERROR_EMPTY_PASSWORD,actualMessage);

        Assert.assertTrue(true);
    }
}