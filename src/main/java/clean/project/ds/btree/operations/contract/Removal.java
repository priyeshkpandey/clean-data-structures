package clean.project.ds.btree.operations.contract;

import clean.project.ds.btree.contract.BinaryTreeNode;

public interface Removal<T> {
    public void freeBinaryTreeNode(final BinaryTreeNode<T> binaryTreeNode);
}
