package hexlet.code;

import java.util.Scanner;

public abstract class Engine {
    private String rules = "";
    private String introduceMessage = "Welcome to the Brain Games!\nMay I have your name? ";
    private String greetingMessage = "Hello, %s!\n";
    private String error = "'%s' is wrong answer ;(. Correct answer was '%s'\nLet's try again, %s!\n";
    private String correctMessage = "Correct!\n";
    private String questionMessage = "Question: %s\n";
    private String answerMessage = "Your answer: ";
    private String successMessage = "Congratulations, %s!\n";
    private final Scanner scanner = new Scanner(System.in);
    private int countCorrectAnswers = 3;
    private int startRange = 0;
    private int endRange = 20;
    private String playerName;
    protected abstract void play();

    protected void greeting() {
        System.out.printf(introduceMessage);
        playerName = scanner.nextLine();
        System.out.printf(greetingMessage, playerName);
        System.out.printf(getRules());
    }

    protected int generateRandomNum(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    public String getRules() {
        return rules;
    }

    public String getIntroduceMessage() {
        return introduceMessage;
    }

    public String getGreetingMessage() {
        return greetingMessage;
    }

    public String getError() {
        return error;
    }

    public String getCorrectMessage() {
        return correctMessage;
    }

    public String getQuestionMessage() {
        return questionMessage;
    }

    public String getAnswerMessage() {
        return answerMessage;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public int getCountCorrectAnswers() {
        return countCorrectAnswers;
    }

    public int getStartRange() {
        return startRange;
    }

    public int getEndRange() {
        return endRange;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }
}
