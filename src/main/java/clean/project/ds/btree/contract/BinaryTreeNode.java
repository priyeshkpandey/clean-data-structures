package clean.project.ds.btree.contract;

import clean.project.ds.common.model.contract.Node;

public interface BinaryTreeNode<T> extends Node<T> {
    public BinaryTreeNode<T> getLeft();
    public void setLeft(final BinaryTreeNode<T> left);
    public BinaryTreeNode<T> getRight();
    public void setRight(final BinaryTreeNode<T> right);
}
