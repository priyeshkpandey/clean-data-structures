package clean.project.gui.impl;

import clean.project.gui.contract.SeleniumActorI;
import clean.project.gui.contract.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class AbstractSeleniumActor implements SeleniumActorI {

    protected Target<WebElement, By> target;

    @Override
    public void setTarget(Target<WebElement, By> target) {
        this.target = target;
    }

    @Override
    public void removeTarget() {
        this.target = null;
    }

    @Override
    public Target<WebElement, By> getTarget() {
        return this.target;
    }
}
