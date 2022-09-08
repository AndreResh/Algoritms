package alg.string;

import java.util.*;

public class SecondDayString {
    public int numMatchingSubseq(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String a : words) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (isSubMatch(s, entry.getKey())) {
                count += entry.getValue();
            }
        }
        return count;
    }

    private boolean isSubMatch(String s, String word) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) == word.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == word.length();
    }

    public int countVowelSubstrings(String word) {
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        int count = 0;
        Set<Character> currentSet = new HashSet<>();
        for (int i = 0; i < word.length() - 4; i++) {
            currentSet.clear();
            for (int j = i; j < word.length(); j++) {
                if (set.contains(word.charAt(j))) {
                    currentSet.add(word.charAt(j));
                } else {
                    break;
                }
                if (currentSet.size() == 5) count++;
            }
        }
        return count;
    }

    public int findJudge(int n, int[][] trust) {
        int[] ints = new int[n];
        for (int[] a : trust) {
            ints[a[0] - 1]--;
            ints[a[1] - 1]++;
        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == n - 1) return i + 1;
        }
        return -1;
    }

    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            char[] main = words[i].toCharArray();
            Arrays.sort(main);
            result.add(words[i]);
            int j = i + 1;
            while (j < words.length) {
                char[] current = words[j].toCharArray();
                Arrays.sort(current);
                if (new String(main).equals(new String(current))) {
                    if (j == words.length - 1) {
                        return result;
                    }
                } else {
                    i = j;
                    if (j == words.length - 1) {
                        result.add(words[j]);
                        return result;
                    }

                    break;
                }
                j++;
            }
            if (i == words.length - 1) return result;
        }
        return result;
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (matchesPattern(word, pattern)) {
                list.add(word);
            }
        }
        return list;
    }

    private boolean matchesPattern(String word, String pattern) {
        if (word.length() != pattern.length()) return false;
        Map<Character, Character> mapWord = new HashMap<>();
        Map<Character, Character> mapPattern = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            if (mapWord.containsKey(word.charAt(i)) && pattern.charAt(i) != mapWord.get(word.charAt(i))) {
                return false;
            } else if (mapPattern.containsKey(pattern.charAt(i)) && word.charAt(i) != mapPattern.get(pattern.charAt(i))) {
                return false;
            } else {
                mapWord.put(word.charAt(i), pattern.charAt(i));
                mapPattern.put(pattern.charAt(i), word.charAt(i));
            }
        }
return true;
    }

    public String toGoatLatin(String sentence) {
        Set<Character> gl = Set.of('a', 'e', 'i', 'o',  'u' );
        String[] strings = sentence.split(" ");
        for (int i = 0; i < strings.length; i++) {
            StringBuilder builder = new StringBuilder();
            if(gl.contains(strings[i].toLowerCase().charAt(0))){
                builder.append(strings[i]);
            } else {
                builder.append(strings[i].substring(1));
            }
            builder.append("ma");
            for (int j = 0; j < i+1; j++) {
                builder.append("a");
            }
            strings[i] = builder.toString();;
        }
        return String.join(" ", strings);
    }
}
