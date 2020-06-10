package clean.project.ds.linkedlist.operations.impl;

import clean.project.ds.linkedlist.factory.ListFactoryBuilder;
import clean.project.ds.linkedlist.model.contract.DoublyLinkedNode;
import clean.project.ds.linkedlist.model.contract.LinkedNode;
import clean.project.ds.linkedlist.operations.contract.Creation;
import clean.project.ds.linkedlist.operations.contract.Removal;

public class SimpleOperations<T> implements Creation<T>, Removal<T> {

    private ListFactoryBuilder<T> listFactoryBuilder = new ListFactoryBuilder<T>();

    public LinkedNode<T> getLinkedNode(final T info) {
        LinkedNode<T> localLinkedNode = listFactoryBuilder.getLinkedNodeFactory().getList();
        localLinkedNode.setInfo(info);
        return localLinkedNode;
    }

    public DoublyLinkedNode<T> getDoublyLinkedNode(final T info) {
        DoublyLinkedNode<T> localDoublyLinkedNode = listFactoryBuilder.getDoublyLinkedNodeFactory().getList();
        localDoublyLinkedNode.setInfo(info);
        return localDoublyLinkedNode;
    }

    public void freeLinkedNode(LinkedNode<T> linkedNode) {
        linkedNode.setNext(null);
    }

    public void freeDoublyLinkedNode(DoublyLinkedNode<T> doublyLinkedNode) {
        doublyLinkedNode.setNext(null);
        doublyLinkedNode.setPrevious(null);
    }
}
