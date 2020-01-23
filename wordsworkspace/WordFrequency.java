package com.exercise.frequency.words.service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class WordFrequency {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Please enter file path:");
    String path = in.next();
    File file = new File(path);
    Map<String, Integer> wordsMap = new HashMap<>();
    try {
      Scanner sc = new Scanner(file);
      while(sc.hasNextLine()) {
        String filePath = sc.nextLine();
        getWords(filePath, wordsMap);
      }
      Set<Map.Entry<String, Integer>> entrySet = wordsMap.entrySet();
      for(Map.Entry<String, Integer> entry : entrySet) {
        System.out.println("Key = " + entry.getKey() + ", count = " + entry.getValue());
      }
      sc.close();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Method to get words from each File
   *
   * @param filePath
   * @param wordsMap
   */
  private static void getWords(String filePath, Map<String, Integer> wordsMap) {
    File file = new File(filePath);
    try {
      Scanner sc = new Scanner(file);
      while(sc.hasNextLine()) {
        String[] words = sc.nextLine().split(" ");
        for(int i = 0; i < words.length; i++) {
          if(wordsMap.containsKey(words[i])) {
            int count = wordsMap.get(words[i]) + 1;
            wordsMap.put(words[i], count);
          } else {
            wordsMap.put(words[i], 1);
          }
        }

      }
      sc.close();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
