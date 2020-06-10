package clean.project.ds.linkedlist.operations.impl;

import clean.project.ds.linkedlist.factory.ListFactoryBuilder;
import clean.project.ds.linkedlist.model.contract.DoublyLinkedNode;
import clean.project.ds.linkedlist.model.contract.LinkedNode;
import clean.project.ds.linkedlist.operations.contract.Creation;
import clean.project.ds.linkedlist.operations.contract.Removal;

import java.util.HashSet;
import java.util.Set;

public class PooledOperations<T> implements Creation<T>, Removal<T> {

    private ListFactoryBuilder<T> listFactoryBuilder = new ListFactoryBuilder<T>();
    private final Set<LinkedNode<T>> linkedNodeSet = new HashSet<LinkedNode<T>>();
    private final Set<DoublyLinkedNode<T>> doublyLinkedNodeSet = new HashSet<DoublyLinkedNode<T>>();

    public LinkedNode<T> getLinkedNode(final T info) {
        LinkedNode<T> localLinkedNode = findLinkedNodeAndRemove(info);
        if (null == localLinkedNode) {
            localLinkedNode = listFactoryBuilder.getLinkedNodeFactory().getList();
            localLinkedNode.setInfo(info);
        }
        return localLinkedNode;
    }

    public DoublyLinkedNode<T> getDoublyLinkedNode(final T info) {
        DoublyLinkedNode<T> localDoublyLinkedNode = findDoublyLinkedNodeAndRemove(info);
        if (null == localDoublyLinkedNode) {
            localDoublyLinkedNode = listFactoryBuilder.getDoublyLinkedNodeFactory().getList();
            localDoublyLinkedNode.setInfo(info);
        }
        return localDoublyLinkedNode;
    }

    public void freeLinkedNode(LinkedNode<T> linkedNode) {
        linkedNode.setNext(null);
        linkedNodeSet.add(linkedNode);
    }

    public void freeDoublyLinkedNode(DoublyLinkedNode<T> doublyLinkedNode) {
        doublyLinkedNode.setNext(null);
        doublyLinkedNode.setPrevious(null);
        doublyLinkedNodeSet.add(doublyLinkedNode);
    }

    private LinkedNode<T> findLinkedNodeAndRemove(final T info) {
        LinkedNode<T> localLinkedNode = null;
        for (LinkedNode<T> linkedNode : linkedNodeSet) {
            if (linkedNode.getInfo().equals(info)) {
                localLinkedNode = linkedNode;
                break;
            }
        }
        linkedNodeSet.remove(localLinkedNode);
        return localLinkedNode;
    }

    private DoublyLinkedNode<T> findDoublyLinkedNodeAndRemove(final T info) {
        DoublyLinkedNode<T> localDoublyLinkedNode = null;
        for (DoublyLinkedNode<T> doublyLinkedNode : doublyLinkedNodeSet) {
            if (doublyLinkedNode.getInfo().equals(info)) {
                localDoublyLinkedNode = doublyLinkedNode;
                break;
            }
        }
        doublyLinkedNodeSet.remove(localDoublyLinkedNode);
        return localDoublyLinkedNode;
    }

}
