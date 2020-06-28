package clean.project.ds.btree.factory;

public class TreeFactoryBuilder<T> {
    public BinaryTreeNodeFactory<T> getBinaryTreeFactory() {
        return new BinaryTreeNodeFactory<T>();
    }
}
