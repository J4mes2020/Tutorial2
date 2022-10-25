import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Game {


    static String player1Score = "";
    static String player2Score = "";
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int dice1;
        int dice2;

        System.out.println("\n NEW GAME \n");
        for (int i = 1; i < 21; i++) {
            boolean playerSelector = (i % 2 != 0);
            try {
                Thread.sleep(2);
                if (playerSelector) {
                    System.out.println("Player 1 Turn");
                } else {
                    System.out.println("Player 2 Turn");
                }
                System.out.println("Do you want to hold or roll:");

                if (scanner.nextLine().equalsIgnoreCase("roll")) {

                    dice1 = Die.roll();
                    dice2 = Die.roll();
                    Thread.sleep(2);


                    if (dice1 >= dice2) {
                        if (playerSelector) {
                            player1Score = concatenateDigits(dice1, dice2);
                        } else {
                            player2Score = concatenateDigits(dice1, dice2);
                        }
                    }

                    if (dice2 >= dice1) {
                        if (playerSelector) {
                            player1Score = concatenateDigits(dice2, dice1);
                        } else {
                            player2Score = concatenateDigits(dice2, dice1);
                        }
                    }
                    System.out.println("You rolled a " + dice1 + " and a " + dice2);
                    if (playerSelector) {
                        System.out.println("Your current total is " + player1Score);
                    } else {
                        System.out.println("Your current total is " + player2Score);

                    }
                }


            } catch (InterruptedException ignored) {
            }
        }
        createFile();
        System.out.println("Player 1 Score: " + player1Score);
        System.out.println("Player 2 Score: " + player2Score);
    }

    private static String concatenateDigits(int... digits) {
        StringBuilder sb = new StringBuilder(digits.length);
        for (int digit : digits) {
            sb.append(digit);
        }
        return sb.toString();
    }

    private static void createFile() {

        File resultsFile = new File("results.txt");
        try {
            if (resultsFile.createNewFile()) {

            }
            writeToFile(resultsFile, "Player 1 Score: " + player1Score + "\n");
            writeToFile(resultsFile, "Player 2 Score: " + player2Score + "\n");

        }
        catch (IOException ignored) {

        }

    }

    private static void writeToFile(File file, String input) {

        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(input);
            writer.close();

        }
        catch (IOException ignored) {

        }
    }
}
        
