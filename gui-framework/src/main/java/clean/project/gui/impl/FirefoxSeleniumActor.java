package clean.project.gui.impl;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class FirefoxSeleniumActor extends AbstractSeleniumActor {
    private static final String OS = System.getProperty("os.name").toLowerCase();
    private static final String FILE_SEPARATOR = System.getProperty("file.separator");
    private static final String FIREFOX_DRIVERS_DIR = "gui-framework" + FILE_SEPARATOR + "exec" + FILE_SEPARATOR + "firefox_drivers" + FILE_SEPARATOR;
    private static final String GECKO_DRIVER_MAC = "geckodriver_mac";
    private static final String GECKO_DRIVER_LINUX = "geckodriver";
    private static final String GECKO_DRIVER_WINDOWS = "geckodriver.exe";
    private static final long TIMEOUT_SECOND = 5;

    private WebDriver driver;

    public FirefoxSeleniumActor() {
        initGeckoDriverLocation();
        this.driver = new FirefoxDriver(getFirefoxOptions());
        this.driver.manage().timeouts().implicitlyWait(TIMEOUT_SECOND, TimeUnit.SECONDS);
    }

    private void initGeckoDriverLocation() {
        if (OS.contains("win")) {
            System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVERS_DIR + GECKO_DRIVER_WINDOWS);
        } else if (OS.contains("mac")) {
            System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVERS_DIR + GECKO_DRIVER_MAC);
        } else {
            System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVERS_DIR + GECKO_DRIVER_LINUX);
        }

    }

    private FirefoxOptions getFirefoxOptions() {
        final FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setAcceptInsecureCerts(true);
        firefoxOptions.addArguments("--enable-javascript");
        return firefoxOptions;
    }
    @Override
    public boolean open(String url) {
        this.driver.get(url);
        this.driver.manage().window().maximize();
        return true;
    }

    @Override
    public boolean enter(String input) {
        try {
            find();
            final WebElement element = this.target.getElement();
            try {
                Keys inputKey = Keys.valueOf(input);
                element.sendKeys(inputKey);
            } catch (IllegalArgumentException ex) {
                System.out.println("Input is not a navigation key, entering as text");
                element.sendKeys(input);
            }
            return true;
        } catch (Exception ex) {
            System.out.println("Exception while performing sendKeys ");
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean click() {
        try {
            find();
            final WebElement element = this.target.getElement();
            element.click();
            return true;
        } catch (Exception ex) {
            System.out.println("Exception while performing click ");
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean submit() {
        try {
            find();
            final WebElement element = this.target.getElement();
            element.submit();
            return true;
        } catch (Exception ex) {
            System.out.println("Exception while submitting the element ");
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean find() {
        try {
            if (null != this.target.getSelector()) {
                final WebElement element = this.driver.findElement(this.target.getSelector());
                this.target.setElement(element);
            }
            return true;
        } catch (Exception ex) {
            System.out.println("Exception while finding the element ");
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean sleep(String timeInMillis) {
        try {
            Thread.sleep(Long.parseLong(timeInMillis));
            return true;
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted");
            return false;
        }
    }

    @Override
    public boolean robot(String action) {
        try {
            final Robot robot = new Robot();
            int keyCode = getKeyEventFromString(action);
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
            return true;
        } catch (IllegalArgumentException | AWTException ex) {
            System.out.println("Exception executing with robot. ");
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean jsClick() {
        try {
            find();
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) this.driver;
            final WebElement element = this.target.getElement();
            javascriptExecutor.executeScript("arguments[0].click()", element);
            return true;
        } catch (Exception ex) {
            System.out.println("Exception executing jsClick. ");
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean jsChange() {
        try {
            find();
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) this.driver;
            final WebElement element = this.target.getElement();
            javascriptExecutor.executeScript("arguments[0].value.change", element);
            return true;
        } catch (Exception ex) {
            System.out.println("Exception executing jsChange. ");
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean clear() {
        try {
            find();
            final WebElement element = this.target.getElement();
            element.clear();
            return true;
        } catch (Exception ex) {
            System.out.println("Exception while performing clear ");
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean keyboard(String action) {
        try {
            final Keys keys = Keys.valueOf(action);
            Actions actionProvider = new Actions(this.driver);
            Action keyboardAction = actionProvider.sendKeys(keys).build();
            keyboardAction.perform();
            return true;
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception while performing keyboard action : " + action + ". ");
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean close() {
        this.driver.close();
        this.driver.quit();
        return true;
    }

    private int getKeyEventFromString(final String action) {
        switch (action) {
            case "ENTER" : return KeyEvent.VK_ENTER;
            case "TAB" : return KeyEvent.VK_TAB;
            default : return -1;
        }
    }
}
