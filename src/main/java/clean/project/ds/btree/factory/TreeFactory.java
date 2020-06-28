package clean.project.ds.btree.factory;

public interface TreeFactory<BT, T> {
    public BT getBinaryTreeNode(final T info);
}
