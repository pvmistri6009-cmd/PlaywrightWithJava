package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

import java.nio.file.Paths;

public class BaseTest {

    static Playwright playwright;
    protected static Browser browser;

    @BeforeMethod
    public void setup() {
        System.out.println("Inside before method..");
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Inside after method..");
        if (browser == null)
            browser.close();
        if (playwright == null)
            playwright.close();
    }


}
