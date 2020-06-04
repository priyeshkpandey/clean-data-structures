package clean.project.ds.stack.contract;

public interface LimitedStack<T> extends PrimitiveStack<T> {
    public boolean isEmpty();
    public boolean isFull();
}
