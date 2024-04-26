package hexlet.code.games;

import hexlet.code.Engine;

public class Gcd {


    public static void play() {
        System.out.print("Find the greatest common divisor of given numbers.\n");
        Engine.greeting();

        while (!Engine.isWin() && Engine.isGameOn()) {
            int firstNum = Engine.generateRandomNum(Engine.getStartRange(), Engine.getEndRange());
            int secondNum = Engine.generateRandomNum(Engine.getStartRange(), Engine.getEndRange());
            int result = calculateGcd(firstNum, secondNum);
            Engine.askQuestion(getStringView(firstNum, secondNum));
            Engine.askAnswer();
            int playerAnswer = Engine.getScanner().nextInt();
            Engine.checkAnswer(playerAnswer, result);
        }
    }

    private static String getStringView(int firstNum, int secondNum) {
        return String.format("%d %d", firstNum, secondNum);
    }

    private static int calculateGcd(int firstNum, int secondNum) {
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
