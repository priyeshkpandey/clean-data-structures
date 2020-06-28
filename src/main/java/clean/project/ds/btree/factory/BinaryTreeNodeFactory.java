package clean.project.ds.btree.factory;

import clean.project.ds.btree.contract.BinaryTreeNode;
import clean.project.ds.btree.impl.BinaryTreeNodeImpl;

public class BinaryTreeNodeFactory<T> implements TreeFactory<BinaryTreeNode<T>, T> {
    public BinaryTreeNode<T> getBinaryTreeNode(T info) {
        final BinaryTreeNode<T> binaryTreeNode = new BinaryTreeNodeImpl<T>();
        binaryTreeNode.setInfo(info);
        return binaryTreeNode;
    }
}
