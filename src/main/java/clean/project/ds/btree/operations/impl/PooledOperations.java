package clean.project.ds.btree.operations.impl;

import clean.project.ds.btree.contract.BinaryTreeNode;
import clean.project.ds.btree.factory.BinaryTreeNodeFactory;
import clean.project.ds.btree.factory.TreeFactoryBuilder;
import clean.project.ds.btree.operations.contract.Creation;
import clean.project.ds.btree.operations.contract.Removal;

import java.util.HashSet;
import java.util.Set;

public class PooledOperations<T> implements Creation<T>, Removal<T> {

    private final TreeFactoryBuilder<T> treeFactoryBuilder = new TreeFactoryBuilder<T>();
    private final Set<BinaryTreeNode<T>> binaryTreeNodes = new HashSet<BinaryTreeNode<T>>();
    private final BinaryTreeNodeFactory<T> binaryTreeNodeFactory;

    public PooledOperations() {
        this.binaryTreeNodeFactory = treeFactoryBuilder.getBinaryTreeFactory();
    }

    public BinaryTreeNode<T> getBinaryTreeNode(T info) {
        BinaryTreeNode<T> localBinaryTreeNode = findBinaryTreeNodeAndRemove(info);
        if (null == localBinaryTreeNode) {
            localBinaryTreeNode = binaryTreeNodeFactory.getBinaryTreeNode(info);
        }
        return localBinaryTreeNode;
    }

    public void freeBinaryTreeNode(BinaryTreeNode<T> binaryTreeNode) {
        binaryTreeNode.setLeft(null);
        binaryTreeNode.setRight(null);
        binaryTreeNodes.add(binaryTreeNode);
    }

    private BinaryTreeNode<T> findBinaryTreeNodeAndRemove(final T info) {
        BinaryTreeNode<T> localBinaryTreeNode = null;
        for (BinaryTreeNode<T> currentBinaryTreeNode : binaryTreeNodes) {
            if (currentBinaryTreeNode.getInfo().equals(info)) {
                localBinaryTreeNode = currentBinaryTreeNode;
                break;
            }
        }
        binaryTreeNodes.remove(localBinaryTreeNode);
        return localBinaryTreeNode;
    }
}
