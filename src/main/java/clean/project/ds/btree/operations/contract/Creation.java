package clean.project.ds.btree.operations.contract;

import clean.project.ds.btree.contract.BinaryTreeNode;

public interface Creation<T> {
    public BinaryTreeNode<T> getBinaryTreeNode(final T info);
}
