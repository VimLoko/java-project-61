package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    private static String[] operations = {"+", "-", "*"};

    public static void play() {
        System.out.print("What is the result of the expression?\n");
        Engine.greeting();

        while (!Engine.isWin() && Engine.isGameOn()) {
            int firstNum = Engine.generateRandomNum(Engine.getStartRange(), Engine.getEndRange());
            int secondNum = Engine.generateRandomNum(Engine.getStartRange(), Engine.getEndRange());
            String operation = getOperation();
            int result = calculate(firstNum, secondNum, operation);
            Engine.askQuestion(getStringView(firstNum, secondNum, operation));
            Engine.askAnswer();
            int playerAnswer = Engine.getScanner().nextInt();
            Engine.checkAnswer(playerAnswer, result);
        }
    }

    private static String getOperation() {
        return operations[Engine.generateRandomNum(0, operations.length - 1)];
    }

    private static String getStringView(int firstNum, int secondNum, String operation) {
        return String.format("%d %s %d", firstNum, operation, secondNum);
    }

    private static int calculate(int firstNum, int secondNum, String operation) {
        return switch (operation) {
            case "+" -> firstNum + secondNum;
            case "-" -> firstNum - secondNum;
            case "*" -> firstNum * secondNum;
            default -> throw new IllegalStateException("Unexpected value: " + operation);
        };
    }


}
