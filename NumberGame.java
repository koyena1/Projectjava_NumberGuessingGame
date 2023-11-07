import java.util.Random;
import java.util.Scanner;

class Game {
    int computer;
    int maxAttempts;
    int attempts;
    int score;

    public Game(int maxAttempts) {
        Random rand = new Random();
        computer = rand.nextInt(100);
        System.out.println("Guess the random number from 1 to 100");
        this.maxAttempts = maxAttempts;
        attempts = 0;
        score = 0;
    }

   public int getComputerNumber() {
       return computer;
   }
}

public class NumberGame {
    static int userInput() {
        int user;
        System.out.print("Enter your guess: ");
        Scanner sc = new Scanner(System.in);
        user = sc.nextInt();
        return user;
    }

    static void isCorrectNumber(int user, int computer, Game game) {
        game.attempts++;
        if (user == computer) {
            System.out.println("Congratulations! You guessed the correct number.");
            game.score += game.maxAttempts - game.attempts + 1;
        } else if (user > computer) {
            System.out.println("Your number is higher than the computer number.");
        } else {
            System.out.println("Your number is lower than the computer number.");
        }
    }

    public static void main(String[] args) {
        int rounds = 3; // Number of rounds
        int maxAttempts = 10; // Maximum attempts per round
        int totalScore = 0;

        for (int round = 1; round <= rounds; round++) {
            System.out.println("Round " + round);
            Game game = new Game(maxAttempts);

            int user, computer;
            int attempts = 0;

            while (attempts < maxAttempts) {
                user = userInput();
                computer = game.getComputerNumber();
                isCorrectNumber(user, computer, game);

                if (user == computer) {
                    break; // The user guessed the correct number
                }

                attempts++;
                if (attempts == maxAttempts) {
                    System.out.println("Out of attempts. The correct number was " + computer);
                }
            }

            System.out.println("Round " + round + " score: " + game.score);
            totalScore += game.score;
        }

        System.out.println("Total score: " + totalScore);
    }
}
