package clean.project.ds.linkedlist.operations.contract;

import clean.project.ds.linkedlist.model.contract.DoublyLinkedNode;
import clean.project.ds.linkedlist.model.contract.LinkedNode;

public interface Removal<T> {
    public void freeLinkedNode(final LinkedNode<T> linkedNode);
    public void freeDoublyLinkedNode(final DoublyLinkedNode<T> doublyLinkedNode);
}
