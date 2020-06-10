package clean.project.ds.stack.factory;

import clean.project.ds.stack.contract.UnlimitedStack;

public class StackFactoryBuilder<T> {
    public LimitedStackFactory<T> buildLimitedStackFactory() {
       return new LimitedStackFactory<T>();
    }

    public MonitoredLimitedStackFactory<T> buildMonitoredLimitedStackFactory() {
        return new MonitoredLimitedStackFactory<T>();
    }

    public UnlimitedStackLinkedListFactory<T> buildUnlimitedStackLinkedListFactory() {
        return new UnlimitedStackLinkedListFactory<T>();
    }
}
