package tests;

import base.BaseTest;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import dataproviders.TestDataProvider;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;
import utils.ConfigReader;
import utils.LocatorUtility;

import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTests extends BaseTest {

    BrowserContext context;
    LocatorUtility locator;
    LoginPage loginPage;


//    @Test(priority = 2, dataProviderClass = TestDataProvider.class, dataProvider = "loginData")
    public void loginTest(String username, String password) throws InterruptedException {
        context = browser.newContext();
        Page page = context.newPage();
        locator = new LocatorUtility(page);
        loginPage = new LoginPage(page);

        page.navigate(ConfigReader.getProperty("baseurl"));
        locator.takeScreenshot("login_test_loadPage.png");

//        //enter credentials to login
//        System.out.println(">>>>> "+username);
//        loginPage.login(username, password);
//
//        assertThat(locator.getElementWithText("Accounts Overview")).isVisible();
//        assertThat(locator.getElementById("accountTable")).isVisible();

    }

}
