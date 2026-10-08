package pages;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utils.LocatorUtility;

public class LoginPage {

    Page page;
    Locator registerLink ;
    LocatorUtility locator;

    public LoginPage(Page page){
        this.page = page;
        locator= new LocatorUtility(page);
        registerLink = locator.getLinkByText("Register");
    }

    public void clickRegister() {
        registerLink.click();
    }
}
