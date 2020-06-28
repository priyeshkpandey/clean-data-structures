package clean.project.ds.btree.impl;

import clean.project.ds.btree.contract.BinaryTreeNode;

public class BinaryTreeNodeImpl<T> implements BinaryTreeNode<T> {

    private T info;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public BinaryTreeNode<T> getLeft() {
        return this.left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return this.right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public T getInfo() {
        return this.info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
}
