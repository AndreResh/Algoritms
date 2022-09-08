package alg.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecondDayTrie {
    public static void main(String[] args) {

    }

    public String replaceWords(List<String> dictionary, String sentence) {
        String[] strings = sentence.split(" ");
        TrieMyNode trieMyNode = new TrieMyNode();
        dictionary.forEach(trieMyNode::add);
        for (int i = 0; i < strings.length; i++) {
            strings[i] = trieMyNode.replaceWord(strings[i]);
        }
        return String.join(" ", strings);
    }

}

class TrieMyNode {
    private Node root;

    public TrieMyNode() {
        this.root = new Node();
    }

    class Node {
        private boolean isFinal;
        private Node[] nodes;

        protected Node() {
            this.nodes = new Node[26];
        }

        public Node get(char ch) {
            return nodes[ch - 'a'];
        }

        public void put(char ch, Node node) {
            nodes[ch - 'a'] = node;
        }

        public boolean contains(char ch) {
            return nodes[ch - 'a'] != null;
        }

        public void setFinal() {
            this.isFinal = true;
        }
    }

    public void add(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            if (!current.contains(word.charAt(i))) {
                current.put(word.charAt(i), new Node());
            }
            current = current.get(word.charAt(i));
        }
        current.setFinal();
    }

    public String replaceWord(String word) {
        return replaceWord(word, 0, root);
    }

    private String replaceWord(String word, int start, Node node) {
        if (start == word.length()) return word;
        if (node.isFinal) return word.substring(0, start);
        char ch = word.charAt(start);
        if (!node.contains(ch)) return word;
        return replaceWord(word, start + 1, node.get(ch));
    }
}

class MapSum {

    Node head;

    class Node {
        Node[] nodes;
        boolean isFinal;

        int val;

        public Node() {
            nodes = new Node[26];
            isFinal = false;
        }

        private void put(char ch) {
            nodes[ch - 'a'] = new Node();
        }

        private Node get(char ch) {
            return nodes[ch - 'a'];
        }

        private void setFinal(int val) {
            isFinal = true;
            this.val = val;
        }

        private int getVal(){
            return val;
        }
    }

    public MapSum() {
        head = new Node();
    }

    public void insert(String key, int val) {
        Node node = head;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (node.get(ch) == null) {
                node.put(ch);
            }
            node = node.get(ch);
        }
        node.setFinal(val);

    }

    public int sum(String prefix) {
        Node node = head;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(node.get(ch)==null) return 0;
            node = node.get(ch);
        }
        return getSumPrefix(node);
    }

    private int getSumPrefix(Node node) {
        int sum = node.getVal();
        for (int i = 0; i < 26; i++) {
            if(node.nodes[i]!=null){
                sum+=getSumPrefix(node.nodes[i]);
            }
        }
        return sum;
    }
}
