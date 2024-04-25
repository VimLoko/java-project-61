package hexlet.code.games;

import hexlet.code.Engine;

public class Calc extends Engine {

    private String rules = "What is the result of the expression?\n";
    private String[] operations = {"+", "-", "*"};

    public Calc() {
        greeting();
    }

    public void play() {
        System.out.printf(rules);
        int countCorrectAnswer = 0;

        while (true) {
            int firstNum = generateRandomNum(startRange, endRange);
            int secondNum = generateRandomNum(startRange, endRange);
            String operation = getOperation();
            int result = calculate(firstNum, secondNum, operation);
            System.out.printf(questionMessage, getStringView(firstNum, secondNum, operation));
            System.out.printf(answerMessage);
            int playerAnswer = scanner.nextInt();
            if (playerAnswer == result) {
                countCorrectAnswer++;
                System.out.printf(correctMessage);
                if (countCorrectAnswer == countCorrectAnswers) {
                    System.out.printf(successMessage, playerName);
                    break;
                }
            } else {
                System.out.printf(error, playerAnswer, result, playerName);
                break;
            }
        }
    }

    private String getOperation() {
        return operations[generateRandomNum(0, operations.length - 1)];
    }

    private String getStringView(int firstNum, int secondNum, String operation) {
        return String.format("%d %s %d", firstNum, operation, secondNum);
    }

    private int calculate(int firstNum, int secondNum, String operation) {
        return switch (operation) {
            case "+" -> firstNum + secondNum;
            case "-" -> firstNum - secondNum;
            case "*" -> firstNum * secondNum;
            default -> throw new IllegalStateException("Unexpected value: " + operation);
        };
    }


}
