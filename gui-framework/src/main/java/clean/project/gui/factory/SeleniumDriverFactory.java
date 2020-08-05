package clean.project.gui.factory;

import clean.project.gui.contract.Driver;
import clean.project.gui.impl.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SeleniumDriverFactory implements Factory<Driver<WebElement, By>>{
    @Override
    public Driver<WebElement, By> get() {
        return new SeleniumDriver();
    }
}
