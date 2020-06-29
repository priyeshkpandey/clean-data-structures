package clean.project.ds.btree.application;

import clean.project.ds.btree.contract.BinaryTreeNode;

import java.util.Comparator;

public class BTNodeCharFreqInfoComparator implements Comparator<BinaryTreeNode<CharacterFrequencyInfo>> {
    @Override
    public int compare(BinaryTreeNode<CharacterFrequencyInfo> o1, BinaryTreeNode<CharacterFrequencyInfo> o2) {
        return Integer.compare(o1.getInfo().getFrequency(), o2.getInfo().getFrequency());
    }
}
