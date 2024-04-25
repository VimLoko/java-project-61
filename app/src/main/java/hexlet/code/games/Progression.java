package hexlet.code.games;

import hexlet.code.Engine;

public class Progression extends Engine {
    private final int progressionLength = 10;

    public Progression() {
        setRules("What number is missing in the progression?\n");
        greeting();
    }
    @Override
    protected void play() {
        int countCorrectAnswer = 0;

        while (true) {
            int startProgression = generateRandomNum(getStartRange(), getEndRange());
            int stepProgression = generateRandomNum(getStartRange(), getEndRange());
            int[] progression = generateProgression(startProgression, stepProgression);
            int hiddenElementIndex = generateRandomNum(getStartRange(), progression.length - 1);
            int hiddenElementValue = progression[hiddenElementIndex];
            System.out.printf(getQuestionMessage(), printProgression(progression, hiddenElementIndex));
            System.out.printf(getAnswerMessage());
            int playerAnswer = getScanner().nextInt();
            if (playerAnswer == hiddenElementValue) {
                countCorrectAnswer++;
                System.out.printf(getCorrectMessage());
                if (countCorrectAnswer == getCountCorrectAnswers()) {
                    System.out.printf(getSuccessMessage(), getPlayerName());
                    break;
                }
            } else {
                System.out.printf(getError(), playerAnswer, hiddenElementValue, getPlayerName());
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
