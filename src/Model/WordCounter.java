package Model;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class WordCounter {
    public static int countWords(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input);
        return tokenizer.countTokens();
    }

    public static int countCharacters(String input) {
        return input.length();
    }
    private String inputString = "";

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public String getInputString() {
        return inputString;
    }

    public Map<String, Integer> getWordOccurrences() {
        Map<String, Integer> wordOccurrences = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(inputString);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            wordOccurrences.put(token, wordOccurrences.getOrDefault(token, 0) + 1);
        }

        return wordOccurrences;
    }

    public Map<Character, Integer> getLetterOccurrences() {
        Map<Character, Integer> letterOccurrences = new HashMap<>();

        for (char character : inputString.toCharArray()) {
            if (Character.isLetter(character)) {
                letterOccurrences.put(character, letterOccurrences.getOrDefault(character, 0) + 1);
            }
        }

        return letterOccurrences;
    }
}
