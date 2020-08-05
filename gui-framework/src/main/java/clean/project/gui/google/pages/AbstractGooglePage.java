package clean.project.gui.google.pages;

import clean.project.gui.contract.Page;
import clean.project.gui.factory.GUIFactoryBuilder;
import clean.project.gui.factory.SeleniumSelectorFactory;
import clean.project.gui.factory.SeleniumTargetFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class AbstractGooglePage implements Page<WebElement, By> {
    private static GUIFactoryBuilder guiFactoryBuilder = new GUIFactoryBuilder();
    private SeleniumSelectorFactory seleniumSelectorFactory;
    private SeleniumTargetFactory seleniumTargetFactory;

    public AbstractGooglePage() {
        seleniumSelectorFactory = guiFactoryBuilder.buildSeleniumSelectorFactory();
        seleniumTargetFactory = guiFactoryBuilder.buildSeleniumTargetFactory();
    }

    protected SeleniumSelectorFactory getSeleniumSelectorFactory() {
        return seleniumSelectorFactory;
    }

    protected SeleniumTargetFactory getSeleniumTargetFactory() {
        return seleniumTargetFactory;
    }
}
