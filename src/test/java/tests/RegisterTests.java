package tests;

import base.BaseTest;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.impl.LocatorUtils;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;
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

    @Test
    public void registerTest() throws InterruptedException {
        context = browser.newContext();
        Page page = context.newPage();
        locator = new LocatorUtility(page);
        registerPage = new RegisterPage(page);
        loginPage = new LoginPage(page);

        page.navigate(ConfigReader.getProperty("baseurl"));
        locator.takeScreenshot("loadPage.png");

        loginPage.clickRegister();

        assertThat(page).hasTitle(Pattern.compile("ParaBank | Register for Free Online Account Access"));

        locator.takeScreenshot("registerClick.png");

        String username = "test_user_" + ThreadLocalRandom.current().nextInt(2345, 2345678);
        registerPage.registerUser("test_fname", "test_lname", "test23234", "test_city",
                "test_state", "test_pin",
                "test_phone", "test_ssn",
                username, username, username);

        assertThat(locator.getElementWithText("Your account was created successfully. You are now logged in.")).isVisible();
        locator.takeScreenshot("accountCreated.png");
        String registrationTitle = locator.getElementByAttribute("class", "title").innerText();
        System.out.println("title is : " + registrationTitle);
        assertThat(locator.getElementWithText("Welcome " + username)).isVisible();

    }

}
