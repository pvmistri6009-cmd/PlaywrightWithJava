package utils;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class LocatorUtility {

    private final Page page;

    // Constructor to pass the active Playwright Page instance
    public LocatorUtility(Page page) {
        this.page = page;
    }

    /**
     * Take a screenshot and save it in target/screenshots path
     * @param name
     */
    public void takeScreenshot(String name){
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("target/screenshots/"+name))
                .setFullPage(true));
    }

    /**
     * Finds a link by its exact visible text.
     */
    public Locator getLinkByText(String text) {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(text).setExact(true));
    }

    /**
     * Finds an elemnt by its ID and enter value in it
     */
    public Locator getElementByAttribute(String attr, String value) {
        String selector = String.format("[%s='%s']", attr, value);
        return page.locator(selector);
    }

    /**
     * Finds an elemnt by its ID and enter value in it
     */
    public Locator getElementById(String id) {
        return page.locator("#" + id);
    }

    /**
     * Finds a button by its exact visible text.
     */
    public Locator getButtonByText(String text) {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(text).setExact(true));
    }

    /**
     * Finds an input field (textbox) by its placeholder text.
     */
    public Locator getInputByPlaceholder(String placeholder) {
        return page.getByPlaceholder(placeholder);
    }

    /**
     * Finds an input field by its associated <label> text.
     */
    public Locator getInputByLabel(String labelText) {
        return page.getByLabel(labelText);
    }

    /**
     * Finds any element containing specific text (Partial match).
     */
    public Locator getElementWithText(String text) {
        return page.getByText(text, new Page.GetByTextOptions().setExact(false));
    }

    /**
     * Fallback for standard CSS selectors or XPaths.
     */
    public Locator getByCssOrXpath(String selector) {
        return page.locator(selector);
    }
}