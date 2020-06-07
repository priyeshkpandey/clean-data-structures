package clean.project.ds.queue.contract;

public interface LimitedQueue<T> extends PrimitiveQueue<T> {
    public boolean isFull();
}
