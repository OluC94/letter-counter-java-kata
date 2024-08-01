package org.academy.lettercounter;

import java.util.*;

public class LetterCounter {
    Map<Character, Integer> countMap = new HashMap<>();
    List<String> reportList = new ArrayList<>();

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
            Character lowerCaseChar = Character.toLowerCase(c);
            if (countMap.containsKey(lowerCaseChar)) {
                countMap.put(lowerCaseChar, countMap.get(lowerCaseChar) + 1);
            } else {
                countMap.put(lowerCaseChar, 1);
            }

        }
    }

    // convert the Hash map to an array e.g ["key: value", e.t.c.] then sort alphabetically
    public List<String> generateReport() {
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            reportList.add(entry.getKey() + ": " + entry.getValue());
        }
        Collections.sort(reportList);
        return reportList;
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
