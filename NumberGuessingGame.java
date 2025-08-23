import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("🎮 Welcome to Number Guessing Game!");
        System.out.println("Rules: You have 5 attempts per round. More points if you guess early!\n");

        while (playAgain) {
            int numberToGuess = rand.nextInt(100) + 1; // 1 to 100
            int attempts = 0;
            boolean guessed = false;

            System.out.println("👉 New Round Started! Guess a number between 1 and 100");

            while (attempts < 5) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("🔽 Too Low!");
                } else if (userGuess > numberToGuess) {
                    System.out.println("🔼 Too High!");
                } else {
                    System.out.println("🎉 Correct! You guessed in " + attempts + " attempts.");
                    int roundScore = (6 - attempts) * 10; // more attempts = less points
                    totalScore += roundScore;
                    System.out.println("🏆 Round Score: " + roundScore);
                    guessed = true;
                    break;
                }
            }

            if (!guessed) {
                System.out.println("❌ Out of attempts! The correct number was: " + numberToGuess);
            }

            System.out.println("⭐ Total Score: " + totalScore);

            // Ask if user wants to play again
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String choice = sc.next();
            playAgain = choice.equalsIgnoreCase("yes");
        }

        System.out.println("\n🎯 Game Over! Your Final Score: " + totalScore);
        sc.close();
    }
}
