package clean.project.ds.btree.application;

import clean.project.ds.btree.contract.BinaryTreeNode;
import clean.project.ds.btree.operations.impl.PooledOperations;
import clean.project.ds.queue.contract.MonitoredLimitedQueue;
import clean.project.ds.queue.factory.QueueFactoryBuilder;

public class HuffmanCoding {
    private static final QueueFactoryBuilder<BinaryTreeNode<CharacterFrequencyInfo>> charFreqBTNodeQueueBuilder
            = new QueueFactoryBuilder<>();
    private static final PooledOperations<CharacterFrequencyInfo> pooledBTreeNodes = new PooledOperations<>();

    public void generateHuffmanCodes(final char[] charArray, final int[] charFreq) throws Exception {
        if (charArray.length != charFreq.length) {
            return;
        }
        final MonitoredLimitedQueue<BinaryTreeNode<CharacterFrequencyInfo>> charFrequencyPriorityQueue
                = charFreqBTNodeQueueBuilder
                .getMonitoredLimitedPriorityQueueFactory(new BTNodeCharFreqInfoComparator())
                .getQueue(100);
        final int arrayLength = charArray.length;
        for (int index = 0; index < arrayLength; index++) {
            CharacterFrequencyInfo characterFrequencyInfo = new CharacterFrequencyInfo();
            characterFrequencyInfo.setaChar(charArray[index]);
            characterFrequencyInfo.setFrequency(charFreq[index]);
            BinaryTreeNode<CharacterFrequencyInfo> binaryTreeNode = pooledBTreeNodes.getBinaryTreeNode(characterFrequencyInfo);
            charFrequencyPriorityQueue.insert(binaryTreeNode);
        }
        BinaryTreeNode<CharacterFrequencyInfo> root = null;
        while (charFrequencyPriorityQueue.getCount() > 1) {
            BinaryTreeNode<CharacterFrequencyInfo> left = charFrequencyPriorityQueue.remove();
            BinaryTreeNode<CharacterFrequencyInfo> right = charFrequencyPriorityQueue.remove();
            CharacterFrequencyInfo parentInfo = new CharacterFrequencyInfo();
            parentInfo.setFrequency(left.getInfo().getFrequency() + right.getInfo().getFrequency());
            parentInfo.setaChar('-');
            BinaryTreeNode<CharacterFrequencyInfo> parent = pooledBTreeNodes.getBinaryTreeNode(parentInfo);
            parent.setLeft(left);
            parent.setRight(right);
            root = parent;
            charFrequencyPriorityQueue.insert(parent);
        }
        printCodes(root, "");
    }

    private void printCodes(final BinaryTreeNode<CharacterFrequencyInfo> root, final String code) {
        if (root.getLeft() == null
                && root.getRight() == null
                && Character.isLetter(root.getInfo().getaChar())) {
            System.out.println(root.getInfo().getaChar() + " : " + code);
            return;
        }
        printCodes(root.getLeft(), code + "0");
        printCodes(root.getRight(), code + "1");
    }

    public static void main(String[] args) throws Exception {
        final HuffmanCoding huffmanCoding = new HuffmanCoding();
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charFreq = { 5, 9, 12, 13, 16, 45 };
        huffmanCoding.generateHuffmanCodes(charArray, charFreq);
    }

}
