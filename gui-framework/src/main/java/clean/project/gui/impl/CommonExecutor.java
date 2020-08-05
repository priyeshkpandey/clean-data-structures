package clean.project.gui.impl;


import clean.project.gui.contract.Executor;
import clean.project.gui.contract.Step;

import java.util.List;

public class CommonExecutor implements Executor {
    @Override
    public void execute(List<Step> steps) throws Exception {
        for (Step step : steps) {
            step.execute();
        }
    }
}
