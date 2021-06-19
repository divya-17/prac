package tree.trieDS;

import java.util.Arrays;

public class TrieNode {

    private Character ch;
    private Boolean wordEndFlag;
    private TrieNode[] childNodes;

    public TrieNode(){
        ch = null;
        wordEndFlag = false;
        childNodes = new TrieNode[26];
    }

    public Character getCh() {
        return ch;
    }

    public void setCh(Character ch) {
        this.ch = ch;
    }

    public Boolean getWordEndFlag() {
        return wordEndFlag;
    }

    public void setWordEndFlag(Boolean wordEndFlag) {
        this.wordEndFlag = wordEndFlag;
    }

    public TrieNode[] getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(TrieNode[] childNodes) {
        this.childNodes = childNodes;
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "ch=" + ch +
                ", wordEndFlag=" + wordEndFlag +
                ", childNodes=" + Arrays.toString(childNodes) +
                '}';
    }
}
