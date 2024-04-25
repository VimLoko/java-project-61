package hexlet.code;

import java.util.Scanner;

public class Cli {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void greeting() {
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        System.out.println("Hello, " + SCANNER.nextLine());
    }
}
