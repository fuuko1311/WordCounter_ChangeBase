package Controller;

import Model.ChangeBase;
import Model.WordCounter;
import View.Menu;

import java.util.Map;
import java.util.Scanner;

public class Programming extends Menu {
    private static final String[] MENU_CHOICES = {"Count letter", "Convert base system", "Exit"};
    private final WordCounter wordCounter;
    private final ChangeBase changeBase;

    public Programming() {
        super("COUNT CHARACTER AND CONVERT BASE PROGRAM", MENU_CHOICES);
        wordCounter = new WordCounter();
        changeBase = new ChangeBase();
    }

    @Override
    public void execute(int ch) {
        Scanner scanner = new Scanner(System.in);

        switch (ch) {
            case 1:
                System.out.print("Enter the text: ");
                String inputText = scanner.nextLine();
                wordCounter.setInputString(inputText);
                Map<String, Integer> wordOccurrences = wordCounter.getWordOccurrences();
                Map<Character, Integer> charOccurrences = wordCounter.getLetterOccurrences();
                System.out.println(wordOccurrences);
                System.out.println(charOccurrences);

                int wordCount = WordCounter.countWords(inputText);
                int charCount = WordCounter.countCharacters(inputText);
                System.out.println("Word count: " + wordCount);
                System.out.println("Character count: " + charCount);

                break;

            case 2:
                System.out.print("Enter the input value: ");
                String inputValue = scanner.nextLine();

                System.out.print("Enter the input base (2, 10, or 16): ");
                int inputBase = scanner.nextInt();

                System.out.print("Enter the output base (2, 10, or 16): ");
                int outputBase = scanner.nextInt();

                if (inputBase == 2 || inputBase == 10 || inputBase == 16) {
                    if (outputBase == 2 || outputBase == 10 || outputBase == 16) {
                        String outputValue = ChangeBase.convertBase(inputValue, inputBase, outputBase);
                        System.out.println("Output value: " + outputValue);
                    } else {
                        System.out.println("Invalid output base. Please enter 2, 10, or 16.");
                    }
                } else {
                    System.out.println("Invalid input base. Please enter 2, 10, or 16.");
                }
                break;

            case 3:
                System.exit(0);

            default:
                System.out.println("Invalid choice. Please choose a valid option.");
                break;
        }
    }
    public static void main(String[] args) {
        new Programming().run();
    }
}
