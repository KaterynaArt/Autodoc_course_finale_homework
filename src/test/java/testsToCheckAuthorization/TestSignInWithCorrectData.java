package testsToCheckAuthorization;
import init.InitialSelenide;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import logic.MainPageLogic;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestSignInWithCorrectData extends InitialSelenide {

    private final String EXPECTED_USER_GREETING = "Hello, Kate";

    @Test(dataProvider = "AuthorizationData")
    @Owner("Kate")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test checking authorization with correct data")
    public void testSignInWithCorrectData(String email, String password) {
        String userGreeting = new MainPageLogic().openAmazon()
                .changeCFCookie()
                .makeSignInPopupVisible()
                .openSignInPopup()
                .enterEmailAndSubmit(email)
                .enterPasswordAndSubmit(password)
                .getUserGreeting();
        Assert.assertEquals(userGreeting, EXPECTED_USER_GREETING);
    }
    @DataProvider(name = "AuthorizationData")
    private Object[][] authorizationData() {
        return new Object[][]{
                {"gbpr495@gmail.com", "gfhjkm"},
        };
    }
}