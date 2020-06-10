package clean.project.ds.linkedlist.model.impl;

import clean.project.ds.linkedlist.model.contract.LinkedNode;

public class LinkedNodeImpl<T> implements LinkedNode<T> {
    private T info;
    private LinkedNode<T> next;

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public LinkedNode<T> getNext() {
        return next;
    }

    public void setNext(final LinkedNode<T> next) {
        this.next = next;
    }

}
