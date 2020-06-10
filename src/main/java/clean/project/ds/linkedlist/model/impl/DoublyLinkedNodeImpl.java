package clean.project.ds.linkedlist.model.impl;

import clean.project.ds.linkedlist.model.contract.DoublyLinkedNode;
import clean.project.ds.linkedlist.model.contract.LinkedNode;

public class DoublyLinkedNodeImpl<T> implements DoublyLinkedNode<T> {

    private T info;
    private LinkedNode<T> next;
    private DoublyLinkedNode<T> previous;

    public DoublyLinkedNode<T> getPrevious() {
        return this.previous;
    }

    public void setPrevious(DoublyLinkedNode<T> previous) {
        this.previous = previous;
    }

    public LinkedNode<T> getNext() {
        return this.next;
    }

    public void setNext(LinkedNode<T> next) {
        this.next = next;
    }

    public T getInfo() {
        return this.info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
}
