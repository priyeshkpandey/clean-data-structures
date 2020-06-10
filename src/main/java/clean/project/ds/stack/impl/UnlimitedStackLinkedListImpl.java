package clean.project.ds.stack.impl;

import clean.project.ds.linkedlist.model.contract.LinkedNode;
import clean.project.ds.linkedlist.operations.impl.PooledOperations;
import clean.project.ds.stack.contract.UnlimitedStack;

public class UnlimitedStackLinkedListImpl<T> implements UnlimitedStack<T> {
    private PooledOperations<T> pooledOperations = new PooledOperations<T>();
    private LinkedNode<T> topNode;

    public boolean isEmpty() {
        return (null == topNode);
    }

    public void push(T item) throws Exception {
        if (isEmpty()) {
            topNode = pooledOperations.getLinkedNode(item);
        } else {
            LinkedNode<T> tempNode = pooledOperations.getLinkedNode(item);
            tempNode.setNext(topNode);
            topNode = tempNode;
        }
    }

    public T pop() throws Exception {
        if (null == topNode) {
            throw new Exception("Stack is empty");
        } else {
            LinkedNode<T> tempNode = topNode;
            topNode = tempNode.getNext();
            T item = tempNode.getInfo();
            pooledOperations.freeLinkedNode(tempNode);
            return item;
        }
    }
}
