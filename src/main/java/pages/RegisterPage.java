package pages;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utils.LocatorUtility;

public class RegisterPage {

    Page page;
    LocatorUtility locator;

    Locator registerLink, fnameInput, lnameInput,registerButton;
    Locator streetInput, cityInput, stateInput, zipcodeInput;
    Locator phonenumberInput, ssnInput, usernameInput, passwordInput, repeatPwdInput;


    public RegisterPage(Page page) {
        this.page = page;
        locator = new LocatorUtility(page);

        //initialize elements
        registerButton = locator.getElementByAttribute("value", "Register");
        fnameInput = locator.getElementByAttribute("id", "customer.firstName");
        lnameInput = locator.getElementByAttribute("id", "customer.lastName");
        streetInput = locator.getElementByAttribute("id", "customer.address.street");
        cityInput = locator.getElementByAttribute("id", "customer.address.city");
        stateInput = locator.getElementByAttribute("id", "customer.address.state");
        zipcodeInput = locator.getElementByAttribute("id", "customer.address.zipCode");
        phonenumberInput = locator.getElementByAttribute("id", "customer.phoneNumber");
        ssnInput = locator.getElementByAttribute("id", "customer.ssn");
        usernameInput = locator.getElementByAttribute("id", "customer.username");
        passwordInput = locator.getElementByAttribute("id", "customer.password");
        repeatPwdInput = locator.getElementByAttribute("id", "repeatedPassword");
    }



    public void registerUser(String fname, String lname, String streetval, String city, String state, String pin, String phone, String ssn,
                             String username, String pwd, String rpwd) {
        fnameInput.fill(fname);
        lnameInput.fill(lname);
        streetInput.fill(streetval);
        cityInput.fill(city);
        stateInput.fill(state);
        zipcodeInput.fill(pin);
        phonenumberInput.fill(phone);
        ssnInput.fill(ssn);
        usernameInput.fill(username);
        passwordInput.fill(pwd);
        repeatPwdInput.fill(rpwd);
        registerButton.click();
    }

}
