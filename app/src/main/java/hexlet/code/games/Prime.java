package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {

    public static void play() {
        System.out.print("Answer 'yes' if given number is prime. Otherwise answer 'no'.\n");
        Engine.greeting();

        while (!Engine.isWin() && Engine.isGameOn()) {
            int number = Engine.generateRandomNum(Engine.getStartRange(), Engine.getEndRange());
            String isPrimeStringNumber = getIsPrimeStringAnswer(isPrime(number));
            Engine.askQuestion(String.valueOf(number));
            Engine.askAnswer();
            String playerAnswer = Engine.getScanner().nextLine();
            Engine.checkAnswer(playerAnswer, isPrimeStringNumber);
        }
    }

    private static boolean isPrime(int num) {
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

    private static String getIsPrimeStringAnswer(boolean isPrime) {
        return isPrime ? "yes" : "no";
    }
}
