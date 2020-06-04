package clean.project.ds.stack.factory;

import clean.project.ds.stack.contract.MonitoredLimitedStack;
import clean.project.ds.stack.impl.MonitoredLimitedStackImpl;

public class MonitoredLimitedStackFactory<T> implements StackFactory<MonitoredLimitedStack<T>, T> {
    public MonitoredLimitedStack<T> getStack(int size) {
        return new MonitoredLimitedStackImpl<T>(size);
    }
}
