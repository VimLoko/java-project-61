package hexlet.code;

import java.util.Scanner;

public class Cli {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static String name;
    public static void greeting() {
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        name = SCANNER.nextLine();
        System.out.println("Hello, " + name);
    }

    public static String getName() {
        return name;
    }
}
