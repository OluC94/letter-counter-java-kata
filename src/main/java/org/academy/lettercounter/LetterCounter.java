package org.academy.lettercounter;

import java.util.*;

public class LetterCounter {
    // a set will maintain uniqueness, probably better than a map
    private final Map<Character, Integer> countMap;
    private final List<String> reportList;

    public LetterCounter() {
        countMap = new HashMap<>();
        reportList = new ArrayList<>();
    }

    // for each letter in the string
    //      make sure it is an alphabetical character, if not, skip to the next iteration
    //      if there is a corresponding key in the HashMap map.containsKey(c)
    // if not, add a new key, otherwise increment the key's value by one
    public void countAll(String word) {
        for (Character c : word.toCharArray()) {
            if (!isAlphabet(c)){
                continue;
            }
            Character lowerCaseChar = Character.toLowerCase(c);
            updateMapWithLetter(lowerCaseChar);
        }
    }

    // convert the Hash Map to an array e.g ["key: value", e.t.c.] then sort alphabetically
    public List<String> generateReport() {
/*
        for testing: Set<Map.Entry<Character, Integer>> entriesSet = countMap.entrySet();
        System.out.println("Entries size: ");
        System.out.println(entriesSet.size());
        Map.Entry<Character, Integer> firstEntryInSet = (Map.Entry<Character, Integer>) entriesSet.toArray()[0];
        System.out.println(firstEntryInSet.getValue());
*/

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            String reportLine = entry.getKey() + ": " + entry.getValue();
            reportList.add(reportLine);
        }
        Collections.sort(reportList);
        return reportList;
    }

    // take a letter, return the value for the corresponding map key
    // getOrDefault will return 0 if c is not found
    public int getCountForLetter(Character letter) {
        if (!isAlphabet(letter)) {
            return 0;
        }

        Character lowerCaseChar = Character.toLowerCase(letter);
        return countMap.getOrDefault(lowerCaseChar, 0);
    }

    // take the input and update the map
    public void countOneLetter(Character inputLetter) {
        if (isAlphabet(inputLetter)){
            Character lowerCaseChar = Character.toLowerCase(inputLetter);
            updateMapWithLetter(lowerCaseChar);
        }
    }

    private boolean isAlphabet(Character letter) {
        return Character.isLetter(letter);
    }

    private void updateMapWithLetter(Character letter) {
        if (countMap.containsKey(letter)) {
            countMap.put(letter, countMap.get(letter) + 1);
        } else {
            countMap.put(letter, 1);
        }
    }


}
