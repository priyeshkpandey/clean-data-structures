package clean.project.ds.stack.factory;

import clean.project.ds.stack.contract.LimitedStack;
import clean.project.ds.stack.impl.LimitedStackImpl;

public class LimitedStackFactory<T> implements StackFactory<LimitedStack<T>, T> {
    public LimitedStack<T> getStack(int size) {
        return new LimitedStackImpl<T>(size);
    }
}
