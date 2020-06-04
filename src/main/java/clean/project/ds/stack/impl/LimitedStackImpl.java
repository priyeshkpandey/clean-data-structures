package clean.project.ds.stack.impl;

import clean.project.ds.stack.contract.LimitedStack;

import java.util.ArrayList;
import java.util.List;

public class LimitedStackImpl<T> implements LimitedStack<T> {

    private List<T> stack;
    private int size;
    private int top = -1;

    public LimitedStackImpl(int size) {
        this.stack = new ArrayList<T>();
        this.size = size;
    }

    public boolean isEmpty() {
        boolean isEmpty = false;
        if (top < 0) {
            isEmpty = true;
        }
        return isEmpty;
    }

    public boolean isFull() {
        boolean isFull = false;
        if (top >= this.size) {
            isFull = true;
        }
        return isFull;
    }

    public void push(T item) throws Exception {
        if (!isFull()) {
            stack.add(++top, item);
        } else {
            throw new Exception("Stack is full");
        }
    }

    public T pop() throws Exception {
        if (!isEmpty()) {
            return stack.get(top--);
        } else {
            throw new Exception("Stack is empty");
        }
    }
}
