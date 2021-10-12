package ru.mephi.lab3;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class WordCounter {

    public static LinkedHashMap<String, Integer> countWords(String input) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap();
        for(String word: input.split("[, :?.]+")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println(countWords(input));
        sc.close();
    }
}
