package clean.project.gui.impl;

import clean.project.gui.contract.Actor;
import clean.project.gui.contract.Driver;
import clean.project.gui.contract.Target;
import clean.project.gui.contract.TargetAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

public class SeleniumDriver implements Driver<WebElement, By> {
    private Actor<WebElement, By> actor;
    private List<Map<String, String>> actionSequence = new ArrayList<>();

    @Override
    public void bind(Actor<WebElement, By> actor, Target<WebElement, By> target) {
        this.actor = actor;
        this.actor.setTarget(target);
    }

    @Override
    public void addAction(final String actionName, final String param) {
        final Map<String, String> action = new HashMap<>();
        action.put(actionName, param);
        this.actionSequence.add(action);
    }

    @Override
    public void clearActions() {
        this.actionSequence.clear();
    }

    @Override
    public boolean perform() {
        boolean allActionPassed = true;
        try {
            for (Map<String, String> action : actionSequence) {
                String actionName = null;
                Iterator<String> keyIter = action.keySet().iterator();
                while (keyIter.hasNext()) {
                    actionName = keyIter.next();
                }
                if (!execute(actionName, action.get(actionName))) {
                    allActionPassed = false;
                }
            }
        } catch (Exception ex) {
            System.out.println("Exception while performing actions");
            ex.printStackTrace();
            allActionPassed = false;
        }
        return allActionPassed;
    }

    private boolean execute(final String action, final String param) throws Exception {
        switch (TargetAction.valueOf(action.toUpperCase())) {
            case FIND: return this.actor.find();
            case OPEN: return this.actor.open(param);
            case ENTER: return this.actor.enter(param);
            case CLICK: return this.actor.click();
            case SUBMIT: return this.actor.submit();
            case SLEEP: return this.actor.sleep(param);
            case ROBOT: return this.actor.robot(param);
            case JS_CLICK: return this.actor.jsClick();
            case JS_CHANGE: return this.actor.jsChange();
            case CLEAR: return this.actor.clear();
            case KEYBOARD: return this.actor.keyboard(param);
            case CLOSE: return this.actor.close();
            default: throw new Exception("No such action");
        }
    }

}
