package clean.project.ds.btree.application;

import java.util.Objects;

public class CharacterFrequencyInfo {
    private int frequency;
    private char aChar;

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public char getaChar() {
        return aChar;
    }

    public void setaChar(char aChar) {
        this.aChar = aChar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterFrequencyInfo that = (CharacterFrequencyInfo) o;
        return frequency == that.frequency &&
                aChar == that.aChar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(frequency, aChar);
    }
}
