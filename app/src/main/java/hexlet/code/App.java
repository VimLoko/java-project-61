package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Engine game = null;
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Cli.greeting();
                break;
            case 2:
                game = new Even();
                break;
            case 3:
                game = new Calc();
                break;
            case 4:
                game = new Gcd();
                break;
            case 5:
                game = new Progression();
                break;
            case 6:
                game = new Prime();
                break;
            default: System.exit(0);
        }

        if (game != null) {
            game.play();
        }
    }
}
