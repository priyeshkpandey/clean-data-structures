package clean.project.gui.factory;

import clean.project.gui.contract.Actor;
import clean.project.gui.contract.SeleniumActorI;
import clean.project.gui.contract.SeleniumBrowserType;
import clean.project.gui.impl.ChromeSeleniumActor;
import clean.project.gui.impl.FirefoxSeleniumActor;
import clean.project.gui.impl.HeadlessChromeSeleniumActor;
import clean.project.gui.interceptor.ActorHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Proxy;

public class SeleniumActorFactory implements Factory<Actor<WebElement, By>> {

    private SeleniumActorI seleniumActor;
    private SeleniumBrowserType seleniumBrowserType;

    @Override
    public Actor<WebElement, By> get() {
        if (null == seleniumActor) {
            init();
        }
        return seleniumActor;
    }

    public void setSeleniumBrowserType(final String actorType) {
        seleniumBrowserType = SeleniumBrowserType.valueOf(actorType.toUpperCase());
    }

    private void init() {
        switch (seleniumBrowserType) {
            case HEADLESS_CHROME: this.seleniumActor = (SeleniumActorI) Proxy.newProxyInstance(HeadlessChromeSeleniumActor.class.getClassLoader(),
                    new Class[] {SeleniumActorI.class}, new ActorHandler(new HeadlessChromeSeleniumActor()));
                break;
            case CHROME: this.seleniumActor = (SeleniumActorI) Proxy.newProxyInstance(ChromeSeleniumActor.class.getClassLoader(),
                    new Class[] {SeleniumActorI.class}, new ActorHandler(new ChromeSeleniumActor()));
                break;
            case FIREFOX: this.seleniumActor = (SeleniumActorI) Proxy.newProxyInstance(FirefoxSeleniumActor.class.getClassLoader(),
                    new Class[] {SeleniumActorI.class}, new ActorHandler(new FirefoxSeleniumActor()));
            break;
            default: throw new RuntimeException("No ActorType for selenium is set");
        }
    }
}

