package clean.project.gui.google.executor;

import clean.project.gui.contract.SeleniumBrowserType;
import clean.project.gui.factory.Factory;

import java.util.List;
import java.util.Map;

public class GoogleStepFactory implements Factory<AbstractGoogleSeleniumStep> {
    private SeleniumBrowserType seleniumBrowserType;
    private String pageName;
    private String targetName;
    private List<Map<String, String>> actionSequence;

    @Override
    public AbstractGoogleSeleniumStep get() {
        switch (this.seleniumBrowserType) {
            case HEADLESS_CHROME: return new GoogleSeleniumStepHeadlessChrome(this.pageName, this.targetName, this.actionSequence);
            case CHROME: return new GoogleSeleniumStepChrome(this.pageName, this.targetName, this.actionSequence);
            case FIREFOX: return new GoogleSeleniumStepFirefox(this.pageName, this.targetName, this.actionSequence);
            default : throw new RuntimeException("No such step type defined");
        }
    }
    public GoogleStepFactory setSeleniumBrowserType(final SeleniumBrowserType seleniumBrowserType) {
        this.seleniumBrowserType = seleniumBrowserType;
        return this;
    }

    public GoogleStepFactory setPageName(final String pageName) {
        this.pageName = pageName;
        return this;
    }

    public GoogleStepFactory setTargetName(final String targetName) {
        this.targetName = targetName;
        return this;
    }

    public GoogleStepFactory setActionSequence(final List<Map<String, String>> actionSequence) {
        this.actionSequence = actionSequence;
        return this;
    }
}
