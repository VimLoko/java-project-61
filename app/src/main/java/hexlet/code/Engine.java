package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static String rules = "";
    private static String introduceMessage = "Welcome to the Brain Games!\nMay I have your name? ";
    private static String greetingMessage = "Hello, %s!\n";
    private static String error = "'%s' is wrong answer ;(. Correct answer was '%s'\nLet's try again, %s!\n";
    private static String correctMessage = "Correct!\n";
    private static String questionMessage = "Question: %s\n";
    private static String answerMessage = "Your answer: ";
    private static String successMessage = "Congratulations, %s!\n";
    private static final Scanner SCANNER = new Scanner(System.in);
    private static int countCorrectAnswers = 3;
    private static int startRange = 0;
    private static int endRange = 20;
    private static String playerName;
    private static int playerCountCorrectAnswers = 0;
    private static boolean gameOn = true;

    public static void greeting() {
        System.out.printf(introduceMessage);
        playerName = SCANNER.nextLine();
        System.out.printf(greetingMessage, playerName);
        System.out.printf(rules);
    }

    public static Scanner getScanner() {
        return SCANNER;
    }

    public static int generateRandomNum(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    public static String getRules() {
        return rules;
    }

    public static String getIntroduceMessage() {
        return introduceMessage;
    }

    public static String getGreetingMessage() {
        return greetingMessage;
    }

    public static String getError() {
        return error;
    }

    public static String getCorrectMessage() {
        return correctMessage;
    }

    public static String getQuestionMessage() {
        return questionMessage;
    }

    public static String getAnswerMessage() {
        return answerMessage;
    }

    public static String getSuccessMessage() {
        return successMessage;
    }

    public static int getCountCorrectAnswers() {
        return countCorrectAnswers;
    }

    public static int getStartRange() {
        return startRange;
    }

    public static int getEndRange() {
        return endRange;
    }

    public static String getPlayerName() {
        return playerName;
    }

    public static void setRules(String rules) {
        Engine.rules = rules;
    }

    public static void askQuestion(String question) {
        System.out.printf(getQuestionMessage(), question);
    }

    public static void askAnswer() {
        System.out.printf(Engine.getAnswerMessage());
    }

    public static void checkAnswer(String answer, String question) {
        if (answer.equals(question)) {
            winAction();
        } else {
            System.out.printf(getError(), answer, question, getPlayerName());
            gameOn = false;
        }
    }

    public static void checkAnswer(int answer, int question) {
        if (answer == question) {
            winAction();
        } else {
            System.out.printf(getError(), answer, question, getPlayerName());
            gameOn = false;
        }
    }

    private static void winAction() {
        playerCountCorrectAnswers++;
        System.out.printf(getCorrectMessage());
        if (playerCountCorrectAnswers == countCorrectAnswers) {
            System.out.printf(getSuccessMessage(), getPlayerName());
            gameOn = false;
        }
    }

    public static int getPlayerCountCorrectAnswers() {
        return playerCountCorrectAnswers;
    }

    public static boolean isWin() {
        return getPlayerCountCorrectAnswers() == getCountCorrectAnswers();
    }

    public static void printDescription() {
        System.out.printf(getRules());
    }

    public static boolean isGameOn() {
        return gameOn;
    }
}
