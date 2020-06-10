package clean.project.ds.linkedlist.operations.contract;

import clean.project.ds.linkedlist.model.contract.DoublyLinkedNode;
import clean.project.ds.linkedlist.model.contract.LinkedNode;

public interface Creation<T> {
    public LinkedNode<T> getLinkedNode(final T info);
    public DoublyLinkedNode<T> getDoublyLinkedNode(final T info);
}
