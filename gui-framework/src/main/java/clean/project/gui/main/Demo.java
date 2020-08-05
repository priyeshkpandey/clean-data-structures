package clean.project.gui.main;

import clean.project.gui.contract.SeleniumBrowserType;
import clean.project.gui.google.scenarios.GoogleSearchScenario;

public class Demo {
    public static void main(String[] args) {
        try {
            final GoogleSearchScenario googleSearchScenario = new GoogleSearchScenario(SeleniumBrowserType.CHROME);
            googleSearchScenario.googleSearchFor("selenium");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
