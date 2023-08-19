import java.util.Random;
import java.util.Scanner;

public class NumberGame 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int minRange = 1;
		int maxRange = 100;
		int maxAttempts = 10;
		int score = 0;
		boolean playAgain = true;

		System.out.println("Welcome to the Number Guessing Game!");

		while (playAgain) 
		{
			int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
			int attempts = 0;
			boolean guessedCorrectly = false;

			System.out.println("I have selected a number between " + minRange + " and " + maxRange + ".");
			System.out.println("You have " + maxAttempts + " attempts to guess it.");

			while (attempts < maxAttempts) 
			{
				System.out.print("Enter your guess: ");
				int userGuess = scanner.nextInt();
				attempts++;

				if (userGuess == targetNumber) 
				{
					System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
					guessedCorrectly = true;
					score++;
					break;
				} 
				else if (userGuess < targetNumber) 
				{
					System.out.println("Your guess is too low. Try again.");
				} 
				else 
				{
					System.out.println("Your guess is too high. Try again.");
				}
			}

			if (!guessedCorrectly) 
			{
				System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
			}

			System.out.print("Do you want to play again? (yes/no): ");
			String playAgainResponse = scanner.next().toLowerCase();
			playAgain = playAgainResponse.equals("yes");

			if (!playAgain) 
			{
				System.out.println("Game Over. Your total score: " + score);
			}
		}

		scanner.close();
	}
}