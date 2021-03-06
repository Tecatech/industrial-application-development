package ru.mephi.lab2.OccurrenceOfTokenInString;

import java.util.*;

public class OccurrenceOfTokenInString {
    public static void tokenCount(String inputString) {
        String[] tokens = inputString.replaceAll("\\s+", " ").split(" ");
        
        HashMap<String, Integer> tokenCountMap = new HashMap<>();
        
        for (String token : tokens) {
            if (tokenCountMap.containsKey(token)) {
                tokenCountMap.put(token, tokenCountMap.get(token) + 1);
            }
            else {
                tokenCountMap.put(token, 1);
            }
        }
        
        tokenCountMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String inputString = scanner.nextLine();
        
        tokenCount(inputString);
    }
}