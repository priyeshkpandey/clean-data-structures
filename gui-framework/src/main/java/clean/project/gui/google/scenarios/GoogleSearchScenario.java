package clean.project.gui.google.scenarios;

import clean.project.gui.contract.SeleniumBrowserType;
import clean.project.gui.contract.Step;
import clean.project.gui.google.executor.GoogleStepFactory;
import org.openqa.selenium.Keys;

import java.util.Arrays;
import java.util.Map;

import static clean.project.gui.contract.TargetAction.*;
import static clean.project.gui.google.pages.GooglePageElementNames.SearchPage.QUERY_TEXT;

public class GoogleSearchScenario extends AbstractGoogleScenario {
    private static final String SEARCH_PAGE_NAME = "Search";
    private GoogleStepFactory googleSearchPageStepFactory;
    public GoogleSearchScenario(SeleniumBrowserType seleniumBrowserType) {
        super(seleniumBrowserType);
        this.googleSearchPageStepFactory = getGoogleStepFactory().setPageName(SEARCH_PAGE_NAME);
    }

    public void googleSearchFor(final String queryText) throws Exception {
        final Map<String, String> openUrlAction = getActionMap(OPEN, "https://www.google.com/");
        final Map<String, String> enterQueryAction = getActionMap(ENTER, queryText);
        final Map<String, String> keyboardEnter = getActionMap(KEYBOARD, Keys.ENTER.name());
        final Map<String, String> closeAction = getActionMap(CLOSE, null);
        final Step searchStep = this.googleSearchPageStepFactory
                .setTargetName(QUERY_TEXT)
                .setActionSequence(Arrays.asList(openUrlAction, enterQueryAction, keyboardEnter, closeAction))
                .get();
        getExecutor().execute(Arrays.asList(searchStep));
    }
}
