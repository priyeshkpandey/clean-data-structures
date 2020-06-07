package clean.project.ds.queue.contract;

public interface PrimitiveQueue<T> {
    public void insert(T item) throws Exception;
    public T remove() throws Exception;
    public boolean isEmpty();
}
