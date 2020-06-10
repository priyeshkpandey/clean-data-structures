package clean.project.ds.linkedlist.factory;

import clean.project.ds.linkedlist.model.contract.DoublyLinkedNode;
import clean.project.ds.linkedlist.model.impl.DoublyLinkedNodeImpl;

public class DoublyLinkedNodeFactory<T> implements ListFactory<DoublyLinkedNode<T>, T> {
    public DoublyLinkedNode<T> getList() {
        return new DoublyLinkedNodeImpl<T>();
    }
}
