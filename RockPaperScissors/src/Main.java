import java.util.Scanner;
import java.util.Random;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Owen on 8/4/2016.
 */
public class Main {

    static ArrayList<String> pHistoria = new ArrayList<>();
    static ArrayList<String> cHistoria = new ArrayList<>();
    static ArrayList<String> wHistoria = new ArrayList<>();

    public static void main(String args[]) {
//  TODO: add ask() recursion to restart the question process if there is an error

        cHistoria.add(0, "JOSHUA");
        wHistoria.add(0, "History");

        System.out.println("Please enter your username.");
        Scanner input = new Scanner(System.in);
        String playerName = input.nextLine();
        pHistoria.add(0, playerName);

        System.out.println("\nHello " + playerName + ", my name is JOSHUA.");
        System.out.println("Shall we play a game?");
        System.out.println("** Please type Yes or No to play **");
        for (int j = 0; j < 2000 ; j++) {

            String startMenu = input.nextLine();
            String startMenuclean = startMenu.trim().toLowerCase();
            if (startMenuclean.equals("yes")) {
                System.out.println("\nLet's play Rock, Paper, Scissors.");
                System.out.println("What is your move?");

                for (int i = pHistoria.size(); i < 2000; i++) {
                    playerRPS(i);
                    computerRPS(i);
                    wHistoria.add(champion(pHistoria.get(i), cHistoria.get(i)));
                }
            } else {
                System.out.println("The world has ended. Goodbye.");
                System.exit(0);
            }
        }

    }

    public static void playerRPS(int g) {
        System.out.println("** Please type Rock, Paper, or Scissors **");
        System.out.println("** Type History to see winner history **\n");

        Scanner input = new Scanner(System.in);
        String defend = input.nextLine();
        String defendClean = defend.trim().toLowerCase();
        if (defendClean.equals("rock")) {
            defendClean = "rock";
        } else if (defendClean.equals("scissors") || defendClean.equals("scissor")) {
            defendClean = "scissors";
        } else if (defendClean.equals("paper")) {
            defendClean = "paper";
        }

        if (defendClean.equals("rock")) {
            pHistoria.add(g, "rock");
        } else if (defendClean.equals("scissors")) {
            pHistoria.add(g, "scissors");
        } else if (defendClean.equals("paper")) {
            pHistoria.add(g, "paper");
        } else if (defendClean.equals("history")) {
            System.out.println("Your Historical Records");
            for (int i = 1; i < pHistoria.size(); i++) {
                System.out.println(wHistoria.get(i) + " - " + pHistoria.get(i) + " vs " + cHistoria.get(i) + "\n");
            }

        } else {
            System.out.println("ERROR - DOES NOT COMPUTE");
            System.out.println("Would you like to play again?\n");
            String startMenu = input.nextLine();
            String startMenuclean = startMenu.trim().toLowerCase();
            if (startMenuclean.equals("yes")) {

                for (int i = pHistoria.size(); i < 2000; i++) {
                    playerRPS(i);
                    computerRPS(i);
                    wHistoria.add(i, champion(pHistoria.get(i), cHistoria.get(i)));

                }
            }
            else {
                System.exit(0);
            }
        }
    }

    public static void computerRPS(int e) {

        Random number = new Random();
        int value = number.nextInt(3);

            if (value == 0){
                cHistoria.add(e, "rock");
            } else if (value == 1) {
                cHistoria.add(e, "scissors");
            } else if (value == 2) {
                cHistoria.add(e, "paper");
            }

        }

    public static String champion(String c1, String c2) {
            String result = "";
            switch (c1) {
                case "rock":
                    switch (c2) {
                        case "rock":
                            System.out.println("I used rock. We have tied.\n");
                            result = "Tie";
                            break;
                        case "paper":
                            System.out.println("I used paper. You have lost. Imminent destruction ahead.\n");
                            result = "Lose";
                            break;
                        case "scissors":
                            System.out.println("I used scissors. You have won. Let's play again.\n");
                            result = "Win";
                    }
                    break;

                case "paper":
                    switch (c2) {
                        case "paper":
                            System.out.println("I used paper. We have tied.\n");
                            result = "Tie";
                            break;
                        case "scissors":
                            System.out.println("I used scissors. You have lost. Imminent destruction ahead.\n");
                            result = "Lose";
                            break;
                        case "rock":
                            System.out.println("I used rock. You have won. Let's play again.\n");
                            result = "Win";

                    }
                    break;

                case "scissors":
                    switch (c2){
                        case "scissors":
                            System.out.println("I used scissors. We have tied.\n");
                            result = "Tie";
                            break;
                        case "rock":
                            System.out.println("I used rock. You have lost. Imminent destruction ahead.\n");
                            result = "Lose";
                            break;
                        case "paper":
                            System.out.println("I used paper. You have won. Let's play again.\n");
                            result = "Win";

                    }
                    break;
            }

            return result;
        }
}