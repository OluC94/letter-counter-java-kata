package org.academy.lettercounter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCounter {
    Map<Character, Integer> countMap = new HashMap<>();

    public LetterCounter() {
    }

    // for each letter in the string
    //      make sure it is an alphabetical character, if not, skip to the next iteration
    //      check if there is a corresponding key in the HashMap map.containsKey(c)
    // if not, add a new key, otherwise increment the key's value by one
    public void countAll(String word) {
        for (char c : word.toCharArray()) {
            if (!isAlphabet(c)){
                continue;
            }
            if (countMap.containsKey(c)) {
                countMap.put(c, countMap.get(c) + 1);
            } else {
                countMap.put(c, 1);
            }

        }
    }

    // convert the Hash map to an array e.g ["key: value", e.t.c.]
    public List<String> generateReport() {
        throw new RuntimeException("Not implemented");
    }

    public int getCountForLetter(char letter) {
        throw new RuntimeException("Not implemented");
    }

    public void countOneLetter(Character inputLetter) {
        throw new RuntimeException("Not implemented");
    }

    private boolean isAlphabet(char letter) {
        return Character.isLetter(letter);
    }


}
