package ru.mephi.lab2;

import java.util.*;

public class OccurrenceOfUniqueTokenInString {
    public static String tokenHandle(String inputString) {
        String[] tokens = inputString.replaceAll("\\s+", " ").split(" ");
        LinkedHashSet<String> tokenHandleSet = new LinkedHashSet<>(Arrays.asList(tokens));
        return Arrays.toString(tokenHandleSet.toArray()).replaceAll("[\\[,\\]]", "");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String inputString = scanner.nextLine();
        
        String outputString = tokenHandle(inputString);
        System.out.println("Output: " + outputString);
    }
}