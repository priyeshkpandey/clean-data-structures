package clean.project.ds.stack.factory;

import clean.project.ds.stack.contract.UnlimitedStack;
import clean.project.ds.stack.impl.UnlimitedStackLinkedListImpl;

public class UnlimitedStackLinkedListFactory<T> implements StackFactory<UnlimitedStack<T>, T> {
    public UnlimitedStack<T> getStack(int size) {
        return new UnlimitedStackLinkedListImpl<T>();
    }
}
