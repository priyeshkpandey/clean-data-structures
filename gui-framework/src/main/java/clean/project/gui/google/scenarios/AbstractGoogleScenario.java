package clean.project.gui.google.scenarios;

import clean.project.gui.contract.Executor;
import clean.project.gui.contract.SeleniumBrowserType;
import clean.project.gui.contract.TargetAction;
import clean.project.gui.google.executor.GoogleStepFactory;
import clean.project.gui.impl.CommonExecutor;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractGoogleScenario {

    private SeleniumBrowserType seleniumBrowserType;
    private Executor executor;
    private final GoogleStepFactory googleStepFactory = new GoogleStepFactory();

    public AbstractGoogleScenario(final SeleniumBrowserType seleniumBrowserType) {
        this.seleniumBrowserType = seleniumBrowserType;
        this.executor = new CommonExecutor();
    }

    protected Executor getExecutor() {
        return this.executor;
    }

    protected GoogleStepFactory getGoogleStepFactory() {
        return this.googleStepFactory.setSeleniumBrowserType(this.seleniumBrowserType);
    }

    protected Map<String, String> getActionMap(final TargetAction action, final String param) {
        Map<String, String> actionMap = new HashMap<>();
        actionMap.put(action.name(), param);
        return actionMap;
    }
}
