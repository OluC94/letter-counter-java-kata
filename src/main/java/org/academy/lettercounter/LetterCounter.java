package org.academy.lettercounter;

import java.util.*;

public class LetterCounter {
    Map<Character, Integer> countMap = new HashMap<>();
    List<String> reportList = new ArrayList<>();

    public LetterCounter() {
        //empty method for testing purposes
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

    // take a letter, return the value for the corresponding map key
    public int getCountForLetter(char letter) {
        if (!isAlphabet(letter)) {
            return 0;
        }
        char lowerCaseChar = Character.toLowerCase(letter);
        if (countMap.containsKey(lowerCaseChar)) {
            return countMap.get(lowerCaseChar);
        }
        return 0;
    }

    // take the input and update the map
    public void countOneLetter(Character inputLetter) {
        if (isAlphabet(inputLetter)){
            char lowerCaseChar = Character.toLowerCase(inputLetter);
            if (countMap.containsKey(lowerCaseChar)) {
                countMap.put(lowerCaseChar, countMap.get(lowerCaseChar) + 1);
            } else {
                countMap.put(lowerCaseChar, 1);
            }
        }
    }

    private boolean isAlphabet(char letter) {
        return Character.isLetter(letter);
    }


}
