package hexlet.code.games;

import hexlet.code.Engine;

public class Prime extends Engine {
    protected String rules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.\n";

    public Prime() {
        greeting();
    }

    @Override
    protected void play() {
        int countCorrectAnswer = 0;

        while (true) {
            int number = generateRandomNum(startRange, endRange);
            String isEvenStringNumber = getIsPrimeStringAnswer(isPrime(number));
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
