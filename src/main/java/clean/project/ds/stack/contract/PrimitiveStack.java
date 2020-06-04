package clean.project.ds.stack.contract;

public interface PrimitiveStack <T> {
    public void push(T item) throws Exception;
    public T pop() throws Exception;
}
