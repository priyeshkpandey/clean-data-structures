package clean.project.ds.queue.contract;

public interface MonitoredLimitedQueue<T> extends LimitedQueue<T> {
    public T peek();
}
