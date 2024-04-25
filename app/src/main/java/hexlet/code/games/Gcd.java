package hexlet.code.games;

import hexlet.code.Engine;

public class Gcd extends Engine {

    public Gcd() {
        setRules("Find the greatest common divisor of given numbers.\n");
        greeting();
    }

    @Override
    protected void play() {
        int countCorrectAnswer = 0;

        while (true) {
            int firstNum = generateRandomNum(getStartRange(), getEndRange());
            int secondNum = generateRandomNum(getStartRange(), getEndRange());
            int result = calculateGcd(firstNum, secondNum);
            System.out.printf(getQuestionMessage(), getStringView(firstNum, secondNum));
            System.out.printf(getAnswerMessage());
            int playerAnswer = getScanner().nextInt();
            if (playerAnswer == result) {
                countCorrectAnswer++;
                System.out.printf(getCorrectMessage());
                if (countCorrectAnswer == getCountCorrectAnswers()) {
                    System.out.printf(getSuccessMessage(), getPlayerName());
                    break;
                }
            } else {
                System.out.printf(getError(), playerAnswer, result, getPlayerName());
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
