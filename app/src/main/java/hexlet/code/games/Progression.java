package hexlet.code.games;

import hexlet.code.Engine;

public class Progression extends Engine {
    protected String rules = "What number is missing in the progression?\n";
    private int progressionLength = 10;

    public Progression() {
        greeting();
    }
    @Override
    protected void play() {
        System.out.printf(rules);
        int countCorrectAnswer = 0;

        while (true) {
            int startProgression = generateRandomNum(startRange, endRange);
            int stepProgression = generateRandomNum(startRange, endRange);
            int[] progression = generateProgression(startProgression, stepProgression);
            int hiddenElementIndex = generateRandomNum(startRange, progression.length - 1);
            int hiddenElementValue = progression[hiddenElementIndex];
            System.out.printf(questionMessage, printProgression(progression, hiddenElementIndex));
            System.out.printf(answerMessage);
            int playerAnswer = scanner.nextInt();
            if (playerAnswer == hiddenElementValue) {
                countCorrectAnswer++;
                System.out.printf(correctMessage);
                if (countCorrectAnswer == countCorrectAnswers) {
                    System.out.printf(successMessage, playerName);
                    break;
                }
            } else {
                System.out.printf(error, playerAnswer, hiddenElementValue, playerName);
                break;
            }
        }
    }

    private int[] generateProgression(int startProgression, int stepProgression) {
        int[] result = new int[progressionLength];
        for (int i = startProgression, j = 0; j < result.length; i += stepProgression, j++) {
            result[j] = i;
        }
        return result;
    }

    private String printProgression(int[] progression, int hiddenElement) {
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
