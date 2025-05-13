import java.util.Random;
import java.util.Scanner;

public class Ludogame {

    static final int WINNING_POSITION = 25;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int player1Position = 0;
        int player2Position = 0;

        boolean player1Turn = true;

        System.out.println("Welcome to Simple Ludo Game!");
        System.out.println("First to reach " + WINNING_POSITION + " wins!");
        System.out.println("----------------------------------");

        while (player1Position < WINNING_POSITION && player2Position < WINNING_POSITION) {
            System.out.println((player1Turn ? "Player 1" : "Player 2") + "'s turn. Press Enter to roll the dice...");
            scanner.nextLine();

            int diceRoll = random.nextInt(6) + 1;
            System.out.println("You rolled a " + diceRoll + "!");

            if (player1Turn) {
                player1Position = movePlayer(player1Position, diceRoll);
                System.out.println("Player 1's new position: " + player1Position);
                if (player1Position == WINNING_POSITION) {
                    System.out.println("🎉 Player 1 wins the game! 🎉");
                    break;
                }
            } else {
                player2Position = movePlayer(player2Position, diceRoll);
                System.out.println("Player 2's new position: " + player2Position);
                if (player2Position == WINNING_POSITION) {
                    System.out.println("🎉 Player 2 wins the game! 🎉");
                    break;
                }
            }

            if (diceRoll != 6) {
                player1Turn = !player1Turn;  // If dice is 6, player gets another chance
            }
            System.out.println("----------------------------------");
        }
        scanner.close();
    }

    public static int movePlayer(int currentPosition, int diceRoll) {
        int newPosition = currentPosition + diceRoll;
        if (newPosition > WINNING_POSITION) {
            System.out.println("You need exact " + (WINNING_POSITION - currentPosition) + " to win. Try again next time!");
            return currentPosition;
        }
        return newPosition;
    }
}
