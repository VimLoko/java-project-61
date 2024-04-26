package hexlet.code.games;

import hexlet.code.Engine;

public class Progression {
    private static final int PROGRESSION_LENGTH = 10;

    public static void play() {
        System.out.print("What number is missing in the progression?\n");
        Engine.greeting();

        while (!Engine.isWin() && Engine.isGameOn()) {
            int startProgression = Engine.generateRandomNum(Engine.getStartRange(), Engine.getEndRange());
            int stepProgression = Engine.generateRandomNum(Engine.getStartRange(), Engine.getEndRange());
            int[] progression = generateProgression(startProgression, stepProgression);
            int hiddenElementIndex = Engine.generateRandomNum(Engine.getStartRange(), progression.length - 1);
            int hiddenElementValue = progression[hiddenElementIndex];
            Engine.askQuestion(printProgression(progression, hiddenElementIndex));
            Engine.askAnswer();
            int playerAnswer = Engine.getScanner().nextInt();
            Engine.checkAnswer(playerAnswer, hiddenElementValue);
        }
    }

    private static int[] generateProgression(int startProgression, int stepProgression) {
        int[] result = new int[PROGRESSION_LENGTH];
        for (int i = startProgression, j = 0; j < result.length; i += stepProgression, j++) {
            result[j] = i;
        }
        return result;
    }

    private static String printProgression(int[] progression, int hiddenElement) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < progression.length; i++) {
            if (i != hiddenElement) {
                result.append(progression[i]).append(" ");
            } else {
                result.append("..").append(" ");
            }
        }
        return result.toString().trim();
    }
}
