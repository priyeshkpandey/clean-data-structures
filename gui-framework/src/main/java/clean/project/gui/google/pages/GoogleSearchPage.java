package clean.project.gui.google.pages;

import clean.project.gui.contract.Target;
import clean.project.gui.impl.SeleniumTarget;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static clean.project.gui.google.pages.GooglePageElementNames.SearchPage.QUERY_TEXT;
import static clean.project.gui.google.pages.GooglePageElementNames.SearchPage.SEARCH_BUTTON;

public class GoogleSearchPage extends AbstractGooglePage {
    private static final String PAGE_NAME = "GoogleSearchPage";
    @Override
    public Target<WebElement, By> get(String targetName) throws Exception {
        switch (targetName) {
            case QUERY_TEXT: return getQueryText();
            case SEARCH_BUTTON: return getSearchButton();
            default : throw new Exception("No such target in the page");
        }
    }

    private SeleniumTarget getQueryText() {
        final By by = getSeleniumSelectorFactory().byName("q").get();
        final SeleniumTarget queryText = (SeleniumTarget) getSeleniumTargetFactory().get();
        queryText.setPageName(PAGE_NAME);
        queryText.setSelector(by);
        return queryText;
    }

    private SeleniumTarget getSearchButton() {
        final By by = getSeleniumSelectorFactory().byXpath("//input[@label='Google Search']").get();
        final SeleniumTarget searchButton = (SeleniumTarget) getSeleniumTargetFactory().get();
        searchButton.setPageName(PAGE_NAME);
        searchButton.setSelector(by);
        return searchButton;
    }
}
