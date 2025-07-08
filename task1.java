import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 5;
        int score = 0;
        boolean playAgain;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int numberToGuess = random.nextInt(100) + 1;
            int attemptsLeft = maxAttempts;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.next(); // clear invalid input
                    continue;
                }

                int userGuess = scanner.nextInt();
                attemptsLeft--;

                if (userGuess == numberToGuess) {
                    System.out.println("Correct! You guessed the number!");
                    guessedCorrectly = true;
                    score++;
                    break;
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Attempts left: " + attemptsLeft);
                } else {
                    System.out.println("Too low! Attempts left: " + attemptsLeft);
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You've used all your attempts. The correct number was: " + numberToGuess);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            scanner.nextLine(); // clear newline
            String response = scanner.nextLine().trim();
            playAgain = response.equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Game Over! Your total score: " + score);
        scanner.close();
    }
}
