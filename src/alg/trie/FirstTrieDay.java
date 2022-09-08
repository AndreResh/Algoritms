package alg.trie;

import java.util.*;

public class FirstTrieDay {
    public static void main(String[] args) {
        System.out.println(new FirstTrieDay().wordBreak( "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab".length());
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> listList = new ArrayList<>();
        TrieWords trieWords = new TrieWords();
        for (int i = 0; i < products.length; i++) {
            trieWords.add(products[i]);
        }
        for (int i = 1; i <= searchWord.length(); i++) {
            listList.add(trieWords.getAllWords(searchWord.substring(0, i)));
        }
        return listList;
    }

    //    public int minimumLengthEncoding(String[] words) {
//        NewTrie newTrie = new NewTrie();
//        for (int i = 0; i < words.length; i++) {
//            newTrie.add(new StringBuilder(words[i]).reverse().toString());
//        }
//        return newTrie.getCount();
//    }

    //    public int minimumLengthEncoding(String[] words) {
//        Set<String> strings = new HashSet<>(Arrays.asList(words));
//        for (int i = 0; i < words.length; i++) {
//            for (int j = 1; j < words[i].length(); j++) {
//                strings.remove(words[i].substring(j));
//            }
//        }
//        int count = 0;
//        for (String s:strings ) {
//            count += s.length()+1;
//        }
//        return count;
//    }
    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        Map<TrieNode, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            TrieNode cur = root;
            for (int j = words[i].length() - 1; j >= 0; j--) {
                cur = cur.get(words[i].charAt(j));
            }
            map.put(cur, i);
        }
        int count = 0;
        for (Map.Entry<TrieNode, Integer> entry : map.entrySet()) {
            if (entry.getKey().getCount() == 0) {
                count += words[entry.getValue()].length() + 1;
            }
        }
        return count;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        List<String> list = new ArrayList<>(wordDict);
        TrieWordBreak trieWordBreak = new TrieWordBreak();
        list.forEach(trieWordBreak::add);
        return trieWordBreak.canConstruct(s);
    }
}

class TrieWordBreak {
    private TrieNode root;

    public TrieWordBreak() {
        this.root = new TrieNode();
    }


    private class TrieNode {
        private TrieNode[] children;
        private boolean isFinal;

        public TrieNode() {
            this.children=new TrieNode[26];
        }

        public void put(char ch, TrieNode node) {
            children[ch - 'a'] = node;
        }

        public TrieNode get(char ch) {
            return children[ch - 'a'];
        }

        public boolean contains(char ch) {
            return get(ch) != null;
        }

        public void setFinal() {
            this.isFinal = true;
        }
    }

    public void add(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.contains(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setFinal();
    }


    public boolean canConstruct(String s) {
        return canConstructWord(s, 0, root, new HashSet<>());
    }

    private boolean canConstructWord(String s, int start, TrieNode current,Set<Integer> set) {
        if (start == s.length()){

            return current.isFinal;
        }
        if(set.contains(start)) return false;
        boolean first = false;
        if (current.contains(s.charAt(start))) {
            first = canConstructWord(s, start + 1, current.get(s.charAt(start)), set);
        } else if (current.isFinal && root.contains(s.charAt(start))) {
            first  = canConstructWord(s, start + 1, root.get(s.charAt(start)), set);
        }
        return first ;
    }
}

class TrieNode {
    private TrieNode[] children;
    private int count;

    public TrieNode() {
        children = new TrieNode[26];
        count = 0;
    }

    public TrieNode get(char ch) {
        int index = ch - 'a';
        if (children[index] == null) {
            children[index] = new TrieNode();
            count++;
        }
        return children[index];
    }

    public int getCount() {
        return count;
    }
}

class NewTrie {
    private TrieNode root;

    public NewTrie() {
        root = new TrieNode();
    }

    private class TrieNode {
        private final int SIZE = 26;
        private TrieNode[] children;
        private boolean isFinal;

        public TrieNode() {
            children = new TrieNode[SIZE];
        }

        public void put(char ch, TrieNode node) {
            children[ch - 'a'] = node;
        }

        public TrieNode get(char ch) {
            return children[ch - 'a'];
        }

        public boolean contains(char ch) {
            return children[ch - 'a'] != null;
        }

        public void setFinal() {
            isFinal = true;
        }
    }

    public void add(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.contains(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setFinal();
    }

    public int getCount() {
        int count = getCountOfThis(root, 1);
        return count;
    }

    private int getCountOfThis(TrieNode trieNode, int count) {

        int c = 0;
        boolean hasChildren = false;
        for (int i = 0; i < trieNode.SIZE; i++) {
            if (trieNode.children[i] != null) {
                hasChildren = true;
                c += getCountOfThis(trieNode.children[i], count + 1);
            }
        }
        if (!hasChildren && trieNode.isFinal) {
            return count;
        } else {
            return c;
        }
    }

}

class TrieWords {
    private TrieNode root;

    TrieWords() {
        this.root = new TrieNode();
    }

    public List<String> getAllWords(String substring) {
        return findAllStrings(substring, 0, root, new ArrayList<>(), "");
    }

    private List<String> findAllStrings(String substring, int start, TrieNode node, List<String> strings, String current) {
        if (node == null || strings.size() == 3) return strings;
        char ch = substring.charAt(start);

        if (node.contains(ch)) {
            if (node.isFinal) {
                strings.add(current);
            }
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    return findAllStrings(substring, start + 1, node.children[i], strings, current + String.valueOf(i + 'a'));
                }
            }
        }
        return strings;
    }

    private class TrieNode {
        private TrieNode[] children;
        private final static int SIZE = 26;
        private boolean isFinal;

        public TrieNode() {
            this.children = new TrieNode[SIZE];
        }

        public void put(char ch, TrieNode node) {
            children[ch - 'a'] = node;
        }

        public TrieNode get(char ch) {
            return children[ch - 'a'];
        }

        public boolean contains(char ch) {
            return children[ch * 'a'] != null;
        }

        public void setFinal() {
            isFinal = true;
        }
    }

    public void add(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.contains(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setFinal();
    }

}


class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();

    }

    private static class TrieNode {
        private static final int SIZE = 26;
        private final TrieNode[] children;
        private boolean isFinal;

        public TrieNode() {
            children = new TrieNode[SIZE];
            this.isFinal = false;
        }

        public void put(char ch, TrieNode trieNode) {
            children[ch - 'a'] = trieNode;
        }

        public TrieNode get(char ch) {
            return children[ch - 'a'];
        }

        public boolean contains(char ch) {
            return children[ch - 'a'] != null;
        }

        public void setFinal() {
            this.isFinal = true;
        }
    }

    public void insert(String word) {

        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.contains(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setFinal();
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.contains(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return node.isFinal;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!node.contains(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return true;
    }
}

class WordDictionary {

    private WordNode root;

    class WordNode {
        private final int SIZE = 26;
        private WordNode[] children;
        private boolean isFinal;

        protected WordNode() {
            this.children = new WordNode[SIZE];
            this.isFinal = false;
        }

        public void put(char ch, WordNode node) {
            children[ch - 'a'] = node;
        }

        public WordNode get(char ch) {
            return children[ch - 'a'];
        }

        public boolean contains(char ch) {
            return children[ch - 'a'] != null;
        }

        public void setFinal() {
            this.isFinal = true;
        }

    }

    public WordDictionary() {
        this.root = new WordNode();

    }

    public void addWord(String word) {
        WordNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.contains(ch)) {
                node.put(ch, new WordNode());
            }
            node = node.get(ch);
        }
        node.setFinal();
    }

    public boolean search(String word) {
        return searchNode(root, word, 0);
    }

    private boolean searchNode(WordNode node, String main, int start) {
        if (node == null) return false;
        if (start == main.length()) {
            return node.isFinal;
        }
        char ch = main.charAt(start);
        if (ch == '.') {
            for (int j = 0; j < 26; j++) {
                if (node.children[j] != null && searchNode(node.children[j], main, start + 1)) {
                    return true;
                }
            }
            return false;
        } else if (!node.contains(ch)) {
            return false;
        }
        return searchNode(node.get(ch), main, start + 1);
    }
}
