package tests;

import base.BaseTest;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.impl.LocatorUtils;
import com.microsoft.playwright.options.AriaRole;
import dataproviders.TestDataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;
import pages.WelcomePage;
import utils.ConfigReader;
import utils.LocatorUtility;

import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class RegisterTests extends BaseTest {

    BrowserContext context;
    LocatorUtility locator;
    RegisterPage registerPage;
    LoginPage loginPage;
    WelcomePage welcomePage;

    @Test(priority = 1, dataProviderClass = TestDataProvider.class, dataProvider = "registerData")
    public void registerAndLoginTest(String username, String password) {
        context = browser.newContext();
        Page page = context.newPage();
        locator = new LocatorUtility(page);
        registerPage = new RegisterPage(page);
        loginPage = new LoginPage(page);
        welcomePage = new WelcomePage(page);

        page.navigate(ConfigReader.getProperty("baseurl"));
        locator.takeScreenshot("loadPage.png");

        loginPage.clickRegister();

        assertThat(page).hasTitle(Pattern.compile("ParaBank | Register for Free Online Account Access"));

        locator.takeScreenshot("registerClick.png");

        registerPage.registerUser("test_fname", "test_lname", "test23234", "test_city",
                "test_state", "test_pin",
                "test_phone", "test_ssn",
                username, password, password);

        assertThat(locator.getElementWithText("Your account was created successfully. You are now logged in.")).isVisible();
        locator.takeScreenshot("accountCreated.png");
        String registrationTitle = locator.getElementByAttribute("class", "title").innerText();
        System.out.println("title is : " + registrationTitle);
        assertThat(locator.getElementWithText("Welcome " + username)).isVisible();


        //logout and login again to see if user session gets created
        welcomePage.logout();
        locator.takeScreenshot("userloggedout.png");

        //verify user is on login page again
        assertThat(locator.getElementWithText("Customer Login")).isVisible();

        //login with same user
        loginPage.login(username, password);
        locator.takeScreenshot("userLoggedin.png");
        assertThat(locator.getElementById("accountTable")).isVisible();
    }

}
