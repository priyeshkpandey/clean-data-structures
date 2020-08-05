package clean.project.gui.contract;

import java.util.List;

public interface Executor {
    public void execute(final List<Step> steps) throws Exception;
}
