package com.words.wordfrequency;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FileWord {

	public void wordDocument() {
		Scanner in = new Scanner(System.in); // to allow user to input value
		System.out.println("Enter file path:");
		String path = in.next();
		File file = new File(path); // check file or directory path name
		Map<String, Integer> wordsMap = new HashMap<>();
		try {
			Scanner sc = new Scanner(file);
			if (sc.hasNextLine()) {
				while (sc.hasNextLine()) {
					String filePath = sc.nextLine();
					getWords(filePath, wordsMap); // code to get the word & count(method call)
				}
				Set<Map.Entry<String, Integer>> entrySet = wordsMap.entrySet(); // Map to get and word and assosciated
																				// count
				for (Map.Entry<String, Integer> entry : entrySet) {
					System.out.println("Wordname: " + entry.getKey() + ", Count: " + entry.getValue());
				}
				sc.close();
				in.close(); // Closing Resource Link
			} else {
				System.out.println("NO_PATH_INSIDE_FILE"); // Printing no path inside the file
				wordDocument();
			}

		} catch (Exception e) {
			System.out.println("DATA_NOT_FOUND"); // Printing No Data found in relative paths
			wordDocument();

		}
	}

	/**
	 * Method to get words from each File
	 *
	 * @param filePath
	 * @param wordsMap
	 */
	public void getWords(String filePath, Map<String, Integer> wordsMap) {
		File file = new File(filePath);
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String[] words = sc.nextLine().split(" ");
				for (int i = 0; i < words.length; i++) {
					if (wordsMap.containsKey(words[i])) {
						int count = wordsMap.get(words[i]) + 1;
						wordsMap.put(words[i], count);
					} else {
						wordsMap.put(words[i], 1);
					}
				}

			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
