package clean.project.ds.stack.contract;

public interface MonitoredLimitedStack<T> extends LimitedStack<T> {
    public T peek() throws Exception;
}
