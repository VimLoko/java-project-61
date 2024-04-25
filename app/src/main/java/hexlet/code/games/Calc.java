package hexlet.code.games;

import hexlet.code.Engine;

public class Calc extends Engine {
    private String[] operations = {"+", "-", "*"};

    public Calc() {
        setRules("What is the result of the expression?\n");
        greeting();
    }

    @Override
    public void play() {
        int countCorrectAnswer = 0;

        while (true) {
            int firstNum = generateRandomNum(getStartRange(), getEndRange());
            int secondNum = generateRandomNum(getStartRange(), getEndRange());
            String operation = getOperation();
            int result = calculate(firstNum, secondNum, operation);
            System.out.printf(getQuestionMessage(), getStringView(firstNum, secondNum, operation));
            System.out.printf(getAnswerMessage());
            int playerAnswer = getScanner().nextInt();
            if (playerAnswer == result) {
                countCorrectAnswer++;
                System.out.printf(getCorrectMessage());
                if (countCorrectAnswer == getCountCorrectAnswers()) {
                    System.out.printf(getSuccessMessage(), getPlayerName());
                    break;
                }
            } else {
                System.out.printf(getError(), playerAnswer, result, getPlayerName());
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
