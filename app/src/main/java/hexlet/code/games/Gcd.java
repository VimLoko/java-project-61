package hexlet.code.games;

import hexlet.code.Engine;

public class Gcd extends Engine {
    protected String rules = "Find the greatest common divisor of given numbers.\n";

    public Gcd() {
        greeting();
    }

    @Override
    protected void play() {
        System.out.printf(rules);
        int countCorrectAnswer = 0;

        while (true) {
            int firstNum = generateRandomNum(startRange, endRange);
            int secondNum = generateRandomNum(startRange, endRange);
            int result = calculateGcd(firstNum, secondNum);
            System.out.printf(questionMessage, getStringView(firstNum, secondNum));
            System.out.printf(answerMessage);
            int playerAnswer = scanner.nextInt();
            if (playerAnswer == result) {
                countCorrectAnswer++;
                System.out.printf(correctMessage);
                if (countCorrectAnswer == countCorrectAnswers) {
                    System.out.printf(successMessage, playerName);
                    break;
                }
            } else {
                System.out.printf(error, playerAnswer, result, playerName);
                break;
            }
        }
    }

    private String getStringView(int firstNum, int secondNum) {
        return String.format("%d %d", firstNum, secondNum);
    }

    private int calculateGcd(int firstNum, int secondNum) {
        while (firstNum != 0 && secondNum != 0) {
            if (firstNum > secondNum) {
                firstNum = firstNum % secondNum;
            } else {
                secondNum = secondNum % firstNum;
            }
        }
        return firstNum + secondNum;
    }
}
