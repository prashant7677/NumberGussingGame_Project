import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        boolean playAgain = true;

        // Loop to allow multiple rounds
        while (playAgain) {
            System.out.println("Enter the minimum value of the range:");
            int min = scanner.nextInt();
            System.out.println("Enter the maximum value of the range:");
            int max = scanner.nextInt();

            Random random = new Random();
            int numberToGuess = random.nextInt(max - min + 1) + min;
            int numberOfAttempts = 0;
            boolean guessedCorrectly = false;

            // Limit the number of attempts
            int maxAttempts = 10;

            System.out.println("Guess the number between " + min + " and " + max + ":");

            // Loop to allow multiple guesses within the allowed number of attempts
            while (numberOfAttempts < maxAttempts && !guessedCorrectly) {
                System.out.println("Enter your guess:");
                int userGuess = scanner.nextInt();
                numberOfAttempts++;

                if (userGuess == numberToGuess) {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the correct number in " + numberOfAttempts + " attempts.");
                    score++;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
            }

            // Ask the user if they want to play another round
            System.out.println("Do you want to play another round? (yes/no)");
            String userResponse = scanner.next();
            if (userResponse.equalsIgnoreCase("no")) {
                playAgain = false;
            }
        }

        // Display the user's score
        System.out.println("Your score: " + score);
        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
