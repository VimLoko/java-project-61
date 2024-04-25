package hexlet.code.games;

import hexlet.code.Engine;

public class Prime extends Engine {

    public Prime() {
        setRules("Answer 'yes' if given number is prime. Otherwise answer 'no'.\n");
        greeting();
    }

    @Override
    protected void play() {
        int countCorrectAnswer = 0;

        while (true) {
            int number = generateRandomNum(getStartRange(), getEndRange());
            String isEvenStringNumber = getIsPrimeStringAnswer(isPrime(number));
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

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0 && i != num) {
                return false;
            }
        }
        return true;
    }

    private String getIsPrimeStringAnswer(boolean isPrime) {
        return isPrime ? "yes" : "no";
    }
}
