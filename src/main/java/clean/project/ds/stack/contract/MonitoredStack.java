package clean.project.ds.stack.contract;

public interface MonitoredStack<T> extends PrimitiveStack<T> {
    public T peek() throws Exception;
}
