package hexlet.code.games;

import hexlet.code.Engine;

public class Even extends Engine {
    private String rules = "Answer 'yes' if the number is even, otherwise answer 'no'.\n";

    public Even() {
        greeting();
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
                System.out.printf(error, playerAnswer, isEvenStringNumber, playerName);
                break;
            }
        }
    }

    private boolean isEven(int num) {
        return num % 2 == 0;
    }

    private String getIsEvenStringAnswer(boolean isEven) {
        return isEven ? "yes" : "no";
    }

}
