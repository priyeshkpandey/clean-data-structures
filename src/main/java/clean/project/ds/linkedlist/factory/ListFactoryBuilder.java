package clean.project.ds.linkedlist.factory;

public class ListFactoryBuilder<T> {
    public LinkedNodeFactory<T> getLinkedNodeFactory() {
        return new LinkedNodeFactory<T>();
    }

    public DoublyLinkedNodeFactory<T> getDoublyLinkedNodeFactory() {
        return new DoublyLinkedNodeFactory<T>();
    }
}
