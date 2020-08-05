package clean.project.gui.impl;

import clean.project.gui.contract.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SeleniumTarget implements Target<WebElement, By> {

    private WebElement element;
    private By by;
    private String pageName;

    @Override
    public void setElement(WebElement element) {
        this.element = element;
    }

    @Override
    public WebElement getElement() {
        return this.element;
    }

    @Override
    public void setSelector(By selector) {
        this.by = selector;
    }

    @Override
    public By getSelector() {
        return this.by;
    }

    @Override
    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    @Override
    public String getPageName() {
        return this.pageName;
    }
}
