package clean.project.gui.google.executor;

import clean.project.gui.contract.SeleniumActorI;

import java.util.List;
import java.util.Map;

import static clean.project.gui.contract.SeleniumBrowserType.FIREFOX;

public class GoogleSeleniumStepFirefox extends AbstractGoogleSeleniumStep {
    public GoogleSeleniumStepFirefox(String pageName, String targetName, List<Map<String, String>> actionSequence) {
        super(pageName, targetName, actionSequence);
        if (null == seleniumActor) {
            seleniumActor = (SeleniumActorI) guiFactoryBuilder.buildSeleniumActorFactory(FIREFOX.name()).get();
        }
    }
}
