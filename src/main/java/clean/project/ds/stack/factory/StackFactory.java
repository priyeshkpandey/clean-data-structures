package clean.project.ds.stack.factory;

public interface StackFactory<ST, T> {
    public ST getStack(final int size);
}
