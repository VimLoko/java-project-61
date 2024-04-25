package hexlet.code;

import java.util.Scanner;

public class Even {
    private final String rules = "Answer 'yes' if the number is even, otherwise answer 'no'.\n";
    private final String error = "'%s' is wrong answer ;(. Correct answer was '%s'\n";
    private final String correctMessage = "Correct!\n";
    private final String questionMessage = "Question: %d\n";
    private final String answerMessage = "Your answer: ";
    private final String successMessage = "Congratulations, %s!\n";
    private final Scanner scanner = new Scanner(System.in);
    private final int countCorrectAnswers = 3;
    private final int startRange = 0;
    private final int endRange = 20;
    private final String playerName;

    public Even(String name) {
        this.playerName = name;
    }

    public void play() {
        System.out.printf(rules);
        int countCorrectAnswer = 0;

        while (true) {
            int number = generateRandomNum(startRange, endRange);
            String isEvenStringNumber = getIsEvenStringAnswer(isEven(number));
            System.out.printf(questionMessage, number);
            System.out.printf(answerMessage);
            String playerAnswer = scanner.nextLine();
            if (playerAnswer.equals(isEvenStringNumber)) {
                countCorrectAnswer++;
                System.out.printf(correctMessage);
                if (countCorrectAnswer == countCorrectAnswers) {
                    System.out.printf(successMessage, playerName);
                    break;
                }
            } else {
                System.out.printf(error, playerAnswer, isEvenStringNumber);
                break;
            }
        }
    }

    private int generateRandomNum(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    private boolean isEven(int num) {
        return num % 2 == 0;
    }

    private String getIsEvenStringAnswer(boolean isEven) {
        return isEven ? "yes" : "no";
    }

}
