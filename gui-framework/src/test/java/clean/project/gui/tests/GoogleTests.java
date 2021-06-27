package clean.project.gui.tests;

import clean.project.gui.contract.SeleniumBrowserType;
import clean.project.gui.google.scenarios.GoogleSearchScenario;
import org.testng.annotations.Test;

public class GoogleTests {

    @Test(groups = {"Google"}, description = "Verify Google search with headless Chrome")
    public void verifyGoogleWithHeadlessChrome() throws Exception {
        final GoogleSearchScenario googleSearchScenario = new GoogleSearchScenario(SeleniumBrowserType.HEADLESS_CHROME);
        googleSearchScenario.googleSearchFor("selenium");
    }

    @Test(groups = {"Google"}, description = "Verify Google search with headless Chrome on Docker")
    public void verifyGoogleWithHeadlessChromeOnDocker() throws Exception {
        final GoogleSearchScenario googleSearchScenario = new GoogleSearchScenario(SeleniumBrowserType.HEADLESS_CHROME_DOCKER);
        googleSearchScenario.googleSearchFor("selenium");
    }

    @Test(groups = {"Google"}, description = "Verify Google search with Chrome")
    public void verifyGoogleWithChrome() throws Exception {
        final GoogleSearchScenario googleSearchScenario = new GoogleSearchScenario(SeleniumBrowserType.CHROME);
        googleSearchScenario.googleSearchFor("selenium");
    }

    @Test(groups = {"Google"}, description = "Verify Google search with Firefox")
    public void verifyGoogleWithFirefox() throws Exception {
        final GoogleSearchScenario googleSearchScenario = new GoogleSearchScenario(SeleniumBrowserType.FIREFOX);
        googleSearchScenario.googleSearchFor("selenium");
    }
}
