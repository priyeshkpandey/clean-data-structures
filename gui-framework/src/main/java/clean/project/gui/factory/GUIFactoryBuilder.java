package clean.project.gui.factory;

public class GUIFactoryBuilder {
    public SeleniumDriverFactory buildSeleniumDriverFactory() {
        return new SeleniumDriverFactory();
    }

    public SeleniumTargetFactory buildSeleniumTargetFactory() {
        return new SeleniumTargetFactory();
    }

    public SeleniumActorFactory buildSeleniumActorFactory(final String actorType) {
        final SeleniumActorFactory seleniumActorFactory = new SeleniumActorFactory();
        seleniumActorFactory.setSeleniumBrowserType(actorType);
        return seleniumActorFactory;
    }

    public SeleniumSelectorFactory buildSeleniumSelectorFactory() {
        return new SeleniumSelectorFactory();
    }

}
