package hexlet.code.games;

import hexlet.code.Engine;

public class Even extends Engine {

    public Even() {
        setRules("Answer 'yes' if the number is even, otherwise answer 'no'.\n");
        greeting();
    }

    @Override
    public void play() {
        int countCorrectAnswer = 0;

        while (true) {
            int number = generateRandomNum(getStartRange(), getEndRange());
            String isEvenStringNumber = getIsEvenStringAnswer(isEven(number));
            System.out.printf(getQuestionMessage(), number);
            System.out.printf(getAnswerMessage());
            String playerAnswer = getScanner().nextLine();
            if (playerAnswer.equals(isEvenStringNumber)) {
                countCorrectAnswer++;
                System.out.printf(getCorrectMessage());
                if (countCorrectAnswer == getCountCorrectAnswers()) {
                    System.out.printf(getSuccessMessage(), getPlayerName());
                    break;
                }
            } else {
                System.out.printf(getError(), playerAnswer, isEvenStringNumber, getPlayerName());
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
