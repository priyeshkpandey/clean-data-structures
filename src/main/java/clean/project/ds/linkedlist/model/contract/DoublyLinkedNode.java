package clean.project.ds.linkedlist.model.contract;

public interface DoublyLinkedNode<T> extends LinkedNode<T> {
    public DoublyLinkedNode<T> getPrevious();
    public void setPrevious(final DoublyLinkedNode<T> previous);
}
