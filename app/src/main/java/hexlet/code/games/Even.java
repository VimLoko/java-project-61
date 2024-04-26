package hexlet.code.games;

import hexlet.code.Engine;

public class Even {

    public static void play() {
        System.out.print("Answer 'yes' if the number is even, otherwise answer 'no'.\n");
        Engine.greeting();

        while (!Engine.isWin() && Engine.isGameOn()) {
            int number = Engine.generateRandomNum(Engine.getStartRange(), Engine.getEndRange());
            String isEvenStringNumber = getIsEvenStringAnswer(isEven(number));
            Engine.askQuestion(String.valueOf(number));
            Engine.askAnswer();
            String playerAnswer = Engine.getScanner().nextLine();
            Engine.checkAnswer(playerAnswer, isEvenStringNumber);
        }
    }

    private static boolean isEven(int num) {
        return num % 2 == 0;
    }

    private static String getIsEvenStringAnswer(boolean isEven) {
        return isEven ? "yes" : "no";
    }

}
