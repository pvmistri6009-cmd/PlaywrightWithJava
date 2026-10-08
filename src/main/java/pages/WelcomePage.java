package pages;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utils.LocatorUtility;

public class WelcomePage {

    Page page;
    Locator logoutLink;
    LocatorUtility locator;

    public WelcomePage(Page page) {
        this.page = page;
        locator = new LocatorUtility(page);
        logoutLink = locator.getLinkByText("Log Out");
    }

    public void logout() {
        logoutLink.click();
    }


}
