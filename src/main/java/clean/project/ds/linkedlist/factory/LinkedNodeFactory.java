package clean.project.ds.linkedlist.factory;

import clean.project.ds.linkedlist.model.contract.LinkedNode;
import clean.project.ds.linkedlist.model.impl.LinkedNodeImpl;

public class LinkedNodeFactory<T> implements ListFactory<LinkedNode<T>, T> {
    public LinkedNode<T> getList() {
        return new LinkedNodeImpl<T>();
    }
}
