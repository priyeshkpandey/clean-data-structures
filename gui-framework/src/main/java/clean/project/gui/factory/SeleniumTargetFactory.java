package clean.project.gui.factory;

import clean.project.gui.contract.Target;
import clean.project.gui.impl.SeleniumTarget;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SeleniumTargetFactory implements Factory<Target<WebElement, By>> {
    @Override
    public Target<WebElement, By> get() {
        return new SeleniumTarget();
    }
}
