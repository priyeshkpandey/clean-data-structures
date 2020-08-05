package clean.project.gui.factory;

import org.openqa.selenium.By;

public class SeleniumSelectorFactory implements Factory<By> {

    private By by;

    @Override
    public By get() {
        return by;
    }

    public SeleniumSelectorFactory byId(final String id) {
        by = By.id(id);
        return this;
    }

    public SeleniumSelectorFactory byName(final String name) {
        by = By.name(name);
        return this;
    }

    public SeleniumSelectorFactory byXpath(final String xpath) {
        by = By.xpath(xpath);
        return this;
    }

    public SeleniumSelectorFactory byCSSSelector(final String cssSelector) {
        by = By.cssSelector(cssSelector);
        return this;
    }

    public SeleniumSelectorFactory byLinkText(final String linkText) {
        by = By.linkText(linkText);
        return this;
    }
}
