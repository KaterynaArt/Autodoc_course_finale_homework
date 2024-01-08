package testsToCheckAuthorization;
import init.InitialSelenide;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import logic.MainPageLogic;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestErrorMessageDisplayedWithIncorrectEmail extends InitialSelenide {


    final String EXPECTED_ERROR_MESSAGE = "There was a problem\n" +
            "We cannot find an account with that email address";
    final String INCORRECT_EMAIL = "test.email.com";

    @Test
    @Owner("Kate")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test checking authorization with incorrect email")
    public void testAuthorizationWithIncorrectEmail(){

        String actualMessage = new MainPageLogic().openAmazon()
                .changeCFCookie()
                .makeSignInPopupVisible()
                .openSignInPopup()
                .enterEmailAndSubmit(INCORRECT_EMAIL)
                .getErrorMessage();
        Assert.assertEquals(EXPECTED_ERROR_MESSAGE,actualMessage);

        Assert.assertTrue(true);


    }
}