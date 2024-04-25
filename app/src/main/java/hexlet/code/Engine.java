package hexlet.code;

import java.util.Scanner;

public abstract class Engine {
    protected String rules = "";
    protected String introduceMessage = "Welcome to the Brain Games!\nMay I have your name? ";
    protected String greetingMessage = "Hello, %s!";
    protected String error = "'%s' is wrong answer ;(. Correct answer was '%s'\nLet's try again, %s!\n";
    protected String correctMessage = "Correct!\n";
    protected String questionMessage = "Question: %s\n";
    protected String answerMessage = "Your answer: ";
    protected String successMessage = "Congratulations, %s!\n";
    protected final Scanner scanner = new Scanner(System.in);
    protected int countCorrectAnswers = 3;
    protected int startRange = 0;
    protected int endRange = 20;
    protected String playerName;
    protected abstract void play();

    protected void greeting() {
        System.out.printf(introduceMessage);
        playerName = scanner.nextLine();
        System.out.printf(greetingMessage, playerName);
        System.out.printf(rules);
    }

    protected int generateRandomNum(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }
}
