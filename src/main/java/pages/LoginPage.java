package pages;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utils.LocatorUtility;

public class LoginPage {

    Page page;
    Locator registerLink, usernameInput, passwordInput, loginButton;
    LocatorUtility locator;

    public LoginPage(Page page) {
        this.page = page;
        locator = new LocatorUtility(page);
        registerLink = locator.getLinkByText("Register");
        usernameInput = locator.getElementByAttribute("name", "username");
        passwordInput = locator.getElementByAttribute("name", "password");
        loginButton = locator.getElementByAttribute("value", "Log In");
    }

    public void clickRegister() {
        registerLink.click();
    }

    public void login(String username, String password) {
        usernameInput.fill(username);
        passwordInput.fill(password);
        loginButton.click();
    }

}
