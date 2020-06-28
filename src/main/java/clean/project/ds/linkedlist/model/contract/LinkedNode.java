package clean.project.ds.linkedlist.model.contract;

import clean.project.ds.common.model.contract.Node;

public interface LinkedNode<T> extends Node<T> {
    public LinkedNode<T> getNext();
    public void setNext(final LinkedNode<T> next);
}
