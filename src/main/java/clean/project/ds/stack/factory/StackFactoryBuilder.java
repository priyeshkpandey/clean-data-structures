package clean.project.ds.stack.factory;

public class StackFactoryBuilder<T> {
    public LimitedStackFactory<T> buildLimitedStackFactory() {
       return new LimitedStackFactory<T>();
    }

    public MonitoredLimitedStackFactory<T> buildMonitoredLimitedStackFactory() {
        return new MonitoredLimitedStackFactory<T>();
    }
}
