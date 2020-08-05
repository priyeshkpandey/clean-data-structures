package clean.project.gui.google.executor;

import clean.project.gui.contract.SeleniumActorI;
import clean.project.gui.contract.Step;
import clean.project.gui.factory.GUIFactoryBuilder;
import clean.project.gui.google.pages.AbstractGooglePage;
import clean.project.gui.impl.SeleniumDriver;
import clean.project.gui.impl.SeleniumTarget;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class AbstractGoogleSeleniumStep implements Step {
    protected static GUIFactoryBuilder guiFactoryBuilder = new GUIFactoryBuilder();
    private static final String GOOGLE_PAGES_PACKAGE = "clean.project.gui.google.pages.";
    private static final String PAGE_PREFIX = "Google";
    private static final String PAGE_SUFFIX = "Page";
    private static final Map<String, AbstractGooglePage> pageMap = new HashMap<>();

    private AbstractGooglePage page;
    private static SeleniumDriver seleniumDriver;
    protected static SeleniumActorI seleniumActor;

    private String pageName;
    private String targetName;
    private List<Map<String, String>> actionSequence;

    public AbstractGoogleSeleniumStep(final String pageName, final String targetName, final List<Map<String, String>> actionSequence) {
        this.pageName = pageName;
        this.targetName = targetName;
        this.actionSequence = actionSequence;
    }

    @Override
    public void execute() throws Exception {
        System.out.println(String.format("Executing steps for: page -> %s, target -> %s", this.pageName, this.targetName));
        if (null == seleniumDriver) {
            seleniumDriver = (SeleniumDriver) guiFactoryBuilder.buildSeleniumDriverFactory().get();
        }
        initInstanceOfPageByName(pageName);
        final SeleniumTarget target = (SeleniumTarget) this.page.get(targetName);
        seleniumDriver.bind(seleniumActor, target);
        addAllSteps(actionSequence);
        if (!seleniumDriver.perform()) {
            throw new Exception("Step failed, skipping further execution");
        }
    }

    private void initInstanceOfPageByName(final String page) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println("Initializing with page " + page);
        if (pageMap.containsKey(page)) {
            this.page = pageMap.get(page);
            return;
        }
        System.out.println(String.format("Page %s not found in the map, creating new", page));
        Class classInstance = Class.forName(GOOGLE_PAGES_PACKAGE + PAGE_PREFIX + page + PAGE_SUFFIX);
        this.page = (AbstractGooglePage) classInstance.getConstructor().newInstance();
        pageMap.put(page, this.page);
    }

    private void addAllSteps(final List<Map<String, String>> actionSequence) {
        seleniumDriver.clearActions();
        for (Map<String, String> action : actionSequence) {
            String actionName = null;
            Iterator<String> keyIter = action.keySet().iterator();
            while (keyIter.hasNext()) {
                actionName = keyIter.next();
            }
            System.out.println("Adding action " + actionName);
            seleniumDriver.addAction(actionName, action.get(actionName));
        }
    }
}
